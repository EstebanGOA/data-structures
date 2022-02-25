package entities;

import entities.MyFollowerList;

public class User {

    private final int id;
    private final String name;
    private final String alias;
    private final String[] interests;
    private boolean visited;
    private MyFollowerList followerList;
    private MyFollowerList followedList;

    public User(int id, String name, String alias, String[] interests) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.interests = interests;
        this.visited = false;
        this.followedList = new MyFollowerList();
    }

    public void setFollows(MyFollowerList followsList) {
        this.followedList = followsList;
    }

    public MyFollowerList getFollowsList() {
        return followedList;
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

    public boolean isVisited() {
        return visited;
    }

    public MyFollowerList getFollowedList() {
        return followedList;
    }

}
