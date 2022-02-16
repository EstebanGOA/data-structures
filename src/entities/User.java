package entities;

import entities.MyFollowerList;

public class User {

    private final int id;
    private final String name;
    private final String alias;
    private final String[] interests;
    private boolean visited;
    private MyFollowerList followsList;

    public User(int id, String name, String alias, String[] interests) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.interests = interests;
        this.visited = false;
        this.followsList = new MyFollowerList();
    }

    public void setFollows(MyFollowerList followsList) {
        this.followsList = followsList;
    }

    public MyFollowerList getFollowsList() {
        return followsList;
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

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

}
