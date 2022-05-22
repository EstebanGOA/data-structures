package tables;

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

    /**
     * Método encargado de añadir un nuevo anuncio a nuestra lista.
     * @param key String Valor clave que identifica a nuestro anuncio.
     * @param advertising Advertising que queremos guardar en nuestra lista.
     */
    public void put(String key, Advertising advertising) {

        int position = hash(key);

        if (list[position] != null) {
            // Posición ya ocupada, es decir, colisión. Buscaremos con linear probing la siguiente posición vacía.
            int i = 1;

            while (list[position] != null) {
                position = collision(key, i);
                i++;
            }

        }

        list[position] = advertising;
        size++;

    }

    /**
     * Método que usaremos en caso de detectar una colisión que recalculará una nueva posición.
     * @param key String Valor calve que identifica al anuncio.
     * @param i Integer Cantidad de colisiones detectadas.
     * @return Integer Nueva posición calculada.
     */
    private int collision(String key, int i) {
        // Si queremos cambiar el algoritmo de recálculo para cuando ocurren colisiones tendremos que cambiar la
        // función utilizada en esta línea.
        int position;
        position = quadraticProbing(key, i);
        // position = linearProbing(key, i);
        // position = doubleHashing(key, i);
        return position;
    }

    /**
     * Método que buscará en nuestra lista un anuncio determinado y lo devolverá.
     * @param key String Valor clave que identifica al objeto buscado.
     * @return Advertising Objeto buscado.
     */
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

            position = collision(key, i);

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

    /**
     * Método que se encargará de buscar el objeto guardado en la lista y lo eliminará.
     * @param key String Valor clave que identifica el objeto buscado.
     */
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

            position = collision(key, i);

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

    /**
     * Método que convertirá el valor clave en un entero que marcará la posición donde colocaremos nuestro anuncio.
     * @param key String Valor clave que identifica al anuncio.
     * @return Integer con la posición calculada.
     */
    private int hash(String key) {
        int h = 0;
        for (char i : key.toCharArray()) {
            h += i;
        }
        return h % length;
    }

    /**
     * Método que recalculará una posición para el valor utilizado un algoritmo de linear probing.
     * @param key String Valor clave que identifica al anuncio.
     * @param i Integer Cantidad de colisiones encontradas.
     * @return Integer Nueva posición calculada.
     */
    private int linearProbing(String key, int i) {
        return (hash(key) + i) % length;
    }

    /**
     * Método que recalculará una posición para el valor utilizado un algoritmo de quadratic probing.
     * @param key String valor clave que identifica al anuncio.
     * @param i Integer Cantidad de colisiones encontradas.
     * @return Integer Nueva posición calculada.
     */
    private int quadraticProbing(String key, int i) {
        final int c1 = 2;
        final int c2 = 4;
        return (hash(key) + c1 * i + c2 * i ^ 2) % length;
    }

    /**
     * Método que recalculará una posición para el valor utilizado un algoritmo de double hashing.
     * @param key String valor clave que identifica al anuncio.
     * @param i Integer Cantidad de colisiones encontradas.
     * @return Integer Nueva posición calculada.
     */
    private int doubleHashing(String key, int i) {
        int value = hash(key);
        return (value + value * i) % length;
    }

    /**
     * Método que contará la cantidad de anuncios que hay para cada día.
     * @return Array Cada posición del array almacenará un contador para cada día diferente.
     */
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
