package tables;

import utilities.ArrayList;
import tables.Advertising;

public class Table {

    private Advertising[] list;

    /**
     * Número de objetos guardados en la lista.
     */
    private int size;

    /**
     * Tamaño real de la lista.
     */
    private int length;

    public Table(int initialSize) {
        int multiplier = 2;
        list = new Advertising[initialSize * multiplier];
        this.size = 0;
        this.length = initialSize * multiplier;
    }

    public void put(String key, Advertising advertising) {

        int position = hash(key);

        if (list[position] != null) {
            // Posición ya ocupada, es decir, colisión. Buscaremos con linear probing la siguiente posición vacía.
            int i = 1;

            while (list[position] != null) {
                position = quadraticProbing(key, i);
                i++;
            }

        }

        list[position] = advertising;
        size++;

    }

    public Advertising get(String key) {

        int i = 1;
        int position = hash(key);

        // Si la primera posición está vacía significa que no está en la lista.
        if (list[position] == null) {
            return null;
        }

        // Comparamos el valor clave con el valor original para comprobar que sea el que estamos buscando.
        if (list[position].getName().equals(key)) {
            return list[position];
        }

        // Si el valor clave no coincide con el valor original comprobamos las siguientes posiciones.
        while(true) {

            position = quadraticProbing(key, i);

            // Si encontramos otro valor nulo significa que no está en la lista.
            if (list[position] == null) {
                return null;
            }

            // Si encontramos un valor que coincide, lo devolvemos. En caso contrario, miramos la siguiente posición.
            if (list[position].getName().equals(key)) {
                return list[position];
            } else {
                i++;
            }

        }
    }

    public void remove(String key) {

        int i = 1;
        int position = hash(key);

        // Si la primera posición está vacía significa que no está en la lista.
        if (list[position] == null) {
            return;
        }

        // Comparamos el valor clave con el valor original para comprobar que sea el que estamos buscando.
        if (list[position].getName().equals(key)) {
            list[position] = null;
            size--;
            return;
        }

        // Si el valor clave no coincide con el valor original comprobamos las siguientes posiciones.
        while(true) {

            position = quadraticProbing(key, i);

            // Si encontramos otro valor nulo significa que no está en la lista
            if (list[position] == null) {
                return;
            }

            // Si encontramos un valor que coincide, lo borramos. En caso contrario, miramos la siguiente posición.
            if (list[position].getName().equals(key)) {
                list[position] = null;
                size--;
                return;
            } else {
                i++;
            }
        }

    }

    private int hash(String key) {
        int h = 0;
        for (char i : key.toCharArray()) {
            h += i;
        }
        return h % length;
    }

    private int linearProbing(String key, int i) {
        return (hash(key) + i) % length;
    }


    private int quadraticProbing(String key, int i) {
        final int c1 = 2;
        final int c2 = 4;
        return (hash(key) + c1 * i + c2 * i ^ 2) % length;
    }

    private int doubleHashing(String key, int i) {
        int value = hash(key);
        return (value + value * i) % length;
    }

        public int[] countDays() {

        int[] values = new int[7];

        for (int i = 0; i < length; i++) {

            if (list[i] == null) {
                continue;
            }

            switch (list[i].getDate()) {
                case "Monday" -> values[0]++;
                case "Tuesday" -> values[1]++;
                case "Wednesday" -> values[2]++;
                case "Thursday" -> values[3]++;
                case "Friday" -> values[4]++;
                case "Saturday" -> values[5]++;
                case "Sunday" -> values[6]++;
            }

        }

        return values;
    }
}
