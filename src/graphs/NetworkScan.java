package graphs;

import utilities.ArrayList;
import utilities.MyQueue;

import java.util.Arrays;

public class NetworkScan {

    private final User[] users;
    private MyQueue queue;
    private final Algorithm a;

    // BFS
    public NetworkScan(User[] users) {
        this.users = Arrays.copyOf(users, users.length);
        this.queue = new MyQueue();
        this.a = new Algorithm();
    }

    public void run() {

        User[] users = a.sortByFollows(this.users.clone(), 0, this.users.length-1);
        System.out.println("L'usuari que segueix més comptes és: \n\n" + users[0].toString());
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

        queue.add(user);
        user.setVisited(true);

        while (!queue.isEmpty()) {

            User u = queue.get();
            queue.remove();
            ArrayList<User> adjacents = getFollows(u);

            if (!adjacents.isEmpty())
                System.out.println("Aquests són els comptes que segueix al usuari " + u.getId() + " : \n");

            for (int i = 0; i < adjacents.size(); i++) {

                User adj = adjacents.get(i);
                System.out.println(adj.toString());

                if (!adj.isVisited()) {
                    queue.add(adjacents.get(i));
                    adj.setVisited(true);
                }
            }

        }

    }

    /**
     * Nos devolverá todos los nodos/usuarios adyacentes del nodo/usuario actual.
     *
     * @param user nodo/usuario actual.
     * @return cola con los nodos/usuarios adyacentes del nodo/usuario actual.
     */
    private ArrayList<User> getFollows(User user) {

        ArrayList<Follow> follows = user.getFollows();
        ArrayList<User> adjacents = new ArrayList<>();

        if (follows.isEmpty())
            return adjacents;

        for (int i = 0; i < follows.size(); i++) {
            int objectiveId = follows.get(i).getIdUser();
            // Debido a que solo tenemos el identificador del usuario usaremos una búsqueda binaria para encontrar al usuario con dicho identificador.
            User u = a.binarySearch(this.users, objectiveId, 0, this.users.length-1);
            // Añadiremos todos los nodos adyacentes al nodo actual.
            adjacents.add(u);
        }

        return adjacents;
    }

}
