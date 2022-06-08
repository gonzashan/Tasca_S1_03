package n2exercici1;


import java.util.HashSet;
import java.util.Scanner;

public class N2exercici1 {

public static void main(String[] args) {

        HashSet<Restaurant> hashMapRest = new HashSet<Restaurant>();
        Scanner scanner = new Scanner(System.in);

        int optionChoose = 1;
        int points;
        String nameRestaurant;

        //Some samples
        samplesRestaurant(hashMapRest);
        while (optionChoose != 0) {

            System.out.println("\n\n\t[1] - Añadir restaurante");
            System.out.println("\t[2] - Mostrar todos los restaurantes");
            System.out.println("\t[0] - Salir");
            System.out.print("\n\tSelecciona opción:  ");
            optionChoose = scanner.nextInt();

            switch (optionChoose) {
                case 1:
                    scanner.nextLine();
                    System.out.print("\n\tNombre restaurante: ");
                    nameRestaurant = scanner.nextLine();
                    System.out.print("\tSu puntuación: ");
                    points = scanner.nextInt();
                    setRestaurantIntoHasSet( points, nameRestaurant,hashMapRest );
                    break;
                case 2:
                    showingRestaurants(hashMapRest);
                    break;
                default:
                    System.out.println("tIntroducir opción válida");
            }
        }
        scanner.close();
    }

public static void setRestaurantIntoHasSet(int points, String nameRestaurant, HashSet<Restaurant> listadoRestaurantes ){
        // @Override methods Equals and Hashcode in Restaurant.java to let adding
        // equals restaurant's name but not with equals points duplicated
        listadoRestaurantes.add(new Restaurant(points, nameRestaurant));
    }

public static void showingRestaurants(HashSet<Restaurant> hashMapRest) {
        System.out.println("\nRestaurantes guardados: " + hashMapRest.size());
        System.out.println( "\n\033[4;37m    Nombre          Puntuación \033[0m\n");
        for (Restaurant s : hashMapRest) {
            System.out.println(s);
        }
    }

public static void samplesRestaurant(HashSet<Restaurant> hashMapRest){

        Restaurant restaurant1 = new Restaurant(2, "El Bulli");// Repe
        Restaurant restaurant2 = new Restaurant(2, "El Bulli");// Repe
        Restaurant restaurant3 = new Restaurant(5, "El Bulli");
        Restaurant restaurant4 = new Restaurant(8, "El Bulli");
        Restaurant restaurant5 = new Restaurant(4, "Can Roca");
        Restaurant restaurant6 = new Restaurant(8, "Can Roca");
        Restaurant restaurant7 = new Restaurant(8, "Sant Pau"); // Repe


        hashMapRest.add(restaurant1);
        hashMapRest.add(restaurant2);
        hashMapRest.add(restaurant3);
        hashMapRest.add(restaurant4);
        hashMapRest.add(restaurant5);
        hashMapRest.add(restaurant6);
        hashMapRest.add(restaurant7);
}


    /*
     * for HashMap Version
     *  */
// RestaurantHashMap<Restaurant> hashMapRest = new RestaurantHashMap<>();

//         hashMapRest.put(restaurant,"Kino");
//             hashMapRest.put(restaurant1, "Kino");// repe
//             hashMapRest.put(restaurant2, "Kino");// repe
//             hashMapRest.put(restaurant3, "Kino");
//             hashMapRest.put(restaurant4, "Kino");
//             hashMapRest.put(restaurant5, "Pepa");
//             hashMapRest.put(restaurant6, "Pepa");//repe
//             hashMapRest.put(restaurant7, "Pepa");//repe

}