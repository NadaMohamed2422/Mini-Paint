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
public class LineSegment extends Shape {

    private Point point;
    private int Lenght;
    private int slope ;

    public LineSegment(Point point, Point position, Color color, int Lenght, int slope) {
        super(position, color);
        this.point = point;
        this.Lenght = Lenght;
        this.slope = slope ;

    }

    public int getLenght() {
        return Lenght;
    }

    public int getSlope() {
        return slope;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(super.getColor());
        canvas.drawLine(super.getPosition().x, super.getPosition().y, this.point.x, this.point.y);

    }

    @Override
    public String toString() {
        return "Line at (" + super.getPosition().x + ", " + super.getPosition().y + "), Lenght " + Lenght+" ,Slope"+slope;
    }

    @Override
    public boolean contains(Point p)

    {
        return true;
    }

    public void setLenght(int Lenght) {
        this.Lenght = Lenght;
    }
    @Override
    public void resize(int lenght, int slope) {
        this.Lenght = lenght;
        this.slope = slope;
    }

}
