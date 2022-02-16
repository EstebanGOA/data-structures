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
                    Follow follow = new Follow(Integer.parseInt(inputParse[1]),
                            Integer.parseInt(inputParse[2]),
                            Integer.parseInt(inputParse[3]));

                    for (int j = 0; j < users.length; j++) {
                        if (Integer.parseInt(inputParse[0]) == users[j].getId()) {
                            users[j].getFollowsList().add(follow);
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
