package graphs;

public class Follow {

    private final int idUser;
    private final int timestamp;
    private int interactions;

    public Follow(int idUser, int timestamp, int interactions) {
        this.idUser = idUser;
        this.timestamp = timestamp;
        this.interactions = interactions;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public int getInteractions() {
        return interactions;
    }

    public void setInteractions(int interactions) {
        this.interactions = interactions;
    }

}
