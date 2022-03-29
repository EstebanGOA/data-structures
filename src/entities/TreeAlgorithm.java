package entities;

public class TreeAlgorithm {

    public void insert(Node parent, Node successor) {

        if (parent.getTimestamp() > successor.getTimestamp()) {
            parent.updateBalance(-1);
            if (parent.getLeft() == null) {
                parent.setLeft(successor);
            } else {
                insert(parent.getLeft(), successor);
            }
        }

        if (parent.getTimestamp() < successor.getTimestamp()) {
            parent.updateBalance(+1);
            if (parent.getRight() == null) {
                parent.setRight(successor);
            } else {
                insert(parent.getRight(), successor);
            }
        }

    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
    }

}
