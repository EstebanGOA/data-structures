package entities;

import entities.MyFollowerList;

public class User {
    private int id;
    private String name;
    private String alias;
    private String[] interests;
    private MyFollowerList followsList;

    public User(int id, String name, String alias, String[] interests) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.interests = interests;
        this.followsList = new MyFollowerList();
    }

    public void setFollows(MyFollowerList followsList) {
        this.followsList = followsList;
    }

    public MyFollowerList getFollowsList() {
        return followsList;
    }
}
