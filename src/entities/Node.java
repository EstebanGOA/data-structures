package entities;

public class Node {

    private int id;
    private String name;
    private String language;
    private String cost;
    private long timestamp;
    private Node rightNode;
    private Node leftNode;

    public Node(int id, String name, String language, String cost, long timestamp) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.cost = cost;
        this.timestamp = timestamp;
    }


}
