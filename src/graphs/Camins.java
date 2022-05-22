package graphs;

import utilities.ArrayList;

/**
 * Clase que almacenará funciones que nos serán utiles para la implementación del Dijkstra. 
 */
public class Camins {

    private ArrayList<User> cami;

    public Camins(){
        cami = new ArrayList<>();
    }

    public User get(int index) {
        return cami.get(index);
    }

    public void setCami(ArrayList<User> cami) {
        this.cami = cami;
    }

    public int size(){
        return cami.size();
    }

    public void add(User u){
        cami.add(u);
    }

}
