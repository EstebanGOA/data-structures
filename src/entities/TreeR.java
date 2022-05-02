package entities;

import java.util.ArrayList;

public class TreeR {

    private int flag = 0;
    private Rectangle next;

    public Rectangle insert(Rectangle r, Point p) {
        // Caso de ir al siguiente rectangulo
        if (r.getFigura(0) instanceof Rectangle) {

            // insert((Rectangle) r.getFigura(r.checkArea(p)), p);
            insert((Rectangle) r.getFigura( r.checkArea(p)), p);
        }


        // This if serves as a condition to go back to the previous rectangle,
        // before doing the expand of 2 rectangles when we have 4 points
        if(flag == 1) {
            expand(next, r);
            flag = 0;

        }
        // Si es hoja  y no pasa el maximo de puntos
        if (r.getFigura(0) instanceof Point) {

            r.addFigura(p);




        }
        if (r.getFiguras().size() > 3) {
            flag = 1;
            next = r;
        }

        r.updateArea();

        return r;

    }
    // Diap 8 a la 9
    public Rectangle expand(Rectangle r, Rectangle root) {
        // Falta gestionar


        Figura min = r.getMinPoint();
        Figura max = r.getMaxPoint();
        Figura rectangle1 = new Rectangle(min.getMaxX(), min.getMaxY(), min.getMinX(), min.getMinY());
        Figura rectangle2 = new Rectangle(max.getMaxX(), max.getMaxY(), max.getMinX(), max.getMinY());

        r.removeFigura(min);
        r.removeFigura(max);

        Rectangle aux = r;

        rectangle1.addFigura(min);
        rectangle2.addFigura(max);

        root.removeFigura(r);
        root.addFigura(rectangle1);
        root.addFigura(rectangle2);


        for (int i = 0; i < 2; i++) {
            Figura figura = aux.getFigura(i);
            int index = root.checkArea(figura);
            root.getFigura(index).addFigura(figura);
        }

        for (int j = 0; j < root.getFiguras().size(); j++) {
             root.getFigura(j).updateArea();
        }

        return r;
    }
}
