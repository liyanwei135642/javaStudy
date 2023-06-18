package com.lyw.GUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * 边框学习 JBorder
 */
public class SwingStudy2 {

    JFrame frame=new JFrame("边框测试");


    public static void main(String[] args) {
        new SwingStudy2().init();
    }


    public void init(){
        //修改默认布局为网格布局
        frame.setLayout(new GridLayout(2,4));

        //创建Panel并添加到窗口
        //创建BevelBorder
        Border bevelBorder=BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED,Color.GREEN,Color.BLUE,Color.GRAY);
        frame.add(getPanel(bevelBorder,"bevelBorder"));

        //创建LineBorder
        Border lineBorder=BorderFactory.createLineBorder(Color.RED,10);
        frame.add(getPanel(lineBorder,"lineBorder"));

        //创建EmptyBorder
        Border emptyBorder=BorderFactory.createEmptyBorder(10,5,20,10);
        frame.add(getPanel(emptyBorder,"emptyBorder"));

        //创建EtchedBorder
        Border etchedBorder=BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.RED,Color.GREEN);
        frame.add(getPanel(etchedBorder,"etchedBorder"));

        //创建TitleBorder
        Border titleBorder=new TitledBorder(lineBorder,"测试标题",TitledBorder.LEFT,TitledBorder.BOTTOM,new Font("stSong",Font.BOLD,18),Color.BLUE);
        frame.add(getPanel(titleBorder,"titleBorder"));

        //创建MatteBorder
        Border matteBorder=new MatteBorder(10,5,20,10,Color.GREEN);
        frame.add(getPanel(matteBorder,"matteBorder"));

        //创建compoundBorder
        Border compoundBorder=new CompoundBorder(lineBorder,titleBorder);
        frame.add(getPanel(compoundBorder,"compoundBorder"));


        //设置窗口
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private JPanel getPanel(Border border,String title){
        JLabel label = new JLabel(title);
        JPanel panel = new JPanel();
        panel.add(label);
        panel.setBorder(border);
        return panel;
    }


}
