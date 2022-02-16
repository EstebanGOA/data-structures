package entities;

import entities.User;
// TODO He cambiado la manera de leer el fichero ya que pueden haber usuarios sin intereses

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
}
