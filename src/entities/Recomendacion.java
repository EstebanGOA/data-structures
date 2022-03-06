package entities;

public class Recomendacion {

    public User[] rellenarBools(User u[], int id){
        boolean found=false;
        UserRecomendado[] user = new UserRecomendado[u.length];
        int i, printats=0;
        float numMax, numAct;
        boolean finish = false;

        System.out.println("Potser t'interesa seguir als seguents comptes:\n");
        System.out.println(u.length);

        System.out.println("");
        for (i=0;i< u.length;i++){
            System.out.println(u[i].getId());
        }

        for(i=0;i<u.length;i++){
            user[i].setU(u[i]);
            user[i].setEmSegueix(false);
            user[i].setJaSeguit(false);
            user[i].setEmSegueix(false);
            user[i].setSeguitPerSeguido(false);
            user[i].setNumInteressos(0);
            user[i].setNivell(50);
            user[i].setEntrat(false);
            user[i].setAcabat(false);
            user[i].setPrintar(true);
            user[i].setNumCheks(0);
        }

        for(i=0;i<u.length && !found; i++){
            if(id == u[i].getId()){
                found=true;
            }
        }
        i--;

        //dfs(user,u[i], 0, i);
        /**
         * u[i] es el meu user actual
         */
        /**
         * cal editar aquest, no es printats, es un altre TODO
         */
        for(i=0;i<u.length;i++){
            if(user[i].isPrintar()) printats++;
        }

        numAct=100;
        numMax=0;
        while(!finish){
            for(i=0;i<printats;i++){
                while(!user[i].isPrintar())i++;
                if(user[i].getNumCheks()>numMax && user[i].getNumCheks()<numAct){
                    numMax=user[i].getNumCheks();
                }
            }
            printer(u[i]);
            numAct=user[i].getNumCheks();
            numMax=0;
        }




        return u;
    }


    /**
     *
     * @param u         arrays user
     * @param s         user mio
     * @param lvl       en que numero de seguidor "recursivado" se encuentra
     * @param temp      contador del user actual, no por el id, sino por la posicion en el array
     * @return          lvl
     */

    private int dfs(UserRecomendado[] u, User s, int lvl, int temp){
        u[temp].setEntrat(true);
        if(u[temp].getU().getId()==s.getId()){
            u[temp].setJaSeguit(true);
            u[temp].setPrintar(false);
        }
        if(s.getFollows().contains(u[temp])) {
            u[temp].setJaSeguit(true);
            u[temp].setPrintar(false);
        }
        if(u[temp].getNivell()<lvl)u[temp].setNivell(lvl);

        if(!u[temp].isJaSeguit() && !u[temp].isAcabat()){//(1)
            u[temp].setAcabat(true);

            /**
             * Amplio els interessos comuns (4)
             */
            for(int i=0;i<s.getInterests().length;i++){
                for(int j=0;j<u[temp].getU().getInterests().length;j++){
                    if(u[temp].getU().getInterests()[j] == s.getInterests()[i] ){
                        u[temp].setNumCheks((float) (u[temp].getNumCheks()+0.1));
                        u[temp].setNumInteressos(u[temp].getNumInteressos()+1);//marco contador de interessos
                        u[temp].addInteressos(u[temp].getInteresos(), u[temp].getU().getInterests()[j]);
                    }
                }
            }
            /**
             * miro si es seguit per un que segueixo jo (2)
             */
            for(int i=0;i<s.getFollows().size();i++){
                for(int j=0;j<u[temp].getU().getFollowed().size();j++) {
                    if (u[temp].getU().getFollowed().get(j) == s.getFollows().get(i)) {
                        u[temp].setNivell(2);
                        u[temp].setSeguitPerSeguido(true);
                        u[temp].setNumCheks(u[temp].getNumCheks()+1); // per els print de despres, per l'ordre
                    }
                }
            }

            /**
             * si em segueix (3)
             */
            if(s.getFollowed().contains(u[temp].getU().getId())) {
                u[temp].setEmSegueix(true);
                u[temp].setNumCheks(u[temp].getNumCheks()+1);
            }
        }

        if(u[temp].getU().getFollowed().size()==0 || u[temp].isEntrat()){
            //hacer los cosos
            u[temp].setAcabat(true);
            lvl--;
        }
        else{
            lvl++;
            dfs(u, s, lvl, temp);
        }

        return lvl;
    }








    private void ids(User[] u){
        for (int i=0;i<u.length;i++){
            System.out.println(u[i].getId());
        }
    }


    private void printer(User u){
        System.out.println("\t"+u.getId()+" - "+ u.getName()+" ("+u.getAlias()+")");
        System.out.println("\tInteressos: ");
        System.out.println("\tMotius: Compartiu "+"\n");
    }

}
