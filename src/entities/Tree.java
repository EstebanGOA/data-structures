package entities;

public class Tree {

    /**
     * Algoritmo sin autobalanceo que añade los nodos ordenados por su timestamp.
     *
     * @param parent Nodo antecesor del nodo actual.
     * @param node Nodo actual en el que nos encontramos.
     */
    public void insert(Node parent, Node node) {

        if (parent.getTimestamp() > node.getTimestamp()) {
            if (parent.getLeft() == null) {
                parent.setLeft(node);
            } else {
                insert(parent.getLeft(), node);
            }
        }

        if (parent.getTimestamp() < node.getTimestamp()) {
            if (parent.getRight() == null) {
                parent.setRight(node);
            } else {
                insert(parent.getRight(), node);
            }
        }

    }

    /**
     * Algoritmo con autobalanceo que reequilibra el árbol al añadir un nuevo nodo.
     *
     * @param parent Nodo antecesor del nodo actual.
     * @param node Nodo actual en el que nos encontramos.
     */
    public Node insertAVL(Node parent, Node node) {

        if (parent.getTimestamp() > node.getTimestamp()) {
            if (parent.getLeft() == null) {
                parent.setLeft(node);
            } else {
                parent.setLeft(insertAVL(parent.getLeft(), node));
            }
        }

        if (parent.getTimestamp() < node.getTimestamp()) {
            if (parent.getRight() == null) {
                parent.setRight(node);
            } else {
                parent.setRight(insertAVL(parent.getRight(), node));
            }
        }

        return autobalance(parent);

    }

    /**
     * Calcula el factor de balance del nodo pasado por parámetro y en caso de ser necesario realiza la rotación para equilibrar el árbol.
     * @param parent Nodo al que calculamos el factor de balance.
     * @return Nodo raíz después de realizar o no la rotación.
     */
    private Node autobalance(Node parent) {

        int balance = getBalance(parent);

        if (balance > 1) {
            if (getBalance(parent.getRight()) >= 0) {
                parent = leftRotate(parent);
            } else {
                parent.setRight(rightRotate(parent.getRight()));
                parent = leftRotate(parent);
            }
        }

        if (balance < -1) {
            if (getBalance(parent.getLeft()) <= 0) {
                parent = rightRotate(parent);
            } else {
                leftRotate(parent.getLeft());
                parent = rightRotate(parent);
            }
        }

        return parent;
    }

    /**
     * Devuelve el balance del nodo pasado por parámetro.
     * @param node Nodo raíz.
     * @return Valor del balance del nodo.
     */
    public int getBalance(Node node) {
        return height(node.getRight()) - height(node.getLeft());
    }

    /**
     * Calcula la altura del nodo.
     * @param node Nodo actual.
     * @return Altura del nodo.
     */
    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
    }

    /**
     * Realiza la rotación hacia la derecha y devuelve el nuevo nodo raíz.
     *
     * NOTA: La rotación está implementada de la forma en la que se muestra en la imagen de los apuntes.
     *
     * @param Y Nodo raíz donde comienza la rotación
     * @return Nuevo nodo raíz después de realizar la rotación
     */
    public Node rightRotate(Node Y) {
        Node X = Y.getLeft();
        Node T2 = X.getRight();

        X.setRight(Y);
        Y.setLeft(T2);

        X.setHeight(height(X));
        Y.setHeight(height(Y));

        return X;
    }

    /**
     * Realiza la rotación hacia la izquierda y devuelve el nuevo nodo raíz.
     *
     * NOTA: La rotación está implementada de la forma en la que se muestra en la imagen de los apuntes.
     *
     * @param X Nodo raíz donde comienza la rotación
     * @return Nuevo nodo raíz después de realizar la rotación
     */
    public Node leftRotate(Node X) {
        Node Y = X.getRight();
        Node T2 = Y.getLeft();

        Y.setLeft(X);
        X.setRight(T2);

        X.setHeight(height(X));
        Y.setHeight(height(Y));

        return Y;
    }

}
