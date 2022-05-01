package entities;

import utilities.ArrayList;

public class Rectangle extends Figura {
    private float maxX;
    private float maxY;
    private float minX;
    private float minY;
    private ArrayList<Figura> figuras;


    public Rectangle(float maxX, float maxY, float minX, float minY) {
        figuras = new ArrayList<>();
    }


    public ArrayList<Figura> getFiguras() {
        return figuras;
    }



    public void addFigura(Figura f) {
        figuras.add(f);
    }

    public Figura getFigura(int index) {
        return figuras.get(index);
    }

    public int checkArea(Point point) {
        float[] dif = new float[figuras.size()];
        int best = 0;
        float bestArea = Integer.MAX_VALUE;

        for (int i = 0; i < figuras.size(); i++) {



            // Check the area that is smaller with the new point inside
            if (dif[i] < bestArea) {
                bestArea = dif[i];
                best = i;
            }

        }

        return best;

    }





    /**
     * Function that returns the minimum point
     * @return Returns the minimum point
     */
    public Figura getMinPoint() {
        int pos = 0;
        float min = Float.MAX_VALUE;
        for (int i = 0; i < figuras.size(); i++) {
            float aux = (Point) figuras.get(i).getSuma();
           if (aux  < min) {
               pos = i;
               min = aux;
           }
        }
        return figuras.get(pos);
    }


    /**
     * Function that returns the minimum point
     * @return Returns the minimum point
     */
    public Point getMaxPoint() {
        int pos = 0;
        float max = Float.MIN_VALUE;
        for (int i = 0; i <  points.size(); i++) {
            float aux = points.get(i).getSuma();
            if (aux  > max) {
                pos = i;
                max = aux;
            }
        }
        return points.get(pos);
    }



    public void removeRectangle(Rectangle r) {
         figuras.remove(r);
    }

    public float getMaxX() {
        return maxX;
    }

    public float getMaxY() {
        return maxY;
    }

    public float getMinX() {
        return minX;
    }

    public float getMinY() {
        return minY;
    }
    public float getArea() {
        return (maxX - minX) * (maxY - minY);
    }

    public void updateArea(Point p) {
        if (p.getX() > maxX) {
            maxX = p.getX();
        }
        if (p.getX() < minX) {
            minX = p.getX();
        }
        if (p.getY() > maxY) {
            maxY = p.getY();
        }
        if (p.getY() < minY) {
            minY = p.getY();
        }
    }

    @Override
    public Double[] findCenter() {
        return new Double[0];
    }
}
