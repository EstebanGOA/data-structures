package entities;

public class Node {

    private int id;
    private String name;
    private String language;
    private String cost;
    private long timestamp;
    private int fb;


    /**
     * Binary Search Tree variables
     */
    private Node parent;
    private Node right;
    private Node left;

    public Node(int id, String name, String language, String cost, long timestamp) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.cost = cost;
        this.timestamp = timestamp;
        this.parent = null;
        this.right = null;
        this.left = null;
        fb = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getFb() {
        return fb;
    }
    public void updateFb(int i) {
        fb += i;
    }
}
