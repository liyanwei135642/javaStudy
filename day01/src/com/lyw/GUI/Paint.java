package com.lyw.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.lang.System.exit;

/**
 * 实现画图功能
 */
public class Paint {
    public static void main(String[] args) {
        Frame frame = new Frame("画图板");
        frame.setBounds(300,100,700,500);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit(0);
            }
        });
        Panel p1=new Panel();
        frame.add(p1,BorderLayout.SOUTH);
        TextField text=new TextField(80);
        text.repaint();
        p1.add(text);
        Panel p2=new Panel();
        frame.add(p2);
        PaintArea area=new PaintArea();
        Color color = new Color(0, 0, 0);
        area.shapes.add(new Shape(color,0,0,0,0,true,color));
        p2.add(area);
        text.addActionListener(e->{
            String text1 = text.getText();
            String[] strs = text1.split(" ");
            if(strs.length!=4){
                return;
            }
            Shape shape = new Shape();
            shape.setX(Integer.parseInt(strs[0]));
            shape.setY(Integer.parseInt(strs[1]));
            shape.setWidth(Integer.parseInt(strs[2]));
            shape.setHeight(Integer.parseInt(strs[3]));
            area.shapes.add(shape);
            area.repaint();
        });
        p2.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                area.setSize(p2.getWidth()-20,p2.getHeight()-20);
                area.shapes.get(0).width=area.getWidth();
                area.shapes.get(0).height=area.getHeight();
            }
        });

        frame.setVisible(true);

    }
}
