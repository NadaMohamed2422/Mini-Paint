/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circle extends Shape {

    private int radius;

    public Circle(int radius, Point position, Color color, Color fillColor) {
        super(position, color);
        this.radius = radius;
        this.fillColor = fillColor;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean contains(Point p) {
        Point position = super.getPosition();
        double distance = Math.sqrt(Math.pow(position.x - p.x, 2) + Math.pow(position.y - p.y, 2));
        if (distance <= radius) {
            return true;
        }
        return false;
    }

    @Override
    public void draw(Graphics canvas) {
        Point position = super.getPosition();
        canvas.setColor(fillColor);
        canvas.fillOval(position.x - this.radius, position.y - this.radius, this.radius * 2, this.radius * 2);
        canvas.setColor(super.getColor());
        canvas.drawOval(position.x - this.radius, position.y - this.radius, this.radius * 2, this.radius * 2);
       
    }

    public String toString() {
        return "Circle at (" + super.getPosition().x + ", " + super.getPosition().y + "), radius " + radius;
    }
    @Override
    public void resize (int radius , int y)
    { this.radius =  radius ;
    }

}
