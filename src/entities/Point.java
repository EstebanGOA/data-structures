package entities;

public class Point extends Figura {
    private float x;
    private float y;
    private float radius;
    private String color;

    public Point(float x, float y, float radius, String color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    public float getSuma() {
        return x + y;
    }

    @Override
    public Double[] findCenter() {
        return new Double[0];
    }
}

