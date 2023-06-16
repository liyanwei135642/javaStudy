package com.lyw.GUI;

import java.awt.*;

/**
 * 自定义图形属性
 */
public class Shape {
    public Color color;
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean fill;
    public Color fillColor;

    public Shape(int x, int y, int width, int height) {
        this.color = new Color(255,255,255);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fill = true;
        this.fillColor = new Color(0,255,0);
    }

    public Shape() {
        this.color = new Color(0,0,0);
        this.x = 10;
        this.y = 10;
        this.width = 200;
        this.height = 200;
        this.fill = true;
        this.fillColor = new Color(0,255,0);
    }

    public Shape(Color color, int x, int y, int width, int height, boolean fill, Color fillColor) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fill = fill;
        this.fillColor = fillColor;
    }

    /**
     * 获取
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * 设置
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * 获取
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * 设置
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 获取
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * 设置
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 获取
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * 设置
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * 获取
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * 设置
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 获取
     * @return fill
     */
    public boolean isFill() {
        return fill;
    }

    /**
     * 设置
     * @param fill
     */
    public void setFill(boolean fill) {
        this.fill = fill;
    }

    /**
     * 获取
     * @return fillColor
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * 设置
     * @param fillColor
     */
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public String toString() {
        return "Shape{color = " + color + ", x = " + x + ", y = " + y + ", width = " + width + ", height = " + height + ", fill = " + fill + ", fillColor = " + fillColor + "}";
    }
}
