package com.lyw.GUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static java.lang.System.exit;

/**
 * 位图技术画图
 * 如果位图闪烁就重写update()方法 去掉清屏动作
 * 从指定文件读取图片到内存
 * try {
 *             image = ImageIO.read(new FileInputStream("day01/images/image0/0.jfif"));
 *         } catch (IOException e) {
 *             throw new RuntimeException(e);
 *         }
 * 写出图到指定文件
 *                try {
 *                    ImageIO.write(image,"JPEG",new File("test.jpg"));
 *               } catch (IOException ex) {
 *                   throw new RuntimeException(ex);
 *               }
 */
public class BitMap {
    public static int x=300;
    public static int y=100;
    public static int width=700;
    public static int height=500;
    public static String title="画图板";

    public static Frame frame = new Frame(title);

    //创建BufferedImage位图对象
    //public static BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    public static BufferedImage image;

    static {
        try {
            image = ImageIO.read(new FileInputStream("day01/images/image0/0.jfif"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Graphics g = image.getGraphics();
    public static int x1=-1;
    public static int y1=-1;

    static class ImageArea extends Canvas{
        @Override
        public void paint(Graphics g) {
            g.drawImage(image,0,0,null);
        }

        @Override
        public void update(Graphics g) {
            //g.clearRect(0, 0, width, height);
            paint(g);
        }
    }

    //创建画图板区域
    public static ImageArea area=new BitMap.ImageArea();


    public static void main(String[] args) {
        frame.setBounds(x,y,width,height);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit(0);
            }
        });

        frame.add(area);
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                image=new BufferedImage(frame.getWidth(),frame.getHeight(),BufferedImage.TYPE_INT_RGB);
                g=image.getGraphics();
                //在位图上画背景
                //g.setColor(Color.BLACK);
                //g.fillRect(0,0,image.getWidth(),image.getHeight());
            }
        });
        area.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                g.setColor(Color.GREEN);
                if(x1!=-1&&y1!=-1){
                    g.drawLine(x1,y1,e.getX(),e.getY());
                }
                x1=e.getX();
                y1=e.getY();
                area.repaint();
            }
        });

        area.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                x1=-1;
                y1=-1;
//                try {
//                    ImageIO.write(image,"JPEG",new File("test.jpg"));
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
            }
        });
        frame.setVisible(true);
    }
}