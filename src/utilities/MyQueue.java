package utilities;

import entities.User;

/**
 *
 */
public class MyQueue {

    private User[] users;

    private int size;

    private static final int DEFAULT_CAPACITY = 10;


    public MyQueue() {
        this.users = new User[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add(User u){
        if (users.length == size)
            users = grow();
        users[size] = u;
        size += 1;
    }

    private User[] grow() {
       User[] aUsers = new User[size+1];
       for (int i = 0; i < users.length; i++){
           aUsers[i] = this.users[i];
       }
       return this.users = aUsers;
    }

    private void decrease(){
        User[] aUsers = new User[size-1];
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

    public int size(){
        return size;
    }

    /**
     * Se usa antes del get para asegurar que aun hay datos en la queue y para al acabar, asegurar que la queue esta vacia
     */
    public boolean isEmpty(){
        return size == 0;
    }

    public User get(int index) throws IndexOutOfBoundsException {
        if (index > 0 || index < users.length) {
            return users[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public User get() {
        return users[0];
    }

}
