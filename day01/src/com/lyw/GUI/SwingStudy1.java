package com.lyw.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * swing 图形界面 100% 纯java实现
 */
public class SwingStudy1 {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        new  SwingStudy1().init();

    }
    //声明测试窗口1所需要的各种组件
    //声明一张图标
    ImageIcon icon=new ImageIcon("icons/my.png");

    //声明一个颜色数组
    String[] colors={"红色","绿色","蓝色"};

    //声明窗口
    JFrame frame=new JFrame("测试swing基本组件");

    //声明菜单栏
    JMenuBar menuBar=new  JMenuBar();

    //声明一级菜单
    JMenu fileMenu=new JMenu("文件");
    JMenu editMenu=new JMenu("编辑");

    //声明二级菜单项
    JMenuItem auto=new JMenuItem("自动换行");
    JMenuItem copy=new JMenuItem("复制",icon);
    JMenuItem paste=new JMenuItem("粘贴",icon);
    JMenu formatMenu=new JMenu("格式");

    //声明三级菜单项
    JMenuItem comment=new JMenuItem("注释");
    JMenuItem cancelComment=new JMenuItem("取消注释");

    //声明文本域
    JTextArea textarea=new JTextArea(8,20);

    //声明列表框
    JList<String> colorList=new JList<>(colors);

    //声明选择相关组件下拉列表框
    JComboBox<String> colorSelect=new JComboBox<>(colors);

    //声明单选按钮组
    ButtonGroup bg=new ButtonGroup();

    //声明单选按钮
    JRadioButton male=new JRadioButton("男",true);
    JRadioButton female=new JRadioButton("女",false);

    //声明复选框
    JCheckBox isMarried=new JCheckBox("是否已婚",true);

    //声明底部
    JTextField tf=new JTextField(40);
    JButton ok=new JButton("确定",icon);

    //声明右键菜单
    JPopupMenu popupMenu=new JPopupMenu();

    //声明右键菜单单选项按钮组
    ButtonGroup popupBg=new ButtonGroup();

    //声明右键菜单单选项
    JRadioButtonMenuItem metalItem=new JRadioButtonMenuItem("Metal 风格");
    JRadioButtonMenuItem nimbusItem=new JRadioButtonMenuItem("Nimbus 风格",true);
    JRadioButtonMenuItem windowsItem=new JRadioButtonMenuItem("Windows 风格");
    JRadioButtonMenuItem windowsClassicItem=new JRadioButtonMenuItem("Windows 经典风格");
    JRadioButtonMenuItem motifItem=new JRadioButtonMenuItem("Motif 风格");

    public void init(){
        //组装视图
        //组装底部视图
        JPanel bottomPanel=new JPanel();
        bottomPanel.add(tf);
        bottomPanel.add(ok);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        //组装中部视图

        //创建选择相关面板 selectPanel
        JPanel selectPanel=new JPanel();

        //给颜色选择下拉框添加元素 在构造的时候已经添加 不需要下面的添加动作了
        //colorSelect.addItem("红色");
        //colorSelect.addItem("绿色");
        //colorSelect.addItem("蓝色");

        //将单选按钮加入单选按钮组
        bg.add(male);
        bg.add(female);

        //将下拉框 单选按钮 复选框 添加到 selectPanel
        selectPanel.add(colorSelect);
        selectPanel.add(male);
        selectPanel.add(female);
        selectPanel.add(isMarried);

        //创建左边垂直盒子将文本域和选择面板加入
        Box centerLeft=Box.createVerticalBox();
        centerLeft.add(textarea);
        centerLeft.add(selectPanel);

        //创建水平盒子将左边垂直盒子和右边列边框加入
        Box center=Box.createHorizontalBox();
        center.add(centerLeft);
        center.add(colorList);

        frame.add(center);

        //组装顶部
        formatMenu.add(comment);
        formatMenu.add(cancelComment);

        editMenu.add(auto);
        //添加分割线
        editMenu.addSeparator();
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.addSeparator();
        editMenu.add(formatMenu);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        frame.setJMenuBar(menuBar);

        //组装右键菜单
        popupBg.add(metalItem);
        popupBg.add(nimbusItem);
        popupBg.add(windowsItem);
        popupBg.add(windowsClassicItem);
        popupBg.add(motifItem);
        popupMenu.add(metalItem);
        popupMenu.add(nimbusItem);
        popupMenu.add(windowsItem);
        popupMenu.add(windowsClassicItem);
        popupMenu.add(motifItem);

        //为右键菜单注册信号
        metalItem.addActionListener(this::rightSignal);
        nimbusItem.addActionListener(this::rightSignal);
        windowsItem.addActionListener(this::rightSignal);
        windowsClassicItem.addActionListener(this::rightSignal);
        motifItem.addActionListener(this::rightSignal);

        //文本域添加右键菜单信号
        textarea.setComponentPopupMenu(popupMenu);

        //设置关闭模式
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置最佳大小
        //frame.pack()
        frame.setBounds(350,50,700,580);
        //显示窗口
        frame.setVisible(true);









    }

    private void rightSignal(ActionEvent e){
        System.out.println(e.getActionCommand());
        String s=e.getActionCommand();

        try {
            switch (s){
                case "Metal 风格":
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    break;
                case "Nimbus 风格":
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    break;
                case "Windows 风格":
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    break;
                case "Windows 经典风格":
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                    break;
                case "Motif 风格":
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    break;
            }
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (InstantiationException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        } catch (UnsupportedLookAndFeelException ex) {
            throw new RuntimeException(ex);
        }
        //更新所有组件风格 其实就三个需要更新
        SwingUtilities.updateComponentTreeUI(frame.getContentPane());
        SwingUtilities.updateComponentTreeUI(menuBar);
        SwingUtilities.updateComponentTreeUI(popupMenu);
    }









}
