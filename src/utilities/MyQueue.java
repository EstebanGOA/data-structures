package utilities;

import graphs.User;

/**
 * Clase que actuará como una cola donde almacenaremos objetos de la clase User.
 */
public class MyQueue {

    /**
     * Lista con los usuarios introducidos en la cola.
     */
    private User[] users;

    /**
     * Número entero con el tamaño actual de la lista.
     */
    private int size;

    /**
     * Tamaño inicial de la cola.
     * En caso de crear una instancia de MyQueue el tamaño inicial será equivalente a su valor.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Constructor de MyQueue
     */
    public MyQueue() {
        this.users = new User[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Método que añadirá un nuevo usuario a la cola.
     * @param u Usuario que queremos añadir a la cola.
     */
    public void add(User u){
        if (users.length == size)
            users = grow();
        users[size] = u;
        size += 1;
    }

    /**
     * Función que incrementará el tamaño de la cola en caso de que nos quedemos sin espacio.
     * @return Devolverá la lista de los usuarios con el nuevo tamaño para el array con los datos anteriores.
     */
    private User[] grow() {
       User[] aUsers = new User[size+1];
       for (int i = 0; i < users.length; i++){
           aUsers[i] = this.users[i];
       }
       return this.users = aUsers;
    }

    /**
     * Decrementará el tamaño de la cola.
     */
    private void decrease(){
        for (int i = 0; i < users.length-1; i++){
            this.users[i] = this.users[i+1];
        }
    }

    /**
     * Quita el primer elemento del array.
     */
    public void remove(){
        decrease();
        size -= 1;
    }

    /**
     * Método que devolverá la cantidad de elementos que está almacenando actualmente la cola.
     * @return Entero con el tamaño actual de la cola.
     */
    public int size(){
        return size;
    }

    /**
     * Se usa antes del get para asegurar que aun hay datos en la queue y para al acabar, asegurar que la queue esta vacia
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Método que recogerá un elemento de la cola y lo devolverá.
     * @param index Posición donde se encuentra el elemento a buscar.
     * @return Elemento que está situado en la posición buscada.
     * @throws IndexOutOfBoundsException Excepción que saltará en caso de que la posición introducida sea superior al tamaño del array.
     */
    public User get(int index) throws IndexOutOfBoundsException {
        if (index > 0 || index < users.length) {
            return users[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Método que devolverá el primero usuario introducido.
     * @return Usuario que ocupa la primera posición de la cola.
     */
    public User get() {
        return users[0];
    }

}
