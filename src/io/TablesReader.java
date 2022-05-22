package io;

import tables.Advertising;
import tables.Table;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Clase que se encargará de leer el fichero para cargar la información de las tablas.
 */
public class TablesReader {

    /**
     * Ruta relativa de la ubicación del fichero.
     */
    private final String path = "data/tables/tablesM.paed";

    /**
     * Cargará el fichero y creará la estructura del árbol.
     * @return Nodo raíz del árbol.
     */
    public Table readFile() {

        int initialSize;

        try {

            File archivo = new File(path);
            Scanner myReader = new Scanner(archivo);

            initialSize = Integer.parseInt(myReader.nextLine());

            String input = myReader.nextLine();
            String[] inputParse = input.split(";");
            String name = inputParse[0];
            String date = inputParse[1];
            int price = Integer.parseInt(inputParse[2]);

            Table table = new Table(initialSize);
            Advertising advertising = new Advertising(name, date, price);
            table.put(name, advertising);

            for (int i = 0; i < initialSize - 1; i++) {

                input = myReader.nextLine();
                inputParse = input.split(";");

                name = inputParse[0];
                date = inputParse[1];
                price = Integer.parseInt(inputParse[2]);
                advertising = new Advertising(name, date, price);

                table.put(name, advertising);

            }

            return table;

        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist");
            return null;
        }

    }
}

