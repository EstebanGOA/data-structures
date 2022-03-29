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

    public void delete (Node parent, long x){
        // Search the node we want to delete
        if (parent.getTimestamp() > x) {
            delete(parent.getLeft(), x);
        } else if (parent.getTimestamp() < x) {
            delete(parent.getRight(), x);

        } else if (parent.getTimestamp() == x) {
            // When we found the node we want to delete we check how many successors our node has


        } else {
            // The node we wanted to delete doesn't exist in the tree
            System.out.println("The node you want to delete doesn't exist");
        }

    }

}
