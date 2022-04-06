package trees;

import entities.Node;

public class Deletion {


    public Node findById(Node parent, int id, boolean flag) {
        // Search until we find the node then stop the search

        if ( parent.getLeft() != null) {
            parent.setLeft(findById(parent.getLeft(), id, flag));
        }

        if ( parent.getId() == id) {

            parent = delete(parent);

        }
        if (flag) return parent;

        if ( parent.getRight() != null) {
            parent.setRight(findById(parent.getRight(), id, flag));
        }
        return parent;
    }

    /*
    Node delete(Node node, int key) {
        if (node == null) {
            return node;
        } else if (node.id > key) {
            node.left = delete(node.left, key);
        } else if (node.key < key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    */
    public Node delete(Node node) {

        if (node.getLeft() == null || node.getRight() == null) {
            node = (node.getLeft() == null) ? node.getRight() : node.getLeft();
        } else {
            node = find(node.getLeft());
        }
        return node;
    }

    public Node find(Node parent) {
        Node node = null;
        if ( parent.getRight() != null) {
            node = find(parent.getRight());
        } else {
            node = parent;
            parent = null;
        }

        return node;
    }

}
