package io;

import entities.*;
import entities.Point;
import entities.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class RTreeReader {

        /**
         * Ruta relativa de la ubicación del fichero.
         */
        private final String path = "data/rtreeXS.paed";

        /**
         * Cargará el fichero y creará la estructura del árbol R.
         * @return Nodo raíz del árbol R.
         */
        public Rectangle readFile() {

            int numColors;

            try {

                File archivo = new File(path);
                Scanner myReader = new Scanner(archivo);

                numColors = Integer.parseInt(myReader.nextLine());

                String input = myReader.nextLine();
                String[] inputParse = input.split(";");

                TreeR treeR = new TreeR();


                Point point = new Point(Float.parseFloat(inputParse[0]),
                        Float.parseFloat(inputParse[1]),
                        Float.parseFloat(inputParse[2]),
                        Color.decode(inputParse[3]));


                Rectangle r = new Rectangle(point.getMaxX(), point.getMaxY(), point.getMinX(), point.getMinY());
                Rectangle root = new Rectangle(point.getMaxX(), point.getMaxY(), point.getMinX(), point.getMinY());
                r.addFigura(point);
                root.addFigura(r);
                root.setParent("root");





                for (int i = 0; i < numColors - 1; i++) {
                    input = myReader.nextLine();
                    inputParse = input.split(";");
                    // insert color
                    Point pointAux = new Point(Float.parseFloat(inputParse[0]),
                            Float.parseFloat(inputParse[1]),
                            Float.parseFloat(inputParse[2]),
                            Color.decode(inputParse[3]));
                    root = treeR.insert(root, pointAux);


                }

                return root;

            } catch (FileNotFoundException e) {
                System.out.println("The file does not exist");
                return null;
            }
        }



}
