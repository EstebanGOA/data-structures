package entities;

import entities.MyFollowerList;

public class User {

    private final int id;
    private final String name;
    private final String alias;
    private final String[] interests;
    private boolean visited;
    private MyFollowerList followsList;
    //variables para Recomanació
    private boolean seguidasPorSeguido=false; // priorizacion de cuentas seguidas por un seguidor del usuario
    private boolean jaSegueix=false;    // priorizacion de cuentas que siguen al usuario
    private boolean seguidor=false;
    private int interessos=0;           // priorizacion de cuentas que comparten interes con el usuario


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


    public boolean isSeguidasPorSeguido() {
        return seguidasPorSeguido;
    }

    public boolean isJaSegueix() {
        return jaSegueix;
    }

    public int getInteressos() {
        return interessos;
    }

    public boolean isSeguidor() {
        return seguidor;
    }


    public void setSeguidasPorSeguido(boolean seguidasPorSeguid) {
        this.seguidasPorSeguido = seguidasPorSeguido;
    }

    public void setJaSegueix(boolean jaSegueix) {
        this.jaSegueix = jaSegueix;
    }

    public void setInteressos(int interessos) {
        this.interessos = interessos;
    }

    public void setSeguidor(boolean seguidor) {
        this.seguidor = seguidor;
    }

}
