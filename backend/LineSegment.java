/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package backend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;
import interfaces.ShapeInterface;

/**
 *
 * @author CONNECT
 */
public abstract class Shape implements ShapeInterface {

    private Point position;
    private Color color;
    protected Color fillColor;
    protected Map<String, Double> properties;

    public Shape(Point position, Color color) {
        this.position = position;
        this.color = color;

    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        this.properties = properties;
    }

    @Override
    public Map<String, Double> getProperties() {
        return properties;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public abstract void draw(Graphics canvas);

    @Override
    public abstract boolean contains(Point p);

    @Override
    public abstract void resize (int x, int y);

}
