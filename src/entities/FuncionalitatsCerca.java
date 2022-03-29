package entities;

import utilities.MyQueue;

import utilities.ArrayList;
import java.util.Date;
import java.util.Random;

public class FuncionalitatsCerca {

    private ArrayList<Node> printer;

    public FuncionalitatsCerca() {
        printer = new ArrayList<>();
    }

    /**
     * Ire comparando mi numero con un timestamp de un nodo, si es mayor,
     * coge el nodo derecho y lo pongo em el nodo que miro, sino coge el izquierdo.
     * Si por algun caso me da exception, eso es que no hay menor/mayor, significa que no existe
     * @param num   numero exacto que tengo que buscar
     * @param node nodo inicial, de donde cuelgan todos los otros
     */
    public void cercaExacta(long num, Node node){

        if (node == null) {
            System.out.println("No existeix un algorisme amb un timestamp de " + num);
            return;
        }

        if(num == node.getTimestamp()) {
            System.out.println("\nS'ha trobat un algorisme... " + node.getName() + ": " + node.getId() + ", " + node.getCost());
        } else {
            if(num > node.getTimestamp()) {
                cercaExacta(num, node.getRight());
            } else {
                cercaExacta(num, node.getLeft());
            }
        }


    }

    public void cercaRang(long numMin, long numMax, Node source) {

        trobat(numMin, numMax, source);

        if(printer.size() > 0) {

            System.out.println("S'han trobat " + printer.size() + " algorismes en aquest rang...\n");
            for(int i=0;i<printer.size();i++) {
              //  System.out.println("\t" + printer.get(i).getName() + ": " + printer.get(i).getLanguage() + ", " + printer.get(i).getCost() + " - " + printer.get(i).getTimestamp());
                System.out.println("\t" + printer.get(i).getName() + ": " + printer.get(i).getLanguage() + ", " + printer.get(i).getCost() + " - " + printer.get(i).getTimestampDate());
            }

        } else {
            System.out.println("No existeix un algorisme amb un timestamp entre " + numMin + " i " + numMax);
        }

    }

    private void trobat(long numMin, long numMax, Node source) {    // preorder

        if(source.getTimestamp() >= numMin) {
            if(source.getLeft() != null) {
                trobat(numMin, numMax, source.getLeft());
            }
        }

        if(source.getTimestamp() >= numMin && source.getTimestamp() <= numMax) {
            printer.add(source);
        }

        if(source.getTimestamp() <= numMax){
            if(source.getRight() != null) {
                trobat(numMin, numMax, source.getRight());
            }
        }

    }

}
