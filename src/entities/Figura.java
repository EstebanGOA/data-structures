package entities;

public abstract class Figura {

    private Figura parent;

    public abstract Double[] findCenter();

    public Figura getParent() {
        return parent;
    }

    public void setParent(Figura parent) {
        this.parent = parent;
    }



}
