package graphs;

import entities.Algorithm;
import entities.Camins;
import entities.Follow;
import entities.User;
import utilities.MyQueue;
import utilities.ArrayList;

import java.util.Arrays;

public class FacilitacioNet {

    private User[] users;
    private Algorithm a;
    private int nodeInical;
    private int nodeFinal;
    private int[] d;

    public FacilitacioNet(User[] users, int nodeInical, int nodeFinal){
        this.users = Arrays.copyOf(users, users.length);
        a = new Algorithm();
        this.nodeInical = a.binSearch(this.users, nodeInical, 0 , users.length);
        this.nodeFinal = a.binSearch(this.users, nodeFinal, 0 , users.length);
        d = new int[users.length];
    }

    public void dijkstra() {

        MyQueue queue = new MyQueue();


            Arrays.fill(d, Integer.MAX_VALUE);
            Camins[] camins = new Camins[users.length];

            // Initialize the arrays
            for (int i = 0; i < users.length; i++) {
                camins[i] = new Camins();
            }
            camins[nodeInical].add(users[nodeInical]);

            int nova;
            int actual = nodeInical;
            d[actual] = 0;
            while (!users[nodeFinal].isVisited()) {
                ArrayList<Follow> followed = users[actual].getFollowed();
                for (int i = 0; i < followed.size(); i++) {
                    int adj = a.binSearch(users, followed.get(i).getIdUser(), 0, users.length);
                    if (!users[adj].isVisited()) {
                        nova = d[actual] + followed.get(i).getTimestamp();
                        if (d[adj] > nova) {
                            d[adj] = nova;
                            // update camins
                            for (int j = 0; j < camins[actual].size(); j++) {
                                User aux = camins[actual].get(j);
                                camins[adj].add(aux);

                            }
                            camins[adj].add(users[adj]);
                        }
                    }
                }
                users[actual].setVisited(true);
                int seguent = Integer.MAX_VALUE;
                for (int i = 0; i < users.length; i++) {
                    if (seguent > d[i] && !users[i].isVisited()) {
                        seguent = d[i];
                        actual = i;
                    }
                }

            }

            // Uncheck the nodes
            for (User user : users) {
                user.setVisited(false);
            }

            // Print the result
            System.out.println();
            for (int i = 0; i < camins[nodeFinal].size(); i++) {
                System.out.println((i + 1) + "- " + camins[nodeFinal].get(i).getName() + " (" + camins[nodeFinal].get(i).getAlias() + ")");
                if (i != camins[nodeFinal].size() - 1) System.out.println("↓");
            }
            System.out.println("The total cost is: " + d[nodeFinal]);

        }

    }
