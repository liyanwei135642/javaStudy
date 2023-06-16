package com.lyw.GUI;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 自定义画板
 */
public class PaintArea extends Canvas {
    public LinkedList<Shape> shapes;


    public PaintArea() {
        this.shapes = new LinkedList<>() ;
    }

    @Override
    public void paint(Graphics g) {
        for (Shape shape : shapes) {
            g.setColor(shape.color);
            g.drawRect(shape.x,shape.y,shape.width,shape.height);
            if(shape.fill){
                g.setColor(shape.fillColor);
                g.fillRect(shape.x,shape.y,shape.width,shape.height);
            }
        }
    }
}
