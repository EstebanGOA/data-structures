package entities;

public class UserRecomendado {
    private User u;
    private int numInteressos;
    private float numCheks;
    private String[] interesos;
    private boolean jaSeguit;           // si ho te a true, vol dir que no el mostrarem
    private boolean emSegueix;          // es posa a true si em segueix
    private boolean seguitPerSeguido;   // es posa a true si en el bfs es el nivell 3 (o sigui que es
                                        // seguit per un que jo segueixo, tinguent en compte que jo soc el nivell 1
    private int nivell;
    private boolean entrat;
    private boolean acabat;
    private boolean printar;

    public void setU(User u) {
        this.u = u;
    }

    public User getU() {
        return u;
    }


    public int getNumInteressos() {
        return numInteressos;
    }

    public void setNumInteressos(int numInteressos) {
        this.numInteressos = numInteressos;
    }

    public String[] getInteresos() {
        return interesos;
    }

    public void setInteresos(String[] interesos) {
        this.interesos = interesos;
    }

    public void addInteressos(String[] interesOld, String interesNew){
        int i;
        String[] interesActual = new String[interesOld.length+1];
        for(i=0;i<interesOld.length;i++){
            interesActual[i]=interesOld[i];
        }
        interesActual[i]=interesNew;
        this.interesos=interesActual;
    }

    public boolean isJaSeguit() {
        return jaSeguit;
    }

    public void setJaSeguit(boolean jaSeguit) {
        this.jaSeguit = jaSeguit;
    }

    public boolean isEmSegueix() {
        return emSegueix;
    }

    public void setEmSegueix(boolean emSegueix) {
        this.emSegueix = emSegueix;
    }

    public boolean isSeguitPerSeguido() {
        return seguitPerSeguido;
    }

    public void setSeguitPerSeguido(boolean seguitPerSeguido) {
        this.seguitPerSeguido = seguitPerSeguido;
    }

    public int getNivell() {
        return nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    public boolean isEntrat() {
        return entrat;
    }

    public void setEntrat(boolean entrat) {
        this.entrat = entrat;
    }

    public boolean isAcabat() {
        return acabat;
    }

    public void setAcabat(boolean acabat) {
        this.acabat = acabat;
    }

    public boolean isPrintar() {
        return printar;
    }

    public void setPrintar(boolean printar) {
        this.printar = printar;
    }

    public float getNumCheks() {
        return numCheks;
    }

    public void setNumCheks(float numCheks) {
        this.numCheks = numCheks;
    }
}
