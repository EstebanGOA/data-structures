package entities;

public abstract class Figura {
    private String parent;


    public abstract double[] findCenter();

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public abstract double getSuma();

    public abstract  double getMaxX();

    public abstract double getMaxY();

    public abstract double getMinX();

    public abstract double getMinY();

    public abstract void addFigura(Figura f);

    public abstract  void updateArea();
}
