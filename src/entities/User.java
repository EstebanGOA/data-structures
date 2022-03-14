package entities;

import utilities.ArrayList;
import utilities.MyFollowerList;

import java.util.Arrays;

public class User {

    private final int id;
    private final String name;
    private final String alias;
    private final String[] interests;
    private ArrayList<Follow> follows;
    private ArrayList<Follow> followed;

    /**
     * Variables utilizadas para la aplicación de los diferentes algoritmos.
     */
    private boolean visited;
    private double points;

    public User(int id, String name, String alias, String[] interests) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.interests = interests;
        this.follows = new ArrayList<Follow>();
        this.followed = new ArrayList<>();
        this.visited = false;
        this.points = 0;
    }

    /**
     * Incrementará la puntuación del usuario para el sistema de recomendación.
     * @param decimal Si es true significa que estamos incrementando de forma decimal y, por tanto, incrementaremos únicamente 0.1 el valor actual,
     *                en caso de ser false, incrementaremos en 1 punto el valor actual.
     */
    public void increment(boolean decimal) {
        if (decimal) {
            points += 0.1;
        } else {
            points++;
        }
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

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
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

}
