package entities;

public class TreeR {

    public Rectangle insert(Rectangle r, Point p) {
        // Caso de ir al siguiente rectangulo
        if (r.getPoints() == null) {
            switch (r.checkArea(p)) {
                case 0:  return insert(r.getLeft(), p);

                case 1:  return insert(r.getMiddle(), p);

                case 2:  return insert(r.getRight(),p);
            }

        }
        // Si es hoja  y no pasa el maximo de puntos

        if (r.getPoints() != null) {

            r.addPoint(p);
            if (r.getPoints().size() > 3) {

            r = expand(r);
            }

        }



        return r;

    }

    public Rectangle expand(Rectangle r) {

        Point min = r.getMinPoint();
        Point max = r.getMaxPoint();
        Rectangle rectangle1 = new Rectangle(min.getX(), min.getY(), min.getX(), min.getY());
        Rectangle rectangle2 = new Rectangle(max.getX(), max.getY(), max.getX(), min.getY());

        rectangle1.addPoint(min);

        rectangle2.addPoint(max);
        r.addRectangle(rectangle1);
        r.addRectangle(rectangle2);

        for(int i = 0; i < 2; i++) {
            Point point = r.getPoints().get(i);
            switch(r.checkArea(point)) {
                case 0: r.getLeft().addPoint(point);

                case 1: r.getMiddle().addPoint(point);

            }
        }
        r.getPoints().clear();









        return r;
    }
}
