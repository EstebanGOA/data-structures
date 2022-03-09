package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserReader {

    private final String path = "data/graphM.paed";

    public User[] readFile() {

        int numUsers, numInteractions;

        try {
            File archivo = new File(path);
            Scanner myReader = new Scanner(archivo);

            numUsers = Integer.parseInt(myReader.nextLine());

            User[] users = new User[numUsers];
            String[] interests;
            for (int i = 0; i < numUsers; i++) {
                String input = myReader.nextLine();
                String[] inputParse = input.split(";");
                if(inputParse.length >3) {
                    interests = inputParse[3].split(",");
                } else {
                    interests = null;
                }

                User user = new User(Integer.parseInt(inputParse[0]), inputParse[1], inputParse[2], interests);
                users[i] = user;
            }

                numInteractions = Integer.parseInt(myReader.nextLine());
                for (int i = 0; i < numInteractions; i++) {
                    String input = myReader.nextLine();
                    String[] inputParse = input.split(";");
                    Follow followed = new Follow(Integer.parseInt(inputParse[1]),
                            Integer.parseInt(inputParse[2]),
                            Integer.parseInt(inputParse[3]));
                    Follow follower = new Follow(Integer.parseInt(inputParse[0]),
                            Integer.parseInt(inputParse[2]),
                            Integer.parseInt(inputParse[3]));

                    /*
                        A -> B
                        We add to A that he follows B on the A user
                        and also that B is being followed by A in the B user
                    */

                    for (int j = 0; j < users.length; j++) {
                        // If to add the interaction to the one who follows the other user
                        if (Integer.parseInt(inputParse[0]) == users[j].getId()) {
                            users[j].getFollowed().add(followed);
                        }

                        // If to add the interaction to the one who is followed by the other user
                        if (Integer.parseInt(inputParse[1]) == users[j].getId()) {
                            users[j].getFollows().add(follower);
                        }
                    }

                }
                return users;
            } catch (FileNotFoundException e) {
                System.out.println("The file does not exist");
                return null;
            }
        }
}
