package io;

import entities.Node;
import entities.TreeAlgorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TreeReader {

    private final String path = "data/trees/treeXXS.paed";

    public Node readFile() {

        int numAlgorithms;

        try {

            File archivo = new File(path);
            Scanner myReader = new Scanner(archivo);

            numAlgorithms = Integer.parseInt(myReader.nextLine());

            String input = myReader.nextLine();
            String[] inputParse = input.split(";");
            Node node = new Node(Integer.parseInt(inputParse[0]), inputParse[1], inputParse[2], inputParse[3], Long.parseLong(inputParse[4]));

            TreeAlgorithm tree = new TreeAlgorithm();

            for (int i = 0; i < numAlgorithms - 1; i++) {
                input = myReader.nextLine();
                inputParse = input.split(";");
                Node nodeAux = new Node(Integer.parseInt(inputParse[0]), inputParse[1], inputParse[2], inputParse[3], Long.parseLong(inputParse[4]));
                // insert node
                tree.insert(node, nodeAux);
            }

            return node;

        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist");
            return null;
        }
    }
}

