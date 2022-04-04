package trees;

import entities.Node;

public class Deletion {


    public void findById(Node parent, int id, boolean flag) {
        // Search until we find the node then stop the search




        if ( parent.getLeft() != null) {
            findById(parent.getLeft(), id, flag);
        }

        if ( parent.getId() == id) {

            delete(parent);

        }
        if (flag) return;

        if ( parent.getRight() != null) {
            findById(parent.getRight(), id, flag);
        }

    }

    public void delete(Node node) {

        if (node.getRight() == null && node.getLeft() == null) {
            node = null;
            return;
        } else if (node.getRight() == null) {
            node = node.getLeft();
        } else if (node.getLeft() == null) {
            node = node.getRight();
        } else {
            node = find(node.getLeft());
        }
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
