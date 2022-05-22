package entities;

import utilities.ArrayList;

public class Rectangle extends Figura {

    private double maxX;
    private double maxY;
    private double minX;
    private double minY;

    private ArrayList<Figura> figuras;


    public Rectangle(double maxX, double maxY, double minX, double minY) {
        figuras = new ArrayList<>();
        this.maxX = maxX;
        this.maxY = maxY;
        this.minX = minX;
        this.minY = minY;
    }

    public Rectangle(Figura f) {
        figuras = ((Rectangle) f).getFiguras();
        this.maxX = f.getMaxX();
        this.maxY = f.getMaxY();
        this.minX = f.getMinX();
        this.minY = f.getMinY();
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

    public int checkArea(Figura figura) {
        double dif;
        int best = 0;
        double bestArea = Double.MAX_VALUE;

        for (int i = 0; i < figuras.size(); i++) {
            double[] aux1 = figuras.get(i).findCenter();
            double[] aux2 = figura.findCenter();

            dif = abs(aux1[0] - aux2[0]) + abs(aux1[1] - aux2[1]);

            // Check the perimeter that is smaller with the new point inside
            if (dif < bestArea) {
                bestArea = dif;
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
        double min = Double.MAX_VALUE;
        for (int i = 0; i < figuras.size(); i++) {
            double aux = figuras.get(i).getSuma();
           if (aux  < min) {
               pos = i;
               min = aux;
           }
        }
        return  figuras.get(pos);
    }

    /**
     * Function that returns the minimum point
     * @return Returns the minimum point
     */
    public Figura getMaxPoint() {
        int pos = 0;
        double max = Double.MIN_VALUE;
        for (int i = 0; i <  figuras.size(); i++) {
            double aux = figuras.get(i).getSuma();
            if (aux  > max) {
                pos = i;
                max = aux;
            }
        }

        return figuras.get(pos);
    }

    public void removeFigura(Figura f) {
         figuras.remove(f);
    }

    public double getArea() {
        return (maxX - minX) * (maxY - minY);
    }

    public void updateArea() {

        maxX = Double.MIN_VALUE;
        maxY = Double.MIN_VALUE;
        minX = Double.MAX_VALUE;
        minY = Double.MAX_VALUE;
        for(int i = 0; i <figuras.size(); i++) {

            Figura f = figuras.get(i);
            if (f.getMaxX() > maxX) {
                maxX = f.getMaxX();
            }
            if (f.getMinX() < minX) {
                minX = f.getMinX();
            }
            if (f.getMaxY() > maxY) {
                maxY = f.getMaxY();
            }
            if (f.getMaxY() < minY) {
                minY = f.getMinY();
            }
        }

    }

    @Override
    public double[] findCenter() {
        double[] center = new double[2];
        center[0] = (maxX + minX) / 2;
        center[1] = (maxY + minY) / 2;
        return center;
    }

    @Override
    public double getSuma() {
        double[] aux = findCenter();


        return aux[0] + aux[1];
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    public double getMinX() {
        return minX;
    }

    public double getMinY() {
        return minY;
    }

    public static double abs (double numero) {
        return numero > 0 ? numero : -numero;
    }

    public void update(Figura f) {
        figuras = new ArrayList<>();
        figuras.add(f);
    }

    public void setRectangle() {

    }

}
