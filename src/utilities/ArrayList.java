package utilities;

import entities.Follow;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Versión genérica de un Array.
 *
 * @param <T> tipo de valor que vamos a almacenar.
 */
public class ArrayList<E> {

    /**
     * Array donde guardaremos la información relevante a los usuarios que sigue un individuo.
     */
    private Object[] items;

    /**
     * Número entero con el tamaño actual de la lista.
     */
    private int size;

    /**
     * Tamaño inicial de la lista.
     * En caso de crear una instancia de MyFollowerList el tamaño inicial será equivalente a su valor.
     */
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this.items = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        // TODO: ¿Podríamos implementar algún algoritmo para hacer la búsqueda más rápida?
        for (Object item : items) {
            if (item.equals(o)) return true;
        }
        return false;
    }

    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    public void add(E e) {
        if (size == items.length)
            items = grow();
        items[size] = e;
        size += 1;
    }

    /**
     * Incremente el tamaño del Array hasta la capacidad deseada especificada por parámetro.
     *
     * @param desiredCapacity tamaño hasta el que incrementaremos el Array.
     */
    private Object[] grow(int desiredCapacity) {
        Object[] auxiliar = new Follow[desiredCapacity];
        for (int i = 0; i < items.length; i++) {
            auxiliar[i] = items[i];
        }
        return items = auxiliar;
    }

    /**
     * Incremente el valor del Array para almacenar un seguidor más.
     */
    private Object[] grow() {
        return grow(size + 1);
    }


    public void remove(Object o) {
        Object[] auxiliar = new Object[size-1];
        int index = 0;
        for (Object item : items) {
            if (!item.equals(o)) {
                auxiliar[index] = item;
                index++;
            }
        }
        items = auxiliar;
    }

    /**
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @SuppressWarnings("unchecked")
    public E get(int index) throws IndexOutOfBoundsException {
        if (index > 0 || index < items.length)
            return (E) items[index];
        else
            throw new IndexOutOfBoundsException();
    }

    public void clear() {
        items = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

}
