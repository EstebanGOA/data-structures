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
        return null;
    }
}
