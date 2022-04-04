package entities;

public class TreeAlgorithm {

    public void insert(Node parent, Node successor) {

        if (parent.getTimestamp() > successor.getTimestamp()) {
            if (parent.getLeft() == null) {
                parent.setLeft(successor);
            } else {
                insert(parent.getLeft(), successor);
                parent.updateFb(+1);
            }
        }

        if (parent.getTimestamp() < successor.getTimestamp()) {
            if (parent.getRight() == null) {
                parent.setRight(successor);
            } else {
                insert(parent.getRight(), successor);
                parent.updateFb(-1);
            }
        }

    }



}
