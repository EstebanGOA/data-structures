package trees;

import entities.Node;
import entities.Tree;

public class TreeDelete {

    private Tree tree;

    public TreeDelete(Node source) {
        this.tree = new Tree();
    }

    public Node run(Node source, int id) {
        return deleteById(source, id);
    }


    public Node deleteById(Node parent, int id) {

        if (parent == null)
            return null;

        if (parent.getId() != id) {
            parent.setLeft(deleteById(parent.getLeft(), id));
        }

        if (parent.getId() != id) {
            parent.setRight(deleteById(parent.getRight(), id));
        }

        if (parent.getId() == id) {

            System.out.println("\nL'algorisme de " + parent.getName() + " (" + parent.getLanguage() + ") ha estat eliminat correctament del feed.");

            if (parent.getLeft() == null || parent.getRight() == null) {
            /*
                Entraremos en esta condición siempre que nuestro nodo tenga 1 hijo o ninguno.
             */

                Node auxiliar = null;
                /*
                    Si un hijo és nulo cargaremos el valor del otro hijo en una variable auxiliar.
                 */
                if (parent.getLeft() == null) {
                    auxiliar = parent.getRight();
                } else {
                    auxiliar = parent.getLeft();
                }

                /*
                    Si nuestra variable auxiliar no cambia de valor no tenemos ningún hijo y vaciamos nuestro nodo principal, en caso contrario,
                    nuestro hijo pasará a ser nuestro nodo principal.
                 */
                if (auxiliar == null) {
                    parent = null;
                } else {
                    parent = auxiliar;
                }

            } else {
            /*
                Entraremos en esta condición si nuestro nodo tiene dos hijos, y seleccionaremos como nuevo nodo principal
                el primer inorder del subárbol derecho.
             */

                Node auxiliar = firstInorder(parent.getRight());
                if (parent.getRight() != auxiliar) {
                    auxiliar.setRight(parent.getRight());
                }
                auxiliar.setLeft(parent.getLeft());
                parent = auxiliar;
                parent.setRight(deleteById(parent.getRight(), auxiliar.getId()));

            }

        }

        // Si es un nodo que está situado en un extremo sin hijos parent será null y podremos borrarlo directamente.
        if (parent == null) {
            return null;
        }

        /*
        TODO: Si utilizamos el modo autobalanceado después de eliminar tenemos que llamar a la función autobalance(Node n).
         */
        //return parent;
        return tree.autobalance(parent);

    }

    /**
     * Buscará el valor más pequeño del árbol/subárbol.
     * @param node Nodo raíz.
     * @return Nodo con el valor más pequeño del árbol/subárbol.
     */
    private Node firstInorder(Node node) {

        if (node != null) {
            firstInorder(node.getLeft());
        }
        return node;
    }


}
