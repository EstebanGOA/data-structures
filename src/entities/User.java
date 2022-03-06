package entities;

import utilities.ArrayList;
import utilities.MyFollowerList;

import java.util.Arrays;

public class User {

    private final int id;
    private final String name;
    private final String alias;
    private final String[] interests;
    private boolean visited;
    private ArrayList<Follow> follows;
    private ArrayList<Follow> followed;

    //variables para Recomanació

    private boolean jaSegueix=false;    // priorizacion de cuentas que siguen al usuario
    private double points=0;             // si un follower mio (s) le sigue  a (u) o (s) me sigue a mi (u): +1
                                        // si compartimos intereses, +0.1

    public User(int id, String name, String alias, String[] interests) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.interests = interests;
        this.visited = false;
        this.follows = new ArrayList<Follow>();
        this.followed = new ArrayList<>();
    }

    public void setFollows(ArrayList<Follow> follows) {
        this.follows = follows;
    }

    public ArrayList<Follow> getFollowed() {
        return followed;
    }

    public ArrayList<Follow> getFollows() {
        return follows;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public String[] getInterests() {
        return interests;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }



    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("\t" + id + " - " + name + " (" + alias + ")\n\tInteressos: ");
        if (interests != null) {
            for (int i = 0; i < interests.length; i++) {
                if (i != interests.length - 1)
                    string.append(interests[i]).append(",");
                else
                    string.append(interests[i]);
            }
        }
        return string.append("\n").toString();
    }

    public boolean isJaSegueix() {
        return jaSegueix;
    }

    public void setJaSegueix(boolean jaSegueix) {
        this.jaSegueix = jaSegueix;
    }


    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }
}
