package graphs;

import entities.Algorithm;
import entities.Follow;
import utilities.MyQueue;
import entities.User;

import java.util.Arrays;

public class NetworkScan {

    private User[] unsortedUsers;
    private Algorithm a;

    // BFS
    public NetworkScan(User[] users) {
        this.unsortedUsers = Arrays.copyOf(users, users.length);
        this.a = new Algorithm();
    }

    public void bfs(User[] users, User user) {
        user.setVisited(true);
        MyQueue queue = getUserFollows(user);
        System.out.println(user.getId());

        while (!queue.isEmpty()) {
            User u = queue.get();
            if (!u.isVisited()) {
                bfs(users, u);
            }
            queue.remove();
        }

        for (User u : users) {
            if (!u.isVisited()) {
                bfs(users, u);
            }
        }

    }

    private MyQueue getUserFollows(User user) {
        MyQueue queue = new MyQueue();
        for (int i = 0; i < user.getFollows().size(); i++) {
            int objectiveId = user.getFollows().get(i).getIdUser();
            User u = a.binarySearch(this.unsortedUsers, objectiveId, 0, this.unsortedUsers.length);
            queue.add(u);
        }
        return queue;
    }

}
