package n3exercici3;

import n3exercici3.comparator.CompareId;
import n3exercici3.comparator.ComparedByAll;
import n3exercici3.comparator.FirstNameSorter;
import n3exercici3.comparator.FirstSurnameSorter;

import java.text.Collator;
import java.util.*;


public class N3exercici3 {

    private static Set<String> listaDNIPersonas = new HashSet<>();

    private static String whatSorted;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int optionChoose = 1;
        String name, surname, id;

        // Getting samples for the app
        Library.sampleLoaded(listaDNIPersonas);

        while (optionChoose != 0) {

            Library.menuScrenn();
            optionChoose = sc.nextInt();

            switch (optionChoose) {
                case 1:
                    sc.nextLine();
                    Library.printHeadSection("Donan d'alta nova persona".toUpperCase());
                    do {
                        System.out.print("Introdueix Dni: ");
                        id = sc.nextLine();

                    } while (verificatedId(id, listaDNIPersonas) == -1 || id.isEmpty());


                    name = Library.getValidString("Introdueix Nom: ");
                    surname = Library.getValidString("Introdueix Cognom: ");

                    Library.listaPersonas.add(new Persona(name, surname, id));
                    break;
                case 2:
                    sortedByOption2_3(2, Library.listaPersonas);
                    break;
                case 3:
                    sortedByOption2_3(3, Library.listaPersonas);
                    break;
                case 4:
                    sortedByOption4_5(4, Library.listaPersonas);
                    break;
                case 5:
                    sortedByOption4_5(5, Library.listaPersonas);
                    break;
                case 6:
                    sortedByOption6_7(6, Library.listaPersonas);
                    break;
                case 7:
                    sortedByOption6_7(7, Library.listaPersonas);
                    break;
                case 8:
                    sortedByOption8_9(8, Library.listaPersonas);
                    break;
                case 9:
                    sortedByOption8_9(9, Library.listaPersonas);
                    break;
                default:
                    Library.paintWithTabs("Has d'introduir una opció vàlida", 1, 1, "WHITE");
            }// end switch

        }//end while


    }// end main

    public static void sortedByOption2_3(int actionToDo, List<Persona> personas){
        // actionToDo == 2 is sorting list by name and ascending
        // actionToDo == 3 is reversing the list from actionToDo == 2
        if (actionToDo == 2 || actionToDo == 3) {
            // Sorting by Lambada way avoiding erros with accents
            Collator spCollator = Collator.getInstance(new Locale("es")); //Your locale here
            spCollator.setStrength(Collator.PRIMARY);
            Comparator<Persona> firstNameSorter
                    = (o1, o2) -> spCollator.compare(o1.getName(), o2.getName());
            Comparator<Persona> reverseSorter = firstNameSorter.reversed();

            if (actionToDo == 2) {
                // Using interface
                personas.sort(new FirstNameSorter());
            } else {
                // I always have to split hairs {
                Library.listaPersonas.sort(reverseSorter);
            }

           whatSorted = "Personas ordenades per nom "
                    + (actionToDo == 2 ? "(A-Z)" : "(Z-A)");

        }
        printSortedValues(personas,whatSorted);
    }

    public static void sortedByOption4_5(int actionToDo, List<Persona> personas){
        // actionToDo == 4 is sorting list by surname and ascending
        // actionToDo == 5 is reversing the list from actionToDo == 4
        if (actionToDo == 4 || actionToDo == 5) {
            // Sorting by interface Comparator
            if (actionToDo == 4) {
                personas.sort(new FirstSurnameSorter());
            } else {
                personas.sort(new FirstSurnameSorter().reversed());
            }
            whatSorted = "Personas ordenades per cognoms "
                    + (actionToDo == 4 ? "(A-Z)" : "(Z-A)");

        }
        printSortedValues(personas,whatSorted);
    }

    public static void sortedByOption6_7(int actionToDo, List<Persona> personas){
        // actionToDo == 6 is sorting list by ID and ascending
        // actionToDo == 7 is reversing the list from actionToDo == 7
        if (actionToDo == 7 || actionToDo == 6) {
            // Sorting que tengo que me ha salido
            Collections.sort(personas, new Comparator<Persona>() {
                @Override
                public int compare(Persona arg0, Persona arg1) {
                    return actionToDo == 6 ? arg0.getId().compareTo(arg1.getId())
                            : arg1.getId().compareTo(arg0.getId());
                }
            });
            whatSorted = "Personas ordenades per DNI "
                    + (actionToDo == 6 ? "(1-9)" : "(9-1)");

        }
        printSortedValues(personas,whatSorted);
    }

    public static void sortedByOption8_9(int actionToDo, List<Persona> personas) {
        // actionToDo == 8 is sorting list by surname and name ascending and ID descending
        // actionToDo == 9 is reversing the list from actionToDo == 8
        if (actionToDo == 8 || actionToDo == 9) {

            if (actionToDo == 8) {
                Collections.sort(personas, new FirstSurnameSorter()
                        .thenComparing(new FirstNameSorter())
                        .thenComparing(new CompareId()));
            } else {
                personas.sort(new ComparedByAll());
            }
        }
        whatSorted =("Ordenades per cognoms[A-Z], nom[A-Z] i DNI"
                + (actionToDo == 8 ? "(1-9)" : "(9-1)"));

        printSortedValues(personas,whatSorted);
    }

    public static void printHeadResults() {

        System.out.print("\n" +
                Library.listaPersonas.size() + " registres" + Library.hash_color_map.get("RESET"));
    }

    private static void printSortedValues(List<Persona> personas,String str2) {
        //Let's print them
        printHeadResults();
        Library.printHeadSection(str2);
        System.out.printf("\033[4;33m" + "%s %20s %40s %s\n"
                + "\033[0m", "NOM", "COGNOM", "   DNI", '\u200B');
        for (Persona p : personas) {
            System.out.println(p.toString());
        }

        Library.pressEnterToContinue();
    }
    
    public static int verificatedId(String personalId, Set<String> listaDniPersonas) {

        if (listaDniPersonas.contains(personalId)) {

            System.out.println("No se puede introducir este DNI."
                    + Library.hash_color_map.get("YELLOW")
                    + " Este DNI ya está registrado." + Library.hash_color_map.get("RESET"));

            return -1;
        }

        if (!personalId.isEmpty()) {

            listaDniPersonas.add(personalId);
        } else {
            Library.paintWithTabs("¡Has d'introduir un DNI!", 1, 1, "RED");
        }
        return 1;
    }


}// end of file

