package trees;

import utilities.ArrayList;

/**
 * Clase que se encargará de almacenar los métodos para la búsqueda de nodos en el árbol.
 */
public class TreeSearchNode {

    private ArrayList<Node> printer;

    /**
     * Constructor de TreeSearchNode.
     */
    public TreeSearchNode() {
        printer = new ArrayList<>();
    }

    /**
     * Ire comparando mi numero con un timestamp de un nodo, si es mayor,
     * coge el nodo derecho y lo pongo em el nodo que miro, sino coge el izquierdo.
     * Si por algun caso me da exception, eso es que no hay menor/mayor, significa que no existe
     * @param node nodo inicial, de donde cuelgan todos los otros
     */
    public void findByTimestamp(Node node, long timestamp){

        if (node == null) {
            System.out.println("No existeix un algorisme amb un timestamp de " + timestamp);
            return;
        }

        if(timestamp == node.getTimestamp()) {
            System.out.println("\nS'ha trobat un algorisme... " + node.getName() + ": " + node.getId() + ", " + node.getCost());
        } else {
            if(timestamp > node.getTimestamp()) {
                findByTimestamp(node.getRight(), timestamp);
            } else {
                findByTimestamp(node.getLeft(), timestamp);
            }
        }

    }

    /**
     * Método que buscará y imprimirá por pantalla los nodos que estén dentro del rango de timestamp especificado.
     * @param source Node Nodo raíz del árbol.
     * @param lowerTimestamp Valor inferior del rango de timestamp a buscar.
     * @param higherTimestamp Valor superior del rango de timestamp a buscar.
     */
    public void findByRange(Node source, long lowerTimestamp, long higherTimestamp) {

        search(source, lowerTimestamp, higherTimestamp);

        if(printer.size() > 0) {

            System.out.println("S'han trobat " + printer.size() + " algorismes en aquest rang...\n");
            for(int i=0;i<printer.size();i++) {
              //  System.out.println("\t" + printer.get(i).getName() + ": " + printer.get(i).getLanguage() + ", " + printer.get(i).getCost() + " - " + printer.get(i).getTimestamp());
                System.out.println("\t" + printer.get(i).getName() + ": " + printer.get(i).getLanguage() + ", " + printer.get(i).getCost() + " - " + printer.get(i).getTimestampDate());
            }

        } else {
            System.out.println("No existeix un algorisme amb un timestamp entre " + lowerTimestamp + " i " + higherTimestamp);
        }

    }

    /**
     * Recorreremos el árbol y añadiremos todos los nodos que encontremos dentro del rango en una lista.
     * @param source Nodo raíz del árbol.
     * @param lowerTimestamp Valor mínimo permitido.
     * @param higherTimestamp Valor máximo permitido.
     */
    private void search(Node source, long lowerTimestamp, long higherTimestamp) {    // preorder

        if(source.getTimestamp() >= lowerTimestamp) {
            if(source.getLeft() != null) {
                search(source.getLeft(), lowerTimestamp, higherTimestamp);
            }
        }

        if(source.getTimestamp() >= lowerTimestamp && source.getTimestamp() <= higherTimestamp) {
            printer.add(source);
        }

        if(source.getTimestamp() <= higherTimestamp){
            if(source.getRight() != null) {
                search(source.getRight(), lowerTimestamp, higherTimestamp);
            }
        }

    }

}
