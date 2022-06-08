package n1exercici1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public class N1exercici1 {

    private final String[] lisOfMonths = {"Gener", "Febrer", "March", "Abril", "May"
            , "June", "Juliol", "September", "Octubre", "Novembre", "December"};
    private static int i = 1;


    public static void main(String[] args) {

        ArrayList<Month> months  = new ArrayList<>();
//        ArrayList<String> actionToDo = new ArrayList<>();

        N1exercici1 inici = new N1exercici1();
        String actionText2 = "\n";
        String auxF = "%s";

        // Inserting values into the ArrayList 'months' by creating new Object Month
        // from String array listOfMonths declared as variable at the top.
        actionText2 = actionText2.concat("New  list: ");
        for (String month : inici.lisOfMonths
        ) {
            months.add(new Month(month));
            actionText2 = actionText2.concat(String.format("%s", "["
                    + "\033[0;34m" + months.get(i-1).getNameOfMonth()) + "\033[0m" + "]" );
            i++;
        }
        actionText2 = actionText2.concat("\n");


        // Adding 'Agost' into the array months in it position and check it.
        months.add(7, new Month("Agost"));
        i = 1;
        actionText2 = actionText2.concat("Add Agost: ");
        for (Month month : months
        ) {
            actionText2 = actionText2.concat(String.format(auxF, month));
            i++;
        }
        actionText2 = actionText2.concat("\n");

        // Convert ArrayList<Month> into HashSet and check no duplicates are forbidden.
        // We'll need @Override methods 'equals' and 'hashcode' focus on getNameOfMonth()
        HashSet<Month> monthHashSet = new HashSet<>(months);

        // I want to be sure to make Object dizzy and so on.
        actionText2 = actionText2.concat("\n\033[1;32mAdd Agost: monthHashSet.add(new Month(\"Agost\")); \033[0m");
        actionText2 = actionText2.concat("\033[1;93m" +
                monthHashSet.add(new Month("Agost"))
                + "\033[0m\n");
        monthHashSet.add(new Month("Agost"));
        monthHashSet.add(new Month("Agost"));


        // Testing and showing by console the result of the actionToDo add("value_repeated"). Again!!


        //Traversing elements with for
        i = 1;
        actionText2 = actionText2.concat("  forEach: ");
        for (Month month : monthHashSet) {
            actionText2 = actionText2.concat(String.format(auxF, month));
            i++;
        }
        actionText2 = actionText2.concat("\n");

        //Traversing elements with Iterator
        i = 1;
        actionText2 = actionText2.concat(" Iterator: ");
        Iterator<Month> itr = monthHashSet.iterator();
        while(itr.hasNext()
        ){
            actionText2 = actionText2.concat(String.format(auxF, itr.next()));
            i++;
        }
        actionText2 = actionText2.concat("\n");

        System.out.print(actionText2);
        System.out.println("\n\nGonzalo San Miguel Alonso®");




    } // end main
} // end class
