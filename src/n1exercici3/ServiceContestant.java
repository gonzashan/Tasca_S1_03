package n1exercici3;

import n1exercici3.Exceptions.ExcepcioNomPersonaIncorrecte;
import resources.UtilsConsole;

import java.util.Scanner;

public class ServiceContestant {

    private String nameContestant;
    private int scoreContestant;
    private Scanner scanner = new Scanner(System.in);
    private boolean tricky;

    public ServiceContestant() {
        this.scoreContestant = 0;
        this.tricky = true;
    }

    public void setTrickyFalse() {
        this.tricky = false;
    }

    public boolean getTrickyState(){
        return this.tricky;
    }

    public void setScoreContestant() {
        this.scoreContestant++;
    }

    public int getScoreContestant() {
        return this.scoreContestant;
    }

    public String getNameContestant() {

        String validName;

        while (true) {
            try {

                UtilsConsole.typeWriter(tabulate() + "Nombre del concursante: ".toUpperCase());

                validName = scanner.nextLine();

                // Avoid blanks
                if (validName.isEmpty()) {
                    throw new RuntimeException(tabulate() + "¡Has de introducir un nombre!");

                } else if (!validName.matches(".*[0-9].*")) {
                    this.nameContestant = validName;
                    return validName;

                } else {

                    throw new ExcepcioNomPersonaIncorrecte(tabulate() + "Avis. ¡El nombre tiene números!");
                }

            } catch (Exception e) {

                System.out.println(tabulate() + "\u001B[31m" + e.getMessage() + "\u001B[0m");
            }

        }
        /*demana a l’usuari el nom de la persona i el retorna si és correcte.
        Si conté números, llença una l’excepció personalitzada ExcepcióNomPersonaIncorrecte.*/
    }


    public  String tabulate() {
        return "\t".repeat(4);
    }
}
