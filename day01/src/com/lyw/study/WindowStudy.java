package com.lyw.study;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


/**
 * 图形界面拼图游戏
 */
public class WindowStudy extends JFrame implements ActionListener, MouseListener, KeyListener{
    //窗口的宽度windowWidth 高度WindowHeight
    private  int windowWidth;
    private int windowHeight;

    //添加rows行cols列张图片到隐藏容器中
    private int rows;
    private int cols;
    //每张图片的宽度width高度height
    private int width;
    private int height;

    private String title;

    private int[][] imageNumberArr;

    private Random random;

    private int imageNumber;

    private JMenuItem menu1_item1;
    private JMenuItem menu1_item2;
    private JMenuItem menu1_item3;
    private JMenuItem menu1_item4;
    private JMenuItem menu1_item5;
    private JMenuItem menu2_item1;


    public static void main(String[] args) {
        WindowStudy mainFrame=new WindowStudy();
    }

    public WindowStudy() throws HeadlessException {
        //初始化数据
        initData();

        //初始化界面
        initFrame();

        //初始化菜单栏
        initMenuBar();

        //初始化图片
        initImages();

        //添加界面键盘监听
        addKeyListener(this);

        //主界面鼠标监听
        addMouseListener(this);

        //设置界面显示
        setVisible(true);

    }

    private void initData(){
        title="拼图游戏主界面V1.0";
        windowWidth=603;
        windowHeight=688;
        rows=4;
        cols=4;
        width=105;
        height=105;
        imageNumberArr=new int[rows][cols];
        random=new Random();
        imageNumber=random.nextInt(0,15);
        order();
    }

    private void order() {
        for (int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                imageNumberArr[i][j]=i*cols+j;
            }

        }
    }

    private void initImages() {
        //获取主界面的隐藏容器
        Container container=getContentPane();
        container.removeAll();
        int x=(windowWidth-16-width*cols)/2;
        int y=(windowHeight-height*rows)/2;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                ImageIcon icon=new ImageIcon("day01\\images\\image"+imageNumber+"\\"+imageNumberArr[i][j]+".jpg");
                //创建JLabel
                JLabel label=new JLabel(icon);
                //设置JLabel位置大小
                label.setBounds(j*width+x,i*height+y,width,height);
                //设置边框
                if(menu1_item5.getText()=="隐藏边框"){
                    label.setBorder(new BevelBorder(0));
                }
                //主界面的隐藏容器添加JLabel
                container.add(label);
            }
        }
        ImageIcon background=new ImageIcon("day01\\images\\background.png");
        JLabel label_back=new JLabel(background);
        label_back.setBounds(x-44,y-73,506,506);
        container.add(label_back);
    }

    private void initMenuBar() {
        //初始化菜单栏
        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);
        //初始化菜单
        JMenu menu1=new JMenu("功能");
        JMenu menu2=new JMenu("关于我们");
        menuBar.add(menu1);
        menuBar.add(menu2);
        //初始化菜单项
        menu1_item1=new JMenuItem("更换图片");
        menu1_item2=new JMenuItem("重新游戏");
        menu1_item3=new JMenuItem("重新登录");
        menu1_item4=new JMenuItem("关闭游戏");
        menu1_item5=new JMenuItem("显示边框");
        menu2_item1=new JMenuItem("公众号");
        menu1.add(menu1_item1);
        menu1.add(menu1_item2);
        menu1.add(menu1_item3);
        menu1.add(menu1_item4);
        menu1.add(menu1_item5);
        menu2.add(menu2_item1);
        menu1_item1.addActionListener(this);
        menu1_item2.addActionListener(this);
        menu1_item3.addActionListener(this);
        menu1_item4.addActionListener(this);
        menu1_item5.addActionListener(this);
        menu2_item1.addActionListener(this);



    }

    private void initFrame() {
        //设置界面宽高
        setSize(windowWidth,windowHeight);
        //设置界面置顶显示
        setAlwaysOnTop(true);
        //设置界面抬头
        setTitle(title);
        //设置界面居中
        setLocationRelativeTo(null);
        //设置关闭窗口整个程序结束
        setDefaultCloseOperation(3);
        //设置取消默认布局
        setLayout(null);

    }

    public void breakOrder() {
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                int m=random.nextInt(0,rows);
                int n=random.nextInt(0,cols);
                int tmp=imageNumberArr[i][j];
                imageNumberArr[i][j]=imageNumberArr[m][n];
                imageNumberArr[m][n]=tmp;
            }
        }
    }


    //    private void initButton() {
//        //初始化按钮1
//        button1=new JButton("001");
//        button1.setBounds(450,450,100,30);
//        getContentPane().add(button1);
//        //初始化按钮2
//        button2=new JButton("002");
//        button2.setBounds(450,490,100,30);
//        getContentPane().add(button2);
//
//        //添加动作监听
//        button1.addActionListener(this);
//        //button2.addActionListener(this);
//
//        //添加鼠标监听
//        button1.addMouseListener(this);
//        //button2.addMouseListener(this);
//
//        //添加键盘监听
//        button1.addKeyListener(this);
//
//    }


    @Override
    //动作监听
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==menu1_item1){
            changeImage();
            return;
        }
        if(e.getSource()==menu1_item5){
            showBorder();
            return;
        }
    }

    private void showBorder() {
        if(menu1_item5.getText()=="显示边框"){
            menu1_item5.setText("隐藏边框");
        }else {
            menu1_item5.setText("显示边框");
        }
        initImages();
        repaint();
    }

    private void changeImage() {
        imageNumber=random.nextInt(0,15);
        order();
        initImages();
        repaint();
    }

    @Override
    //鼠标监听
    public void mouseClicked(MouseEvent e) {

        int x=(windowWidth-16-width*cols)/2+8;
        int y=(windowHeight-height*rows)/2+54;
        x=e.getX()-x;
        y=e.getY()-y;
        int col=x/width;
        int row=y/height;
        int n=rows*cols-1;
        if(row>=0&&row<rows&&col>=0&&col<cols){
            if(row-1>=0&&imageNumberArr[row-1][col]==n){
                imageNumberArr[row-1][col]=imageNumberArr[row][col];
                imageNumberArr[row][col]=n;
            }
            else if (row+1<rows&&imageNumberArr[row+1][col]==n) {
                imageNumberArr[row+1][col]=imageNumberArr[row][col];
                imageNumberArr[row][col]=n;
            }
            else if (col+1<cols&&imageNumberArr[row][col+1]==n) {
                imageNumberArr[row][col+1]=imageNumberArr[row][col];
                imageNumberArr[row][col]=n;
            }
            else if (col-1>=0&&imageNumberArr[row][col-1]==n) {
                imageNumberArr[row][col-1]=imageNumberArr[row][col];
                imageNumberArr[row][col]=n;
            }
            else{
                return;
            }
            initImages();
            repaint();
        }



    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    //键盘监听
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==18){
            order();
            menu1_item5.setText("显示边框");
            initImages();
            repaint();
        }else{
            breakOrder();
            initImages();
            repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}



