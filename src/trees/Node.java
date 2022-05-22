package trees;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * Clase que se encargará de almacenar toda la información relacionada con un nodo.
 */
public class Node {

    private int id;
    private String name;
    private String language;
    private String cost;
    private long timestamp;

    /**
     * Binary Search Tree variables
     */
    private Node right;
    private Node left;
    private int height;

    /**
     * Constructor de Node
     * @param id Identificador del algoritmo.
     * @param name Nombre del algoritmo.
     * @param language Lenguaje de programación del algoritmo.
     * @param cost Coste del algoritmo.
     * @param timestamp Fecha de creación del algoritmo.
     */
    public Node(int id, String name, String language, String cost, long timestamp) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.cost = cost;
        this.timestamp = timestamp;
        this.right = null;
        this.left = null;
    }

    public int getId() {
        return id;
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

    public long getTimestamp() {
        return timestamp;
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

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Método que formateará el timestamp y nos lo devolverá en un formato más comprensible.
     * @return String Fecha del nodo con un formato más compresible.
     */
    public String getTimestampDate(){
        // dd/mm/yy hh/mm/ss
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
        return df.format(Date.from(Instant.ofEpochSecond(this.timestamp)));
    }



}
