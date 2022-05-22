package entities;

import entities.User;
// TODO: Si introducimos un 'id' que no existe saltará una excepción.

public class Algorithm {


    public User binarySearch(User[] users, int id, int low, int high) {

        if (high >= low) {
            int mid = low + (high - low) / 2;

            // If found at mid, then return it
            if (users[mid].getId() == id)
                return users[mid];

            // Search the left half
            if (users[mid].getId() > id)
                return binarySearch(users, id, low, mid - 1);

            // Search the right half
            return binarySearch(users, id, mid + 1, high);
        }

        return null;
    }

    public int binSearch(User[] users, int id, int low, int high) {

        if (high >= low) {
            int mid = low + (high - low) / 2;

            // If found at mid, then return it
            if (users[mid].getId() == id)
                return mid;

            // Search the left half
            if (users[mid].getId() > id)
                return binSearch(users, id, low, mid - 1);

            // Search the right half
            return binSearch(users, id, mid + 1, high);
        }

        return 0;
    }


    /**
     * Algoritmo de ordenación (quicksort) de forma descendente por el número de seguidos que tiene un usuario.
     *
     * @param users
     * @param low
     * @param high
     * @return
     */
    public User[] sortByFollows(User[] users, int low, int high) {
        int lastPivot;
        if (low < high) {
            lastPivot = split(users, low, high);
            sortByFollows(users, low, lastPivot);
            sortByFollows(users, lastPivot+1, high);
        }
        return users;
    }

    private int split(User[] users, int low, int high) {
        int leftCursor = low;
        int rightCursor = high;
        int middle = (low+high) / 2;
        int pivot = users[middle].getFollows().size(); // Número de personas seguidas. (Criterio de ordenación)
        while(true) {
            while(users[leftCursor].getFollows().size() > pivot) {
                leftCursor++;
            }
            while(users[rightCursor].getFollows().size() < pivot) {
                rightCursor--;
            }
            if(leftCursor >= rightCursor) {
                return rightCursor;
            }
            swap(users, leftCursor, rightCursor);
            leftCursor++;
            rightCursor--;
        }
    }

    private void swap(User[] users, int l, int r) {
        User u;
        u = users[l];
        users[l] = users[r];
        users[r] = u;
    }
}
