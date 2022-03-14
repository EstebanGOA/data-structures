package entities;

import java.util.Date;

public class Node {

    private int id;
    private String name;
    private String language;
    private String cost;
    private long timestamp;

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

    public String getTimestampDate(){
        // dd/mm/yy hh/mm/ss
        /*
        long YY, MM, DD, hh, mm, ss;
        ss = timestamp % 60;
        mm = (timestamp/60) % 60;
        DD = (timestamp / 3600) % 24;
        YY = (timestamp % 31556926) + 1971;     // year + 1970 que es cuando comienza el unix
        MM = (timestamp % 2629743) % 12;        // month %12 pq el año tiene 12 meses
        */
        Date d = new Date(this.timestamp * 1000);
        return d.toString();
    }
}
