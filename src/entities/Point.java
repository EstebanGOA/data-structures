package entities;

public class Point extends Figura {
    private double x;
    private double y;
    private double radius;
    private String color;

    public Point(double x, double y, double radius, String color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }



    public double getSuma() {
        return x + y;
    }

    @Override
    public double getMaxX() {
        return x;
    }

    @Override
    public double getMaxY() {
        return y;
    }

    @Override
    public double getMinX() {
        return x;
    }

    @Override
    public double getMinY() {
        return y;
    }

    @Override
    public void addFigura(Figura f) {

    }

    @Override
    public double[] findCenter() {
        double[] center = new double[2];
        center[0] = x;
        center[1] = y;
        return center;
    }
}

