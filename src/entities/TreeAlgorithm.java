package entities;

public class TreeAlgorithm {

    public void insert(Node parent, Node successor, long value) {

        if (parent.getTimestamp() > successor.getTimestamp()) {
            if (parent.getLeft() == null) {
                parent.setLeft(successor);
            } else {
                insert(parent.getLeft(), successor, value);
            }
        }

        if (parent.getTimestamp() < successor.getTimestamp()) {
            if (parent.getRight() == null) {
                parent.setRight(successor);
            } else {
                insert(parent.getRight(), successor, value);
            }
        }

    }

    public void inorder(Node node) {
        if (node.getLeft() != null) {
            inorder(node.getLeft());
        }
        System.out.println(node.getTimestamp());
        if (node.getRight() != null) {
            inorder(node.getRight());
        }
    }

    public void reverseInorder(Node node) {
        if (node.getRight() != null) {
            inorder(node.getRight());
        }
        System.out.println(node.getTimestamp());
        if (node.getLeft() != null) {
            inorder(node.getLeft());
        }
    }

}
