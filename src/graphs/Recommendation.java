package graphs;

import entities.Algorithm;
import entities.Follow;
import entities.RecommendedUser;
import entities.User;
import utilities.ArrayList;
import java.util.Objects;

/**
 * Esta clase se encargará de buscar una recomendación para un usuario dado. Según los criterios que hemos definido iremos asignando
 * una puntuación para los usuarios, cuanto mayor sea su puntuación antes será recomendado.
 *
 * Los criterios para las recomendaciones són las siguientes:
 *  - Cuentas seguidas por usuarios que son seguidos por el usuario dado. (1 punto)
 *  - Cuentas que siguen al usuario dado. (1 punto)
 *  - Cuentas que tengan intereses en común con el usuario dado. (0.1 por interés compartido)
 *
 * Cuentas ya seguidos por el usuario dado no serán recomendadas.
 */
public class Recommendation {

    /**
     * Clase auxiliar que nos ofrecerá distintas funciones para facilitarnos las búsquedas.
     */
    private final Algorithm a;
    private User source;

    /**
     * Constructor de la clase Recommendation
     */
    public Recommendation() {
        this.a = new Algorithm();
    }

    /**
     * Esta función recorrerá nuestro grafo haciendo uso de una función DFS para asignar las puntuaciones a los usuarios.
     *
     * @param users Grafo donde se encuentran todos los usuarios.
     * @param id Identificador del usuario que está buscando recomendaciones.
     */
    public void run(User[] users, int id) {

        this.source = a.binarySearch(users, id, 0, users.length-1);

        System.out.println("Potser t'interessa seguir els següents comptes: \n");

        dfs(users, null, source, 0);

        // Sabemos que el grafo es desconectado, por tanto, utilizamos este bucle para pasar por los usuarios que no son
        // seguidos por los recorridos anteriormente.
        for (User node : users) {
            if (!node.isVisited()) {
                // La variable depth la utilizamos para asignar una puntuación a los usuarios seguidos por el usuario principal, ya que nos interesa
                // asignarles una puntuación extra. Como este no es el caso, empezaremos en profundidad 3 para evitar sumar una puntuación por error.
                dfs(users, null, node, 3);
            }
        }

    }

    /**
     * Algoritmo Depth First Search (DFS) para recorrer el grafo y asignar las puntaciones a cada uno de los usuarios.
     *
     * @param users Grafo guardado en una lista.
     * @param user Nodo actual.
     * @param depth Variable que nos marcará a que profundidad nos encontramos del nodo inicial.
     */
    private void dfs(User[] users, User predecessor, User user, int depth) {

        user.setVisited(true);
        RecommendedUser data = new RecommendedUser(user, predecessor);
        ArrayList<User> adjacents = getFollowed(users, user);

        // Siempre que nos encontremos en un nodo/usuario seguido por los usuarios/nodos que son seguidos por el usuario/nodo 'source' esteremos
        // a una profundidad igual a 2, sabiendo esto incrementaremos la puntuación en estos casos.
        if (depth == 2) {
            user.increment(false);
            data.setNearby(true);
        }

        // Por cada interés compartido del nodo/usuario actual con el usuario/nodo 'source' incrementaremos la puntuación
        // del nodo actual en 0.1 puntos.
        if (!user.equals(source) && user.getInterests() != null && source.getInterests() != null) {
            int i = 0;
            for (String interest : user.getInterests()) {
                for (String value : source.getInterests()) {
                    if (Objects.equals(interest, value)) {
                        user.increment(true);
                        i++;
                    }
                }
            }
            data.setInterests(i);
        }

        for (int i = 0; i < adjacents.size(); i++) {
            User adj = adjacents.get(i);
            // Si el usuario sigue al usuario dado incrementamos su puntuación.
            if (adj.equals(source)) {
                user.increment(false);
                data.setFollower(true);
            }
            if (!adj.isVisited()) {
                dfs(users, user, adj, depth + 1);
            }
        }

        if (user.getPoints() > 0.0) {
            data.show();
        }

    }

    /**
     * Recogemos todos los usuarios que són seguidos por un usuario dado.
     *
     * @param users Lista con todos los usuarios del grafo.
     * @param user Usuario al cual buscaremos sus adyacentes/seguidos.
     * @return Lista con todos los usuarios seguidos por el usuario pasado por parámetro.
     */
    private ArrayList<User> getFollowed(User[] users, User user) {

        ArrayList<User> adjacents = new ArrayList<>();
        ArrayList<Follow> followed = user.getFollowed();

        for (int i = 0; i < followed.size(); i++) {
            int objective = followed.get(i).getIdUser();
            User u = a.binarySearch(users, objective, 0, users.length-1);
            adjacents.add(u);
        }
        return adjacents;

    }

}
