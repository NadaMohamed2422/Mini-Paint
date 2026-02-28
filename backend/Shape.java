/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author CONNECT
 */
public class Rectangle extends Shape {

    protected int lenght;
    private int width;

    public Rectangle(int lenght, int width, Point position, Color color, Color fillColor) {
        super(position, color);
        this.lenght = lenght;
        this.width = width;
        this.fillColor = fillColor;

    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void draw(Graphics canvas) {
        Point position = super.getPosition();
        canvas.setColor(fillColor);
        canvas.fillRect(position.x, position.y, this.lenght, this.width);
        canvas.setColor(super.getColor());
        canvas.drawRect(super.getPosition().x, super.getPosition().y, this.lenght, this.width);
    }

    public boolean contains(Point p) {
        Point position = super.getPosition();

        return p.x >= position.x && p.x <= position.x + lenght
                && p.y >= position.y && p.y <= position.y + width;
    }

    public String toString() {
        return "Rectagle at (" + super.getPosition().x + ", " + super.getPosition().y + "), Lenght " + lenght + " , Width " + width;
    }

    public void resize(int lenght, int width) {
        this.lenght = lenght;
        this.width = width;
    }

}
