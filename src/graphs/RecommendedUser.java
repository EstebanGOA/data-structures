package graphs;

/**
 * Clase donde guardaremos los datos relacionados con la recomendación para cada usuario así como información relevante.
 */
public class RecommendedUser {

    /**
     * Nodo en el que nos encontramos.
     */
    private final User user;
    /**
     * Usuario por el que es seguido este nodo.
     */
    private final User predecessor;
    /**
     * Si el usuario sigue al usuario que busca una recomendación.
     */
    private boolean follower;
    /**
     * Si el usuario es seguido por algún usuario que sigue el usuario que busca una recomendación.
     */
    private boolean nearby;
    /**
     * Número de intereses que coinciden con el usuario que está buscando una recomendación.
     * Su valor por defecto será 0.
     */
    private int interests;

    /**
     * Constructor de RecommendedUser.
     * @param user User Usuario en el que nos encontramos.
     * @param predecessor User Usuario por el que es seguido user.
     */
    public RecommendedUser(User user, User predecessor) {
        this.user = user;
        this.predecessor = predecessor;
        this.follower = false;
        this.nearby = false;
        this.interests = 0;
    }

    /**
     * Método que imprimirá por pantalla la información del usuario.
     */
    public void show() {
        System.out.println("\t" + user.getId() + " - " + user.getName() + " (" + user.getAlias() + ")");
        System.out.print("\tInteressos: ");
        String[] values = user.getInterests();
        if (values.length == 1) {
            System.out.println(values[0]);
        } else {
            for (int i = 0; i < values.length - 1; i++) {
                System.out.print(values[i]);
                if (i != values.length - 2) {
                    System.out.print(", ");
                }
            }
            System.out.println(" i " + values[values.length - 1]);
        }
        System.out.print("\tMotius: ");

        if (nearby) {
            System.out.print("Seguit per " + predecessor.getId() + " - " + predecessor.getName() + " (" + predecessor.getAlias() + ")");
        }

        if (interests > 0 && !nearby) {
            System.out.print("Compartiu " + interests + " interessos");
        } else if (interests > 0) {
            System.out.print(", Compartiu " + interests + "interessos");
        }

        if (follower) {
            if (nearby || interests > 0) {
                System.out.print(" i et segueix");
            } else {
                System.out.print("Et segueix");
            }
        }

        System.out.println("\n");
    }

    /**
     * Método que indicará que el usuario es seguido.
     * @param follower Boolean Que indica si el usuario es seguido.
     */
    public void setFollower(boolean follower) {
        this.follower = follower;
    }

    /**
     * Método que indicará que el usuario es cercano.
     * @param nearby Boolean Que indica si el usuario es cercano.
     */
    public void setNearby(boolean nearby) {
        this.nearby = nearby;
    }

    /**
     * Método que indicará cuantos intereses tienen en común.
     * @param interests Integer Con la cantidad de intereses que tienen en común.
     */
    public void setInterests(int interests) {
        this.interests = interests;
    }
}
