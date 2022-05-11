package entities;

import graphs.DramaContext;
import graphs.FacilitacioNet;
import graphs.NetworkScan;
import io.RTreeReader;
import io.TreeReader;
import io.UserReader;
import tables.Advertising;
import tables.JTableDrawer;
import tables.Table;
import tables.TablesReader;
import trees.TreeDelete;
import graphs.Recommendation;
import trees.Feed;
import trees.TreeSearchNode;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner;
    private User[] users;
    private Node source;
    private Rectangle rectangle;
    private Table table;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.users = new UserReader().readFile();
        this.source = new TreeReader().readFile();
        this.rectangle = new RTreeReader().readFile();
        this.table = new TablesReader().readFile();
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
                case 3 -> {
                    executeThridOption();
                }
                case 4 -> {
                    executeFourthOption();
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

    private void executeFourthOption() {
        while (true) {
            String option = tablesMenu();
            System.out.println();
            switch(option) {
                case "A" -> {
                    // Añadir empresa
                    String name = askForString("Entra el nom de l'empresa a afegir: ");
                    String date = askForString("Entra el dia de la setmana en el que está interessada: ");
                    int price = askForInteger("Entra el preu que pot pagar, en euros: ");
                    Advertising advertising = new Advertising(name, date, price);
                    table.put(name, advertising);
                    System.out.println("\nL'empresa s'ha afegit correctament al sistema gestor d'anuncis.");
                }
                case "B" -> {
                    // Eliminar empresa
                    String name = askForString("Entra el nom de l'empresa a eliminar: ");
                    table.remove(name);
                    System.out.println("\nL'empresa s'ha eliminat correctament del sistema gestor d'anuncis.");
                }
                case "C" -> {
                    // Consultar empresa
                    String name = askForString("Entra el nom de l'empresa a consultar: ");
                    Advertising advertising = table.get(name);
                    if (advertising != null) {
                        System.out.println(advertising.toString());
                    } else {
                        System.out.println("No s'ha trobat cap empresa amb el nom introduït. ");
                    }
                }
                case "D" -> {
                    // Histograma por dias
                    JFrame frame = new JFrame("Histogram Panel");
                    frame.setSize(1280, 720);
                    frame.add(new JTableDrawer(table.countDays()), BorderLayout.CENTER );
                    frame.setResizable(true);
                    frame.setVisible(true);
                }
                case "E" -> {
                    return ;
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
                    int id = askForInteger("Identificador de l'algorisme: ");
                    String name = askForString("Nom de l'algorisme: ");
                    String language = askForString("Llenguatge de l'algorisme: ");
                    String cost = askForString("Cost de l'algorisme: ");
                    long timestamp = askForLong("Timestamp de l'algorisme: ");
                    Node node = new Node(id, name, language, cost, timestamp);
                    Tree tree = new Tree();
                    /*
                    TODO: Si cambiamos de tipo de árbol (autobalanceado o no) tenemos que cambiar esta línea.
                     */
                    tree.insert(source, node);
                    System.out.println("\nL'algorisme ha estat correctament afegit al feed.");
                }
                case "B" -> {
                    int id = askForInteger("Identificador de l'algorisme: ");
                    TreeDelete treeDelete = new TreeDelete(source);
                    source = treeDelete.run(source, id);
                }
                case "C" -> {
                    Feed feed = new Feed(source);
                    feed.run();
                }
                case "D" -> {
                    TreeSearchNode treeSearchNode = new TreeSearchNode();
                    long number = askForLong("\nTimestamp a cercar: ");
                    treeSearchNode.findByTimestamp(source, number);
                }
                case "E" -> {
                    TreeSearchNode treeSearchNode = new TreeSearchNode();
                    long lowerTimestamp = askForLong("Timestamp mínim a cercar: ");
                    long higherTimestamp = askForLong("Timestamp màxim a cercar: ");
                    treeSearchNode.findByRange(source, lowerTimestamp, higherTimestamp);
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
                    int id = askForInteger("Entra el teu identificador: ");
                    Recommendation rec = new Recommendation();
                    rec.run(users, id);
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

    private void executeThridOption(){
        while (true) {
            String option = circlesMenu();
            System.out.println();
            switch (option) {
                case "A" -> {
                    double x = askForDouble("Entra la coordenada X del centre del cercle a afegir: ");
                    double y = askForDouble("Entra la coordenada Y del centre del cercle a afegir: ");
                    double radious = askForDouble("Entra el radi del cercle a afegir: ");
                    String color = askForString("Entra el color del cercle a afegir: ");
                    Point point = new Point(x, y, radious, color);
                    TreeR treeR = new TreeR();
                    this.rectangle = treeR.delete(this.rectangle, point);

                }
                case "B" -> {
                    double x = askForDouble("Entra la coordenada X del centre del cercle a eliminar: ");
                    double y = askForDouble("Entra la coordenada Y del centre del cercle a eliminar: ");
                    Point point = new Point(x, y, 0, null);
                    TreeR treeR = new TreeR();
                    this.rectangle = treeR.delete(this.rectangle, point);
                    System.out.println("hola");
                }
                case "C" -> {
                    JFrame window = new JFrame();
                    window.setSize(1920, 1080);
                    JTreeDraw draw = new JTreeDraw(rectangle);
                    window.add(draw, BorderLayout.CENTER);
                    window.setVisible(true);
                }
                case "D" -> {

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

    private long askForLong(String msg) {
        try {
            System.out.print(msg);
            return Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private double askForDouble(String msg) {
        try {
            System.out.print(msg);
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private String tablesMenu() {
        System.out.println("\n\tA. Afegir una empresa");
        System.out.println("\tB. Eliminar una empresa");
        System.out.println("\tC. Consultar empresa");
        System.out.println("\tD. Histograma per dies");
        System.out.println("\n\tE. Tornar enrere\n");
        return askForString("Quina funcionalitat vols executar? ");
    }

    private String treesMenu() {
        System.out.println("\n\tA. Afegir algorisme");
        System.out.println("\tB. Eliminar algorisme");
        System.out.println("\tC. Llistar algorismes");
        System.out.println("\tD. Cerca per timestamp (exacta)");
        System.out.println("\tE. Cerca per timestamp (reng)");
        System.out.println("\n\tF. Tornar entere\n");
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

    private String circlesMenu() {
        System.out.println("\n\tA. Afegir cercle");
        System.out.println("\tB. Eliminar cercle");
        System.out.println("\tC. Visualitzar");
        System.out.println("\tD. Cerca per área");
        System.out.println("\tE. Cerca especial");
        System.out.println("\n\tF. Tornar enrere\n");
        return askForString("Quina funcionalitat vols executar? ");

    }

    private void mainMenu() {
        System.out.println("\n.* LinkedTree *.\n");
        System.out.println("1. Seguidors (Grafs)");
        System.out.println("2. Feed (Arbres)");
        System.out.println("3. Canvas (Arbres R)");
        System.out.println("4. Anuncis (Taules)\n");
        System.out.println("5. Sortir\n");
    }

}
