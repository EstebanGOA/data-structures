import entities.Algorithm;
import entities.Menu;
import entities.User;

public class Main {
    public static void main(String[] args) {

        //Menu menu = new Menu();
        //menu.run();

        /*
        // Usuarios de prueba
        User u1 = new User(1, "Pablo", "Pablito", new String[] { "Deportes", "Series" });
        User u2 = new User(2, "Marc", "Marc", new String[] { "Parchís", "Series" });
        User u3 = new User(3, "Juan", "Juanito", new String[] { "Deportes", "Películas" });

        // Usuarios a los que sigue el usuario 1.
        Follow f1 = new Follow(2, 20, 435);
        Follow f2 = new Follow(3, 2432, 543);

        // Lista donde añadimos los usuarios seguidos.
        MyFollowerList followerList = new MyFollowerList();
        followerList.add(f1);
        followerList.add(f2);

        // Actualizamos la lista de seguidos del usuario 1.
        u1.setFollows(followerList);

        // TODO: Con la lista implementada la función para usar un bucle foreach no funciona, por el momento lo tendremos que hacer así.
        for (int i = 0; i < u1.getFollowsList().size(); i++) {
            System.out.println(u1.getFollowsList().get(i).getIdUser());
        }
        */

         entities.UserReader userReader = new entities.UserReader();
        User[] users = userReader.readFile("data/graphXS.paed");

        Algorithm algorithm = new Algorithm();


        int i = algorithm.binSearch(users, 2, 0, users.length);
        System.out.println(i);



    }
}
