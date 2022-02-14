package entities;

import java.util.Arrays;

public class MyFollowerList {

    /**
     * Array donde guardaremos la información relevante a los usuarios que sigue un individuo.
     */
    private Follow[] follows;

    /**
     * Número entero con el tamaño actual de la lista.
     */
    private int size;

    /**
     * Tamaño inicial de la lista.
     * En caso de crear una instancia de MyFollowerList el tamaño inicial será equivalente a su valor.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Crea una lista vacía con el tamaño especificado.
     *
     * @param initialCapacity el tamaño inicial de la lista.
     */
    public MyFollowerList(int initialCapacity) {
        // TODO: Deberíamos gestionar la interacción de introducir un valor negativo.
        this.follows = new Follow[initialCapacity];
        this.size = 0;
    }

    /**
     * Crea una lista vacía con un tamaño inicial de 10.
     */
    public MyFollowerList() {
        this.follows = new Follow[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Comprueba si el Array es capaz de almacenar una cierta cantidad de objetos, si es necesario aumentará el tamaño del Array.
     * @param desiredCapacity Valor entero con el tamaño deseado para el Array.
     */
    private void ensureCapacity(int desiredCapacity) {
    // TODO: Me pareció útil en un primer momento y por ese motivo lo implemente actualmente no tiene ningún uso. (Recordatorio para borrar si no se usa).
        if (desiredCapacity > follows.length)
            grow(desiredCapacity);
    }

    /**
     * Incremente el tamaño del Array hasta la capacidad deseada especificada por parámetro.
     *
     * @param desiredCapacity tamaño hasta el que incrementaremos el Array.
     */
    private Follow[] grow(int desiredCapacity) {
        Follow[] f_aux = new Follow[desiredCapacity];
        for (int i = 0; i < follows.length; i++) {
            f_aux[i] = follows[i];
        }
        return follows = f_aux;
    }

    /**
     * Incremente el valor del Array para almacenar un seguidor más.
     */
    private Follow[] grow() {
        return grow(size + 1);
    }

    /**
     *
     * @param e
     */
    public void add(Follow e) {
        if (size == follows.length)
            follows = grow();
        follows[size] = e;
        size += 1;
    }

    public Follow get(int index) throws IndexOutOfBoundsException {
        if (index > 0 || index < follows.length)
            return follows[index];
        else
            throw new IndexOutOfBoundsException();
    }

    public int size() {
        return size;
    }

}
