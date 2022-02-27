package utilities;

import entities.Follow;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Versión genérica de un Array.
 *
 * @param <E> tipo de valor que vamos a almacenar.
 */
public class ArrayList<E> {

    /**
     * Array donde guardaremos la información del objeto a almacenar.
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

    /**
     *  Informará sobre el tamaño actual de la lista.
     *
     * @return Valor entero con el tamaño actual de la lista.
     */
    public int size() {
        return size;
    }

    /**
     * Informará si nuestra lista esta vacía.
     *
     * @return Booleano que nos indicará si la lista esta vacía, devolverá true si es así, en caso contrario false.
     */
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

    /**
     * Nos transformará nuestra lista en un array estático.
     *
     * @return Array estático con los datos actuales de la lista.
     */
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
        Object[] auxiliar = new Object[desiredCapacity];
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

    /**
     * Elimina un elemento de nuestra lista.
     *
     * @param o Elemento a eliminar en nuestra lista.
     */
    public void remove(Object o) {
        Object[] auxiliar = new Object[size-1];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (!items[i].equals(o)) {
                auxiliar[index] = items[i];
                index++;
            }
        }
        items = auxiliar;
        size -= 1;
    }

    /**
     * Recoge el elemento que se encuentre en una posición indicada.
     *
     * @param index Valor entero que indica la posición donde se encuentra el elemento indicado.
     * @return Elemento situado en la posición indicada.
     * @throws IndexOutOfBoundsException Si la posición indicada es negativo o superior al tamaño de la lista saltará la excepción.
     */
    @SuppressWarnings("unchecked")
    public E get(int index) throws IndexOutOfBoundsException {
        if (index > 0 || index < items.length)
            return (E) items[index];
        else
            throw new IndexOutOfBoundsException();
    }

    /**
     * Borrará toda la información almacenada en la lista.
     */
    public void clear() {
        items = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

}
