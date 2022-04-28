package entities;

import utilities.ArrayList;

public class Rectangle {
    private float maxX;
    private float maxY;
    private float minX;
    private float minY;
    private ArrayList<Rectangle> rectangles;
    private ArrayList<Point> points;

    public Rectangle(float maxX, float maxY, float minX, float minY) {
        rectangles = new ArrayList<>();
        points = new ArrayList<>();
    }


    public ArrayList<Rectangle> getRectangles() {
        return rectangles;
    }

    public void addRectangle(Rectangle r) {
        rectangles.add(r);
    }

    public void addPoint(Point p) {
        points.add(p);
    }

    // Esto esta mal
    public int checkArea(Point point) {
        float[] dif = new float[rectangles.size()];
        int best = 0;
        float bestArea = Integer.MAX_VALUE;

        for (int i = 0; i < rectangles.size(); i++) {
            float area = (maxX - minX) * (maxY - minY);
            // Faltan cositas


            float areaAux = (point.getX() - minX) * (point.getY() - minY);


            dif[i] = areaAux - area;

            // Check the area that is smaller with the new point inside
            if (dif[i] < bestArea) {
                bestArea = dif[i];
                best = i;
            }

        }

        return best;

    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public Rectangle getLeft() {
        return rectangles.get(0);
    }

    public Rectangle getMiddle() {
        return rectangles.get(1);
    }

    public Rectangle getRight() {
        return rectangles.get(2);
    }

    public Point getMinPoint() {
        int pos = 0;
        float min = Float.MAX_VALUE;
        for (int i = 0; i < points.size(); i++) {
            float aux = points.get(i).getSuma();
           if (aux  < min) {
               pos = i;
               min = aux;
           }
        }
        return points.get(pos);
    }

    public Point getMaxPoint() {
        int pos = 0;
        float max = Float.MIN_VALUE;
        for (int i = 0; i < points.size(); i++) {
            float aux = points.get(i).getSuma();
            if (aux  > max) {
                pos = i;
                max = aux;
            }
        }
        return points.get(pos);
    }


}
