package com.lyw.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  AWT图形化界面学习 创建window窗口
 *  如果需要改变按钮的大小 最好将按钮的容器设置为FlowLayout
 *  如果一容器使用了布局管理器，则该容器内的组件或容器（即该容器的下一级）应该使用setPreferredSize(new Dimension(w,h));来设置尺寸;
 *  如果一容器是绝对布局，即setLayout(null)，则该容器内的组件或容器（即该容器的下一级）应该使用setSize(w,h));来设置尺寸。
 *
 */
public class AWTWindow {
    public static void main(String[] args) {





    }

    private static void dialog() {
        Frame frmae=new Frame("测试对话框");
        JButton button = new JButton("模式对话框");
        button.setLocation(200,200);
        Panel p=new Panel();
        p.setLayout(new BorderLayout());
        p.add(button);
        frmae.add(p);

        Dialog dia = new Dialog(frmae, "模式对话框", true);

        frmae.setBounds(100,100,500,500);
        frmae.setVisible(true);
        button.addActionListener(AWTWindow::test);
    }

    /**
     * 布局学习
     */
    private static void layOut() {
        //创建窗口对象
        Frame frame=new Frame("窗口布局");

        //设置窗口位置和大小
        frame.setBounds(300,50,720,600);
        //设置布局方式 windows系统默认BorderLayout
        //设置流式布局 对齐方式 左对齐 水平和垂直间距 20px
        //frame.setLayout(new FlowLayout(FlowLayout.CENTER,50,20));
        //添加100个按钮组件
//        for (int i = 0; i < 100; i++) {
//            frame.add(new JButton("按钮"+(i+1)));
//        }
        //设置边框布局 BorderLayout 它有五个区域 EAST、SOUTH、WEST、NORTH、CENTER
        frame.setLayout(new BorderLayout(20,10));
        //添加组件到指定的区域 在同一个区域添加多个组件时 只会显示最后一个组件
        frame.add(new JButton("东部区域按钮"),BorderLayout.EAST);
        frame.add(new JButton("南部区域按钮"),BorderLayout.SOUTH);
        frame.add(new JButton("西部区域按钮"),BorderLayout.WEST);
        frame.add(new JButton("北部区域按钮"),BorderLayout.NORTH);
        frame.add(new JButton("中部区域按钮"),BorderLayout.CENTER);

        //设置最佳大小
        //frame.pack();
        //设置窗口可见
        frame.setVisible(true);
    }

    /**
     * 计算器界面设计
     */
    private static void JiSuanQi() {
        //创建窗口对象
        Frame frame=new Frame("计算器");

        //将窗口设为边框布局
        frame.setLayout(new BorderLayout(0,0));

        //顶部区域添加文本框
        TextField text = new TextField(30);
        Panel top = new Panel();
        top.add(text);
        frame.add(top,BorderLayout.NORTH);

        //中部区域添加面板
        Panel panel=new Panel();
        frame.add(panel,BorderLayout.CENTER);
        //设置面板网格布局
        panel.setLayout(new GridLayout(3,5));

        //面板内添加按钮
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                panel.add(new JButton(""+i+j));
            }
        }

        //设置最佳大小
        frame.pack();
        //设置窗口可见
        frame.setVisible(true);
    }


    public static void test(ActionEvent e){
        System.out.println("465");
    }
}
