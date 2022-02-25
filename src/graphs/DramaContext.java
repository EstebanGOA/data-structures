package graphs;

import entities.Algorithm;
import entities.Follow;
import utilities.MyQueue;
import entities.User;

public class DramaContext {

    Algorithm algorithm = new Algorithm();

    public MyQueue topoSort(User[] users){
        MyQueue queue = new MyQueue();
        MyQueue usersQueue = getNodes(users); // Queue with all the nodes that aren't being followed

        while (!usersQueue.isEmpty()) {
            User u = usersQueue.pop();
            queue.add(u);
            for (int i = 0; i < u.getFollowed().size(); i++) {

                int index = algorithm.binSearch(users, u.getFollowed().get(i).getIdUser(), 0, users.length);

                for(int j = 0; j < users[index].getFollows().size(); j++) {
                    // Remove the follows
                    users[index].getFollows().

                }
            }

        }

        return queue;
    }

    /**
     * Method that returns a queue with all the nodes without predecessors
     * @param users array of all the users
     * @return Returns A queue with all the users
     */
    public MyQueue getNodes(User[] users){
        MyQueue queue = new MyQueue();

        // Check if the user is followed
        for(User u: users){
            if( u.getFollows() == null){
                queue.add(u);
            }
        }
        return queue;
    }



}
