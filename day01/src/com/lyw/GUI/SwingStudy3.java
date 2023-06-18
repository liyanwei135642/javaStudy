package com.lyw.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * 工具栏学习 JToolBar
 * 颜色选择器学习 JColorChooser 调用静态方法showDialog 会弹出颜色选择器对话框 返回值是选中的颜色类对象
 * Color color = JColorChooser.showDialog(父组件(null), title("请选择您要的颜色"), 默认颜色(null));
 * 文件选择器学习 JFileChooser 构造函数输入默认的打开路径
 * JFileChooser fileDialog=new JFileChooser(File.listRoots()[0].getAbsoluteFile());
 * fileDialog.setFileSelectionMode(JFileChooser.FILES_ONLY);//默认设置只选文件
 * fileDialog.setMultiSelectionEnabled(false);//默认设置不可以多选
 * fileDialog.setSelectedFile(null);//设置默认选中的文件
 */
public class SwingStudy3 {
    ImageIcon icon= new ImageIcon("icons/my.png");
    JFrame frame=new JFrame("工具栏测试");
    JFileChooser fileDialog=new JFileChooser(File.listRoots()[0].getAbsoluteFile());
    JToolBar toolBar=new JToolBar("工具栏",SwingConstants.HORIZONTAL);
    //文本框默认不支持滚动条 需要将文本框加入JScrollPane
    JTextArea textArea=new JTextArea(8,30);
    JScrollPane panel=new JScrollPane(textArea);
    Action before=new AbstractAction("上一曲",icon) {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.append("上一曲\n");
        }
    };
    Action stop=new AbstractAction("暂停",icon) {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.append("暂停播放\n");
        }
    };
    Action after=new AbstractAction("下一曲",icon) {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.append("下一曲\n");
        }
    };
    Action color=new AbstractAction("颜色",icon) {
        @Override
        public void actionPerformed(ActionEvent e) {
            Color color1 = JColorChooser.showDialog(frame, "请选择您要的颜色", null);
            textArea.setBackground(color1);
        }
    };

    Action open=new AbstractAction("打开",icon) {
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = fileDialog.showOpenDialog(null);
            File file = fileDialog.getSelectedFile();
            System.out.println(file);

        }
    };



    public static void main(String[] args) {
        new SwingStudy3().init();
    }

    public void init(){
        JButton bt1 = new JButton(before);
        JButton bt2 = new JButton(stop);
        JButton bt3 = new JButton(after);
        JButton bt4 = new JButton(color);
        JButton bt5 = new JButton(open);
        bt1.setPreferredSize(new Dimension(100,30));
        bt2.setPreferredSize(new Dimension(100,30));
        bt3.setPreferredSize(new Dimension(100,30));
        bt4.setPreferredSize(new Dimension(100,30));
        bt5.setPreferredSize(new Dimension(100,30));
        toolBar.addSeparator();
        toolBar.add(bt1);
        toolBar.addSeparator();
        toolBar.add(bt2);
        toolBar.addSeparator();
        toolBar.add(bt3);
        toolBar.addSeparator();
        toolBar.add(bt4);
        toolBar.addSeparator();
        toolBar.add(bt5);
        toolBar.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
        //设置工具栏可以拖动
        toolBar.setFloatable(true);

        //设置滚动条滚动策略
        panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        frame.add(toolBar,BorderLayout.NORTH);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



    }
}
