package entities;

public class TreeAlgorithm {

    public void insert(Node parent, Node successor) {

        if (parent.getTimestamp() > successor.getTimestamp()) {
            if (parent.getLeft() == null) {
                parent.setLeft(successor);
            } else {
                insert(parent.getLeft(), successor);
            }
        }

        if (parent.getTimestamp() < successor.getTimestamp()) {
            if (parent.getRight() == null) {
                parent.setRight(successor);
            } else {
                insert(parent.getRight(), successor);
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

}
