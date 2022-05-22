package graphs;

import utilities.ArrayList;

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
