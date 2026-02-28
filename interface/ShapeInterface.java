/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import backend.Shape;
import java.io.File;
import java.util.ArrayList;

public interface DrawingEngineInterface {

   
        public void addShape(Shape shape);

        public void removeShape(Shape shape);

        public ArrayList<Shape> getShapes();

        public void refresh(java.awt.Graphics canvas);

        public void save(File fileName);

        public void load(File fileName);

    

}
