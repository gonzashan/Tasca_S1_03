package n1exercici3;

import java.util.Map;
import java.util.Scanner;

public class N1exercici3 {

    public static void main(String[] args) {

        ServiceReadFile concurso = new ServiceReadFile();
        Scanner scanner = new Scanner(System.in);
        String quizTableResults;
        boolean tricky;

        try {
            concurso.readFile();
            ServiceContestant contestant = new ServiceContestant();
            System.out.println("\n\n\n");
            String nameContestant = contestant.getNameContestant();
            int trickyRespond;
            String opc;
            do {
                System.out.print(contestant.tabulate() + nameContestant
                        + ", ¿HACEMOS TRAMPAS? \n" + contestant.tabulate() + "  [ Si ]       [ No ]  ");

                opc = scanner.nextLine();

            } while (opc.isEmpty() || !opc.equalsIgnoreCase("s") && !opc.equalsIgnoreCase("n"));

            if (opc.equals("n")) {
                // Qué mentirosillo eres!
                contestant.setTrickyFalse();
            }
            tricky = contestant.getTrickyState();

            ///************************************************************
            concurso.starting();
            //************************************************************

            int pointValue;
            quizTableResults = headTableQuizResults();
            System.out.println();
            // Quiz starts
            for (Map.Entry<String, String> it : concurso.getSolutionContest().entrySet()) {

                System.out.print(contestant.tabulate() + nameContestant
                        + ", capital de " + it.getKey()
                        + (tricky ? "\u001B[30m" + " " + it.getValue() + "\u001B[0m" : "")
                        + " es: ");

                if (it.getValue().equalsIgnoreCase(scanner.nextLine())) {
                    System.out.print("\u001B[32mBien! :)\u001B[0m\n");
                    contestant.setScoreContestant();
                    pointValue = 1;
                } else {
                    System.out.print("\u001B[31mError :( \u001B[0m"
                            + "\u001B[33mes " + it.getValue() + "\u001B[0m\n");
                    pointValue = 0;
                }

                quizTableResults = bodyTableQuizResults(quizTableResults, pointValue, it);
            }// end for

            System.out.println("\n" + nameContestant + " tu puntuación ha sido de " + contestant.getScoreContestant());
            concurso.createFile(nameContestant, contestant.getScoreContestant(), quizTableResults);


        } catch (Exception e) {

            System.out.println("Error message  from N1exercici3.java: " + e.getMessage());
            System.out.println("Error message2 from N1exercici3.java: " + e.getCause().getMessage());
        }

    }

    private static String bodyTableQuizResults(String quizTableResults, int pointValue, Map.Entry<String, String> it) {
        quizTableResults = quizTableResults.concat(
                String.format("%35s %15s %10d\n"
                        , fillString(it.getKey(), 31)
                        , fillString(it.getValue(), 25)
                        , pointValue));
        quizTableResults = quizTableResults.concat(printSymbol('─', 75) + "\n");
        return quizTableResults;
    }

    public static String printSymbol(char e, int nTimes) {
        return String.valueOf(e).repeat(nTimes);
    }

    public static String headTableQuizResults() {

        String quizTableResults;
        quizTableResults = "Tabla de resultados\n\n";
        quizTableResults = quizTableResults.concat(printSymbol('─', 75) + "\n");
        quizTableResults = quizTableResults.concat(
                String.format("%10s %35s %25s\n", "País", "Capital", "  Puntos"));
        quizTableResults = quizTableResults.concat(printSymbol('─', 75) + "\n");

        return quizTableResults;
    }

    public static String fillString(String str, int size) {

        // homemade method for justified text
        char[] a = str.toCharArray();
        int longName = a.length;
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < size; i++) {

            if (i < longName) out.append(a[i]);
            else out.append(' ');
        }

        return out.toString();
    }

}
