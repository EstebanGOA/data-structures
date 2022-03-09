package entities;

import graphs.DramaContext;
import graphs.FacilitacioNet;
import graphs.NetworkScan;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner;
    private User[] users;
    private Node source;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.users = new UserReader().readFile();
        this.source = new TreeReader().readFile();
    }


    public void run() {
        boolean exit = false;
        while(!exit) {

            mainMenu();
            int option = askForInteger("Escull una opció: ");
            switch (option) {
                case 1 -> {
                    executeFirstOption();
                }
                case 2 -> {
                    executeSecondOption();
                }
                case 5 -> {
                    exit = true;
                    System.out.println("\nAturant LinkedTree...");
                }
                default -> {
                    System.out.println("\n\tLa opció especificada no está implementada");
                }
            }

        }
    }

    private void executeSecondOption() {
        while (true) {
            String option = treesMenu();
            System.out.println();
            switch(option) {
                case "A" -> {
                    // Añadir algoritmo
                }
                case "B" -> {
                    // Eliminar algoritmo
                }
                case "C" -> {
                    // Listar algoritmos
                }
                case "D" -> {
                    // Buscar por timestamp (exacto)
                }
                case "E" -> {
                    // Buscar por timestamp (rango)
                }
                case "F" -> {
                    return ;
                }
            }
        }
    }

    private void executeFirstOption() {
        while (true) {
            String option = followersMenu();
            System.out.println();
            switch (option) {
                case "A" -> {
                    NetworkScan nScan = new NetworkScan(users);
                    nScan.run();
                }
                case "B" -> {


                }
                case "C" -> {
                    DramaContext dramaC = new DramaContext(users);
                    dramaC.topoSort();
                }
                case "D" -> {
                    int nodeA = askForInteger("Entra el teu identificador: ");
                    int nodeB = askForInteger("Entra l'identificador de l'altre usuari: ");
                    FacilitacioNet facilitacioNet = new FacilitacioNet(users, nodeA, nodeB);
                    facilitacioNet.dijkstra();
                }
                case "E" -> {
                    return ;
                }
            }
        }
    }

    private String askForString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    private int askForInteger(String msg) {
        try {
            System.out.print(msg);
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private String treesMenu() {
        System.out.println("\n\tA. Afegir algorisme");
        System.out.println("\tB. Eliminar algorisme");
        System.out.println("\tC. Llistar algorismes");
        System.out.println("\tD. Cerca per timestamp (exacta)");
        System.out.println("\tE. Cerca per timestamp (reng)");
        System.out.println("\n\tF. Tornar entere");
        return askForString("Quina funcionalitat vols executar? ");
    }

    private String followersMenu() {
        System.out.println("\n\tA. Explorar la xarxa.");
        System.out.println("\tB. Recomanar usuaris");
        System.out.println("\tC. Contextualizar drama");
        System.out.println("\tD. Networking");
        System.out.println("\n\tE. Tornar enrere\n");
         return askForString("Quina funcionalitat vols executar? ");
    }

    private void mainMenu() {
        System.out.println("\n.* LinkedTree *.\n");
        System.out.println("1. Seguidors (Grafs)");
        System.out.println("2. A ESPECIFICAR");
        System.out.println("3. A ESPECIFICAR");
        System.out.println("4. A ESPECIFICAR\n");
        System.out.println("5. Sortir\n");
    }

}
