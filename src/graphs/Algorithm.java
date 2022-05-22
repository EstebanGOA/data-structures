package graphs;

// TODO: Si introducimos un 'id' que no existe saltará una excepción.

public class Algorithm {

    /**
     * Método que realizará una búsqueda binaria para encontrar un usuario.
     * @param users Lista de usuarios.
     * @param id Identificador del usuario que estamos buscando.
     * @param low Pivote inferior.
     * @param high Pivote superior.
     * @return User El usuario que estamos buscando.
     */
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

    /**
     * Método que realizará una búsqueda binaria para encontrar la posición del usuario dentro de la lista.
     * @param users Lista de los usuarios.
     * @param id Identificador del usuario.
     * @param low Pivote inferior.
     * @param high Pivote superior.
     * @return Integer Posición de la lista en la que se encuentra el usuario buscado.
     */
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
     * @param users Lista de usuarios.
     * @param low Pivote inferior.
     * @param high Pivote superior.
     * @return Lista de los usuarios ordenados.
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
