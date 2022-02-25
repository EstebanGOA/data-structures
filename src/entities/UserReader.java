package entities;

import entities.Follow;
import entities.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserReader {

        public User[] readFile(String ruta) {

            int numUsers, numInteractions;

            try {
                File archivo = new File(ruta);
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
                            users[j].getFollowedList().add(followed);
                        }

                        // If to add the interaction to the one who is followed by the other user
                        if (Integer.parseInt(inputParse[1]) == users[j].getId()) {
                            users[j].getFollowsList().add(follower);
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
