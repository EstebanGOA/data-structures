import entities.Follow;
import entities.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserReader {

        public User[] readFile(String ruta) {
            String input;
            String[] inputParse = new String[4];
            String[] intersets = new String[50];

            int numUsers, numInteractions;
            User[] users = new User[0];
            try {
                File archivo = new File(ruta);
                Scanner myReader = new Scanner(archivo);

                numUsers = Integer.parseInt(myReader.nextLine());

                users = new User[numUsers];
                for (int i = 0; i < numUsers; i++) {
                    input = myReader.nextLine();
                    inputParse = input.split(";");

                    User user = new User(Integer.parseInt(inputParse[0]), inputParse[1], inputParse[2], intersets);
                    users[i] = user;
                }

                numInteractions = Integer.parseInt(myReader.nextLine());
                for (int i = 0; i < numInteractions; i++) {
                    input = myReader.nextLine();
                    inputParse = input.split(";");
                    Follow follow = new Follow(Integer.parseInt(inputParse[1]),
                            Integer.parseInt(inputParse[2]),
                            Integer.parseInt(inputParse[3]));

                    for (int j = 0; j < users.length; j++) {
                        if (Integer.parseInt(inputParse[0]) == users[j].getId()) {

                            users[j].getFollowsList().add(follow);
                        }
                    }

                }


            } catch (FileNotFoundException e) {
                System.out.println("The file does not exist");
            }
            return users;
        }
}
