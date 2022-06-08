package n1exercici2;

import java.util.*;

public class N1exercici2 {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> integerList1 = new ArrayList<>();
        integerList.add(89);

        System.out.println("\n\n\033[45m Primer llista \033[0m\n" + integerList);
        for (ListIterator<Integer>
             llistaAux = integerList.listIterator(integerList.size())
                         ; llistaAux.hasPrevious(); ) {
            // Use llistaAux.previous() to get the last record
            integerList1.add(llistaAux.previous());
        }
        System.out.println("\n\n\033[45m Segona llista \033[0m\n" + integerList1);
        System.out.println("\n\nGonzalo San Miguel Alonso®");
    }
}
