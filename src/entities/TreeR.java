package entities;

import org.w3c.dom.css.Rect;

import java.util.ArrayList;

public class TreeR {

    private int flag = 0;
    private Rectangle next;


    private int flag2 = 0;

    public Rectangle insert(Rectangle r, Point p) {
        // Caso de ir al siguiente rectangulo
        if (r.getFigura(0) instanceof Rectangle) {

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
        // Check if we have overflow, we have two types of overflow.
        //     1. We have 4 points or rectangles but not directly connected to the root.
        //     2. We have 4 rectangles directly connected to the root.

        // In the first case we are going to go back one rectangle and then we are going to expand
        // In the second case we are going to go back on rectangle, move the root one above and then expand

        if (r.getFiguras().size() > 3 && r.getParent() == null) {
            flag = 1;
            next = r;

        } else if (r.getFiguras().size() > 3 && r.getParent().equals("root")) {
            Rectangle aux = new Rectangle(r);
            r = new Rectangle(aux.getMaxX(), aux.getMaxY(), aux.getMinX(), aux.getMinY());
            r.addFigura(aux);
            r.setParent("root");

            expand(aux, r);
        }



        // Update the area
        r.updateArea();

        return r;

    }

    /**
     *  This function gets the two rectangles more apart, removes r and adds the two rectangles to the root,
     *  finally we add the two remaining rectangles from r into the other rectangles of r getting as reference the permiter
     * @param r the rectangle that has overflow in his figures.
     * @param root The rectangle parent of r.
     */
    public void expand(Rectangle r, Rectangle root) {




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


    }

    /**
     * Function that deletes a point from our R-tree
     * @param r the rectangle parent
     * @param p the point we want to remove
     * @return Returns the root rectangle
     */
    public Rectangle delete(Rectangle r, Point p ) {
        int index = 0;

        // Keep exploring until we find the leafs/points
        if ( r.getFigura(0) instanceof  Rectangle) {
            index =  r.checkArea(p);
           delete((Rectangle) r.getFigura(index), p);
        }

        if ( r.getFigura(0) instanceof  Point) {
            int check = 0;
            for(int i = 0; i < r.getFiguras().size(); i++ ) {
                if (r.getFigura(i).getMaxX() == p.getMaxX()
                        && r.getFigura(i).getMaxY() == p.getMaxY()) {
                    r.removeFigura(r.getFigura(i));
                    check = 1;

                }
            }
            if (check == 0) {
                System.out.println("There isn't a point in this position");
            }
        }

        // Check if the rectangle has any figures, if the rectangle doesn't have any we eliminate it recursively
        if(flag2 == 1) {
            r.removeFigura(r.getFigura(index));
            flag2 = 0;
        }

        if (r.getFiguras().size() == 0) {
            flag2 = 1;
        }
        // Update the area
        r.updateArea();
        return r;
    }


}
