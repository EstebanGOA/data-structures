package io;

import entities.Node;
import entities.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TreeReader {

    /**
     * Ruta relativa de la ubicación del fichero.
     */
    private final String path = "data/trees/treeXXS.paed";

    /**
     * Cargará el fichero y creará la estructura del árbol.
     * @return Nodo raíz del árbol.
     */
    public Node readFile() {

        int numAlgorithms;

        try {

            File archivo = new File(path);
            Scanner myReader = new Scanner(archivo);

            numAlgorithms = Integer.parseInt(myReader.nextLine());

            String input = myReader.nextLine();
            String[] inputParse = input.split(";");

            Node node = new Node(Integer.parseInt(inputParse[0]), inputParse[1], inputParse[2], inputParse[3], Long.parseLong(inputParse[4]));
            Tree tree = new Tree();

            for (int i = 0; i < numAlgorithms - 1; i++) {
                input = myReader.nextLine();
                inputParse = input.split(";");
                Node nodeAux = new Node(Integer.parseInt(inputParse[0]), inputParse[1], inputParse[2], inputParse[3], Long.parseLong(inputParse[4]));
                // insert node
                node = tree.insertAVL(node, nodeAux);
            }

            return node;

        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist");
            return null;
        }
    }
}

