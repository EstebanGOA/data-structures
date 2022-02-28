package graphs;

import entities.Algorithm;
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
        this.nodeInical = a.binSearch(this.users, nodeInical, 0 , users.length);
        this.nodeFinal = a.binSearch(this.users, nodeFinal, 0 , users.length);
        d = new int[users.length];

    }
    public void dijkstra(){
        MyQueue queue = new MyQueue();
        int nova = 0;
        int actual = nodeInical;
        while (!users[nodeFinal].isVisited()) {
            ArrayList<Follow> followed = users[actual].getFollowed();
            for( int i = 0; i < followed.size(); i++) {
                int adj = a.binSearch(users, followed.get(i).getIdUser(), 0, users.length);
                if (!users[adj].isVisited()) {
                    nova = d[actual] + followed.get(i).getTimestamp();
                    if(d[adj] > nova){
                        d[adj] = nova;
                    }
                }
            }
        }

    }

}
