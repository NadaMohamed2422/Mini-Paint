/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package backend;

import java.awt.Graphics;
import java.util.ArrayList;
import interfaces.DrawingEngineInterface;
import java.awt.Color;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CONNECT
 */
public class DrawingEngine implements DrawingEngineInterface {

    private ArrayList<Shape> shapes;

    public DrawingEngine() {
        shapes = new ArrayList<>();
    }

    @Override
    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        this.shapes.remove(shape);
    }

    @Override
    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    @Override
    public void refresh(Graphics canvas) {
        for (Shape shape : shapes) {
            shape.draw(canvas);
        }
    }

    @Override
    public void save(File fileName) {
        try {
            FileWriter fileWrite = new FileWriter(fileName);
            for (Shape shape : shapes) {
                fileWrite.write(shape.toString() + "," + shape.getColor() + "," + shape.getFillColor()+ System.lineSeparator());
                
            }
            fileWrite.close();
        } catch (IOException ex) {
            Logger.getLogger(DrawingEngine.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void load(File fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if ("L".equals(line.substring(0, 1))) {
                    String info = line.replaceAll("[^0-9,]", "");
                    String[] info2 = info.split(",");
                    int[] info1 = new int[7];
                    for (int i = 0; i < 7; i++) {
                        info1[i] = Integer.parseInt(info2[i]);
                    }
                    Point p1 = new Point(info1[0], info1[1]);
                    Point p2 = new Point();
                    double slope1 = Math.toRadians(-info1[3]);
                    p2.x = (int) Math.round(p1.x + info1[2] * Math.cos(slope1));
                    p2.y = (int) Math.round(p1.y + info1[2] * Math.sin(slope1));
                    Color color;
                    if (info1[4] >= 0 && info1[4] <= 255 && info1[5] >= 0 && info1[5] <= 255 && info1[6] >= 0 && info1[6] <= 255) {
                        color = new Color(info1[4], info1[5], info1[6]);
                        Shape shape = new LineSegment(p2, p1, color, info1[2], info1[3]);
                        shapes.add(shape);
                    }

                }
                if ("C".equals(line.substring(0, 1))) {
                    String info = line.replaceAll("[^0-9,]", "");
                    String[] info2 = info.split(",");
                    int[] info1 = new int[9];
                    for (int i = 0; i < 9; i++) {
                        info1[i] = Integer.parseInt(info2[i]);
                    }
                    Point p1 = new Point(info1[0], info1[1]);
                    Color color;
                    Color color1;

                    if (info1[3] >= 0 && info1[3] <= 255 && info1[4] >= 0 && info1[4] <= 255 && info1[5] >= 0 && info1[5] <= 255) {
                        color = new Color(info1[3], info1[4], info1[5]);
                        color1 = new Color(info1[6], info1[7], info1[8]);
                        Shape shape = new Circle(info1[2], p1, color, color1);
                        shapes.add(shape);

                    }

                }
                if ("R".equals(line.substring(0, 1))) {
                    String info = line.replaceAll("[^0-9,]", "");
                    String[] info2 = info.split(",");
                    int[] info1 = new int[10];
                    for (int i = 0; i < 10 ; i++) {
                        info1[i] = Integer.parseInt(info2[i]);
                    }
                    Point p1 = new Point(info1[0], info1[1]);
                    Color color;
                    Color color1;

                    if (info1[4] >= 0 && info1[4] <= 255 && info1[5] >= 0 && info1[5] <= 255 && info1[6] >= 0 && info1[6] <= 255) {
                        color = new Color(info1[4], info1[5], info1[6]);
                        color1 = new Color(info1[7], info1[8], info1[9]);
                        Shape shape = new Rectangle (info1[2],info1[3], p1, color, color1);
                        shapes.add(shape);

                    }

                }
                if ("S".equals(line.substring(0, 1))) {
                    String info = line.replaceAll("[^0-9,]", "");
                    String[] info2 = info.split(",");
                     int[] info1 = new int[9];
                    for (int i = 0; i < 9; i++) {
                        info1[i] = Integer.parseInt(info2[i]);
                    }
                    Point p1 = new Point(info1[0], info1[1]);
                    Color color;
                    Color color1;

                    if (info1[3] >= 0 && info1[3] <= 255 && info1[4] >= 0 && info1[4] <= 255 && info1[5] >= 0 && info1[5] <= 255) {
                        color = new Color(info1[3], info1[4], info1[5]);
                        color1 = new Color(info1[6], info1[7], info1[8]);
                        Shape shape = new Square (info1[2],info1[2], p1, color, color1);
                        shapes.add(shape);

                    }
                    

                }

            }
            reader.close();

        } catch (IOException ex) {
            Logger.getLogger(DrawingEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
