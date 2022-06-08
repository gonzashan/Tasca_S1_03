package n3exercici3;

import n3exercici3.exceptions.ExceptionInputStringValid;

import java.util.*;

public class Library {

    public static final int TABS = 3;
    public static List<Persona> listaPersonas = new ArrayList<Persona>();
    public static Scanner scanner = new Scanner(System.in);

    public static Map<String, String> hash_color_map =
               Map.of("RESET", "\u001B[0m",
                      "YELLOW","\033[0;33m"
                    , "GREEN", "\033[0;32m"
                    , "RED",   "\033[0;31m"
                    , "PURPLE","\033[0;35m"
                    , "CYAN",  "\033[0;36m"
                    , "BLUE",  "\033[0;34m"
                    , "BLACK", "\033[0;30m"
                    , "WHITE", "\u001B[37m");



    /*+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*
                                                            |S|c|r|e|e|n|  |P|r|i|t|n|  |M|e|t|h|o|d|s|
   -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+*/

    public static void menuScrenn() {
        System.out.println("\n\n\n");
        paintWithTabs("█████╗  ███╗   ██╗██╗®    ¡ARA NO ET QUEDARÀS ", 1, 1, "WHITE");
        paintWithTabs("██╔══██╗████╗  ██║██║          SENSE CARNET DE CONDUIR!", 1, 1, "WHITE");
        paintWithTabs("██║  ██║██╔██╗ ██║██║", 1, 1, "WHITE");
        paintWithTabs("██║  ██║██║╚██╗██║██║", 1, 1, "WHITE");
        paintWithTabs("██████╔╝██║ ╚████║██║", 1, 1, "WHITE");
        paintWithTabs("╚═════╝ ╚═╝  ╚═══╝╚═╝    \033[4;32mPegasus Sotfware®\033[0m", 1, 1, "WHITE");
        paintWithTabs(" ", 1, 1, "WHITE");
        paintWithTabs("[ 1 ]  Introduir persona", 1, 1, "reset");
        paintWithTabs("[ 2 ]  Mostrar per nom (A-Z)", 1, 1, "reset");
        paintWithTabs("[ 3 ]  Mostrar per nom (Z-A)", 1, 1, "reset");
        paintWithTabs("[ 4 ]  Mostrar per cognoms (A-Z)", 1, 1, "reset");
        paintWithTabs("[ 5 ]  Mostrar per cognoms (Z-A)", 1, 1, "reset");
        paintWithTabs("[ 6 ]  Mostrar per DNI (1-9)", 1, 1, "reset");
        paintWithTabs("[ 7 ]  Mostrar per DNI (9-1)\033[0;37m", 1, 1, "reset");
        paintWithTabs("[ 8 ]  Mostrar per cognoms (A-Z), nom (A-Z), DNI (1-9)", 1, 1, "reset");
        paintWithTabs("[ 9 ]  Mostrar per cognoms (A-Z), nom (A-Z), DNI (9-1)\033[0m", 1, 1, "reset");
        paintWithTabs("[ 0 ]  Salir\n", 1, 1, "reset");

        paintWithTabs("▒▒▒▒▒▒▒▒ Tría opció: ", 1, 2, "reset");

    }

    public static void paintWithTabs(String str, int variable, int returnLine, String colorText) {

        System.out.print(tabs() + hash_color_map.get(colorText.toUpperCase()) + String.format(
                (variable == 1 ? "%s" : "%d") + (returnLine == 1 ? "\n" : "")
                , str) + "\033[0m");
    }
    public static String tabs() {
        return "\t".repeat(TABS);
    }
    public static String fillString(String str, int size) {
        // homemade method for justified text at right side
        char[] acumulate = str.toCharArray();
        int longName = acumulate.length;
        StringBuilder out = new StringBuilder();


        for (int i = 0; i < size; i++) {

            if (i < longName) out.append(acumulate[i]);
            else out.append(' ');
        }

        return out.toString();
    }

    public static void printHeadSection(String s) {
        System.out.println("\n" + hash_color_map.get("YELLOW")
                + printSymbol('─', 66)
                + hash_color_map.get("RESET"));
        System.out.printf(hash_color_map.get("WHITE") + "%s\n",s + hash_color_map.get("RESET"));

       System.out.println(hash_color_map.get("YELLOW")
               + printSymbol('─', 66)
               + hash_color_map.get("RESET"));
    }
    public static String printSymbol(char e, int nTimes) {
        return String.valueOf(e).repeat(nTimes);
    }
    /*+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*
                                                                  |A|u|x|i|l|i|a|r|      |M|e|t|h|o|d|s|
    -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+*/

    public static String getValidString(String mesasge) {

        String validName;

        while (true) {
            try {

                System.out.print(mesasge);

                validName = scanner.nextLine();

                // Avoid blanks
                if (validName.isEmpty()) {
                    throw new RuntimeException(tabs() + "¡Has d'introduir un nom!");

                } else if (!validName.matches(".*[0-9].*")) {

                    return validName;

                } else {

                    throw new ExceptionInputStringValid(tabs() + "Avis. ¡El nom tè números!");
                }

            } catch (Exception e) {

                System.out.println(tabs() + "\u001B[31m" + e.getMessage() + "\u001B[0m");
            }

        }
       // demana a l’usuari el nom de la persona i el retorna si és correcte.
        //Si conté números, llença una l’excepció personalitzada ExcepcióNomPersonaIncorrecte.
    }

    public static void pressEnterToContinue() {
        System.out.print("\t\nPrem Enter per continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void sampleLoaded(Set<String> listaDniPersonas) {

        Persona persona = new Persona("Manolo", "Pérez", "9876543f");
        Persona persona1 = new Persona("Anna", "Puig", "9785461T");
        Persona persona2 = new Persona("Gemma", "Blau Blasco", "3489517K");
        Persona persona3 = new Persona("Gemma", "Blau Blasco", "2587416F");
        Persona persona4 = new Persona("Jordi", "Blau Gomez", "1452368B");
        Persona persona5 = new Persona("Áina", "Abengoa", "7419635C");
        Persona persona6 = new Persona("José", "Zoido", "7419635C");


        listaPersonas.add(persona);
        listaPersonas.add(persona1);
        listaPersonas.add(persona2);
        listaPersonas.add(persona3);
        listaPersonas.add(persona4);
        listaPersonas.add(persona5);
        listaPersonas.add(persona6);
        // Add to HashMap
        listaDniPersonas.add(persona.getId());
        listaDniPersonas.add(persona1.getId());
        listaDniPersonas.add(persona2.getId());
        listaDniPersonas.add(persona3.getId());
        listaDniPersonas.add(persona4.getId());
        listaDniPersonas.add(persona5.getId());
        listaDniPersonas.add(persona6.getId());


    }

}
