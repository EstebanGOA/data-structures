package entities;

import utilities.MyQueue;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class FuncionalitatsCerca {
        private ArrayList<Node> printer;
    /**
     * Ire comparando mi numero con un timestamp de un nodo, si es mayor,
     * coge el nodo derecho y lo pongo em el nodo que miro, sino coge el izquierdo.
     * Si por algun caso me da exception, eso es que no hay menor/mayor, significa que no existe
     * @param num   numero exacto que tengo que buscar
     * @param source nodo inicial, de donde cuelgan todos los otros
     */
    public void cercaExacta(long num, Node source){
        int found =0;   // 0 es q encara no l'ha trobat, 1 es que si l'ha trobat, 2 es que no hi es
        Node n;
        n=source;
        while(found ==0){
            if(num == n.getTimestamp()){
                found=1;
                System.out.println("\nS'ha trobat un algorisme... " + n.getName() + ": " + n.getId() + ", " + n.getCost());
            }
            else{
                if(num > n.getTimestamp()){
                    try{
                        n = n.getRight();
                    }catch (Exception e){
                        found=2;
                    }
                }
                else{
                    try{
                        n = n.getLeft();
                    }catch ( Exception e){
                        found=2;
                    }
                }
            }
        }
        if(found==2){
            System.out.println("No existeix un algorisme amb un timestamp de " + num);
        }
    }

    public void cercaRang(long numMin, long numMax, Node source){
        Date date;
        trobat(numMin, numMax, source);

        if(printer.size()>0){
            System.out.println("S'han trobat " + printer.size() + " algorismes en aquest rang...\n");
            for(int i=0;i<printer.size();i++){
            //    date = getTimestamp(printer.get(i).getTimestamp());
                System.out.println("\t" + printer.get(i).getName() + ": " + printer.get(i).getLanguage() + ", " + printer.get(i).getCost() + " - " + printer.get(i).getTimestampDate());
            }
        }else{
            System.out.println("No existeix un algorisme amb un timestamp entre " + numMin + " i " + numMax);
        }

    }

    private void trobat(long numMin, long numMax, Node source){
        if(source == null){
            return;
        }
        if(source.getTimestamp()>numMin){
            source = source.getLeft();
            trobat(numMin, numMax, source);
        }
        if(source.getTimestamp() >= numMin && source.getTimestamp() <= numMax){
            printer.add(source);
        }
        if(source.getTimestamp() < numMax){
            source = source.getRight();
            trobat(numMin, numMax, source);
        }
    }

    private Date getTimestamp(long num){
        Date time = new Date(num*1000); // x1000 pq nuestro timestamp esta en segundos
        return time;
    }
}
