package entities;

import java.util.Queue;

public class MyQueue {
    /**
     * TODO pa no liarnos, esta es la FIFO
     */

    private User[] u;
    private int size;

    public MyQueue(){
        u=new User[1];
        this.size=0;
    }

    public void add(User d){
        if (u.length == size) {
            grow();
        }
        u[size] = d;
        size++;
    }

    private void grow(){
       User[] u= new User[size];
       for(int i=0;i<size-1;i++){
           u[i]=this.u[i];
       }
       this.u = u;
    }

    private void decrease(){
        User[] u = new User[size-1];
        for(int i=0;i<size-1;i++){
            u[i]=this.u[i+1];
        }
        this.u=u;
    }

    public void remove(Integer d){
        //removeo el posicion 0 y muevo todp el resto a -1
        decrease();
        size--;
    }

    public int size(){
        return size;
    }

    public User get(int d){
        User user;
        try {
            user = new User(this.u[d-1].getId(), this.u[d-1].getName(), this.u[d-1].getAlias(), this.u[d-1].getInterests());
            /**
             * si el u[d-1] no existe, al copiarlo en user dara error, lo q no se como hacer es que me devuelva si error, devuelvo un user vacio??
             */
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }

        return this.u[d-1];
    }

    public User get(){
        return this.u[0];
    }

}
