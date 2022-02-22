package graphs;

import entities.MyQueue;
import entities.User;

public class NetworkScan {

    private MyQueue[] queue;
    private User[] users;

    // BFS
    public NetworkScan() {

    }

    public void bfs(User[] users, User user) {
        user.setVisited(true);

    }

}
