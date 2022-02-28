package entities;

import entities.User;

public class Recomanacio {
    /**
     * Siempre pondre User (s) como el user al que le estamos mirando la info
     * tanto si es que el user (u) ya le sigue, o si el user (t) es seguido por el
     * user (u) al que el (s) ya sigue...
     */


    private int interessos = 0;           // priorizacion de cuentas que comparten interes con el usuario

    /**
     * para esta funcion se pasara 1 user concreto (s) que es el que miramos si tiene
     * a (u) como seguidor
     * y se le pasara el array de users completo (u[])
     */

    public User[] rellenarBools(User[] u, User s) {
        int id1 = 0, i, j, k;


        // pone a true si el user ya lo sigue, asi luego con un isJaSegueix
        // nos lo podemos saltar
        for (i = 0; i < u.length; i++) {
            u[i].setJaSegueix(alreadySegueix(u[i], s));
        }

        //si el user (s) es seguido por el user (u), el user (u) tendra el
        // getSeguidor a true
        for (j = 0; j < u.length; j++) {
            for (i = 0; i < u[j].getFollowsList().size(); i++) {
                if (u[j].getFollowsList().get(i).getIdUser() == s.getId()) u[j].setPoints(u[j].getPoints()+1);
            }
        }

        // todos los users que siguen mis seguidores tendran un true
        // en isSeguidasPorSeguidor
        for (j = 0; j < s.getFollowsList().size(); j++) {
            id1 = s.getFollowsList().get(j).getIdUser();
            for (k = 0; k < u.length; k++) {
                if (u[k].getId() == id1) u[k].setPoints(u[k].getPoints()+1);
            }
        }

        for(j=0;j<u.length;j++){
            for(k=0;k<u[j].getInterests().length;k++){
                for(i=0;i<s.getInterests().length;i++){
                    if(u[j].getInterests()[k].equals(s.getInterests()[i])) u[k].setPoints((u[k].getPoints()+0.1));
                }
            }
        }
        k=0;
        for(i=0;i<u.length;i++){
            if(u[i].isJaSegueix()) k++;
        }

        User[] users = new User[k];
        j=0;
        for(i=0;i<u.length;i++){
            if(!u[i].isJaSegueix()) users[j]=u[i];   //TODO no estoy seguro si se puede hacer asi
        }

        return users;
    }

    public boolean alreadySegueix(User u, User s) {
        for (int i = 0; i < s.getFollowsList().size(); i++) {
            if (s.getFollowsList().get(i).getIdUser() == u.getId()) return true;
        }
        return false;
    }

}