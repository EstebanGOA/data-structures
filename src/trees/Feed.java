package trees;

import entities.Node;
import entities.Tree;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * Se encargará de listar los nodos de nuestro árbol ordenados por su fecha de creación, cuanto más nuevo sea antes aparecerá.
 */
public class Feed {

    /**
     * Nodo raíz del que dependen el resto de nodos.
     */
    private final Node source;
    private final DateFormat dFormatter;

    /**
     * Constructor de Feed.
     * @param source Objeto donde está almacenado el árbol.
     */
    public Feed(Node source) {
        this.source = source;
        dFormatter = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
    }

    public void run() {
        reverseInorder(source);
    }

    /**
     * Recorrerá desde el árbol/subárbol introducido y mostrará por pantalla los nodos ordenados por fecha mostrando primero los más nuevos.
     * @param node Nodo que nos proporcionará un árbol o subárbol donde buscaremos ordenarlos por fecha.
     */
    private void reverseInorder(Node node) {
        if (node.getRight() != null) {
            reverseInorder(node.getRight());
        }
        System.out.println(node.getName() + ": " + node.getLanguage() + ", " + node.getCost() + " - " + node.getTimestamp());
        if (node.getLeft() != null) {
            reverseInorder(node.getLeft());
        }
    }

}
