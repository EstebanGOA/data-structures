package graphs;

import entities.Algorithm;
import entities.Follow;
import utilities.ArrayList;
import utilities.MyQueue;
import entities.User;

import java.util.Arrays;

public class NetworkScan {

    private final User[] users;
    private final Algorithm a;

    // BFS
    public NetworkScan(User[] users) {
        this.users = Arrays.copyOf(users, users.length);
        this.a = new Algorithm();
    }

    public void run() {

        User[] users = a.sortByFollows(this.users.clone(), 0, this.users.length-1);
        System.out.println("L'usuari que segueix més comptes és: \n");
        System.out.println(users[0].toString());
        bfs(users, users[0]);

        for (User u : users) {
            if (!u.isVisited()) {
                System.out.println("Aquest usuari no es seguit per ningú: \n");
                System.out.println(u.toString());
                bfs(users, u);
            }
        }

    }

    private void bfs(User[] users, User user) {

        user.setVisited(true);
        MyQueue queue = getUserFollows(user);

        while (!queue.isEmpty()) {
            User u = queue.get();
            if (!u.isVisited()) {
                bfs(users, u);
            }
            queue.remove();
        }

    }

    private MyQueue getUserFollows(User user) {
        MyQueue queue = new MyQueue();
        ArrayList<Follow> follows = user.getFollows();

        if (!follows.isEmpty())
            System.out.println("Aquests són els comptes que segueixen: \n");

        for (int i = 0; i < follows.size(); i++) {
            int objectiveId = follows.get(i).getIdUser();
            User u = a.binarySearch(this.users, objectiveId, 0, this.users.length-1);
            if (!u.isVisited()) {
                System.out.println(u.toString());
                queue.add(u);
            }
        }
        return queue;
    }

}
