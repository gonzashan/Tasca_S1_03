package n1exercici3;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceReadFile {

    private HashMap<String, String> countriesAndCapitals;
    private final int OPPORTUNITIES = 10;
    private final Set<Integer> RAND_Num_LIST; //Store 10 random numbers from countries list size.
    private String[] arrSelectedCountriesForQuiz;
    private Map<String, String> solution;

    // Constructor
    public ServiceReadFile() {

        this.countriesAndCapitals = new HashMap<>();
        this.RAND_Num_LIST = new LinkedHashSet<>();
        this.arrSelectedCountriesForQuiz = new String[OPPORTUNITIES];
        this.solution = new LinkedHashMap<>();
    }

    public void starting() {

        this.getRandomIndexForCountries();
        this.getResolvedQuiz();
    }


    public Map<String, String> getSolutionContest() {
        return this.solution;
    }

    public HashMap<String, String> getCountriesAndCapitals() {
        return this.countriesAndCapitals;
    }

    public void getRandomIndexForCountries() {
        // Create an HasMap with non-repeating values from Random action.
        // it'll use to get countries' name
        Random randNum = new Random();

        while (RAND_Num_LIST.size() < OPPORTUNITIES) {

            this.RAND_Num_LIST.add(randNum.nextInt(this.countriesAndCapitals.size() - 1) + 1);
        }
    }

    public void getResolvedQuiz() {
        // Creating a Map with countries' name to ask with their capitals as solution ALL-IN-ONE.
        String key, value;
        for (int i = 0; i < arrSelectedCountriesForQuiz.length; i++) {

            this.arrSelectedCountriesForQuiz[i] =
                    (String) this.getCountriesAndCapitals()
                            .keySet()
                            .toArray()[(int) this.RAND_Num_LIST.toArray()[i]];
            key = (String) this.getCountriesAndCapitals().keySet()
                    .toArray()[(int) this.RAND_Num_LIST.toArray()[i]];
            value = this.getCountriesAndCapitals().get(key);

            this.solution.put(key, value);
        }
    }

    public void setPaisesCapital(String pais, String capital) {
        this.countriesAndCapitals.put(pais, capital);
    }

    public void readFile() throws Exception {

        try {
            String readLine;

            // To read file content line-by-line.
            String file = "src/n1exercici3/paises.txt";

            Scanner scanner = new Scanner(new File(file));
            scanner.useDelimiter("\n");

            String pattern = "\\b([^\\d.]+[^\\t]+):\\s+([^\\t]+)\\b";

            do {
                readLine = scanner.next();
                Pattern r = Pattern.compile(pattern);
                Matcher m = r.matcher(readLine);

                while (m.find()) {
                    //System.out.println("Found a key/value: (" + m.group(1) + ", " + m.group(2) + ")");
                    this.setPaisesCapital(m.group(1), m.group(2));
                }

            } while (scanner.hasNext());
            progressBar();

        } catch (IOException e) {
            System.out.println("Att. El método falla por : "
                    + e.getMessage());
            throw new EndivinarException(" Ups! falla por: " + e);

        } finally {

            System.out.println("\n\u001B[32m" + this.getCountriesAndCapitals().size()
                    + " paises cargados con éxito!" + "\u001B[0m");
        }
    }

    public void createFile(String nameContestant, int points, String quizResults) throws Exception {

        String encoding = "UTF-8";
        try {
            File fileName = new File("src/n1exercici3/clasificacio.txt");
            DateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
            Date quizDate = dFormat.parse(dFormat.format(new Date()));

            //fileName.createNewFile();
            PrintWriter writer = new PrintWriter(fileName, encoding);
            writer.println("\n Fecha concurso: " + quizDate);
            writer.println("\n Nombre: " + nameContestant + "\n\n Puntuación: " + points + "\n");
            writer.println(" " + quizResults);
            writer.println("Gonzalo San Miguel Alonso ®");
            writer.close();

            //Línea genera una excepción
            System.out.println("Fichero creado con éxito ");


        } catch (IOException e) {
            System.out.println("Att. El método falla por : "
                    + e.getMessage());
            throw new EndivinarException(" esto falla por: " + e);

        } finally {

            System.out.println("Chapando recursos!");
        }
    }

    public void progressBar() {
        System.out.println("\nCargando lista de paises...");
        System.out.print("\t\t" + ' ');
        for (int i = 0; i < 35; i++) {
            timeDelay(51 - (i));
            System.out.printf("%c", '▀');
        }
    }

    public static void timeDelay(int sleep) {
        // Sleeping a while
        try {
            Thread.sleep(sleep);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
