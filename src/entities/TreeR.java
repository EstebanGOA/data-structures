package entities;

import java.util.ArrayList;

public class TreeR {

    private int flag = 0;
    private Rectangle next;

    public Rectangle insert(Rectangle r, Point p) {
        // Caso de ir al siguiente rectangulo
        if (r.getFigura(0) instanceof Rectangle) {

            insert((Rectangle) r.getFigura(0), p);
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

            if (r.getFiguras().size() > 3) {
                flag = 1;
                next = r;
            }


        }

        return r;

    }
    // Diap 8 a la 9
    public Rectangle expand(Rectangle r, Rectangle root) {

        Figura min = r.getMinPoint();
        Figura max = r.getMaxPoint();
        Rectangle rectangle1 = new Rectangle(min.getX(), min.getY(), min.getX(), min.getY());
        Rectangle rectangle2 = new Rectangle(max.getX(), max.getY(), max.getX(), max.getY());
        root.removeRectangle(r);

        rectangle1.addFigura(min);
        rectangle2.addFigura(max);
        root.addFigura(rectangle1);
        root.addFigura(rectangle2);














        return r;
    }
}
