package graphs;

import entities.Algorithm;
import entities.Follow;
import utilities.MyQueue;
import entities.User;

import java.util.Arrays;

public class DramaContext {

    private User[] users;
    private Algorithm algorithm;

    public DramaContext(User[] users){
        this.users = Arrays.copyOf(users, users.length);
        algorithm = new Algorithm();
    }
    public void topoSort(){
        MyQueue queue = new MyQueue();
        MyQueue usersQueue = getNodes(users); // Queue with all the nodes that aren't being followed

        while (!usersQueue.isEmpty()) {

            User u = usersQueue.get();
            usersQueue.remove();
            queue.add(u);
            for (int i = 0; i < u.getFollowed().size(); i++) {

                int index = algorithm.binSearch(users, u.getFollowed().get(i).getIdUser(), 0, users.length);

                for(int j = 0; j < users[index].getFollows().size(); j++) {
                    // Remove the follows

                    if(users[index].getFollows().get(j).getIdUser() == u.getId()){
                        users[index].getFollows().remove(users[index].getFollows().get(j));


                        if(users[index].getFollows().isEmpty()){
                            usersQueue.add(users[index]);
                        }
                    }

                }
            }

        }

        while(!queue.isEmpty()){
            User u = queue.get();
            queue.remove();
            System.out.println(u.getId() + " - " + u.getName() + " (" + u.getAlias() + ")");
            if(!queue.isEmpty())  System.out.println("↓");
        }

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
            if( u.getFollows().size() == 0){
                queue.add(u);
            }
        }
        return queue;
    }



}
