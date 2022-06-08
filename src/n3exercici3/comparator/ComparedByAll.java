package n3exercici3.comparator;
import n3exercici3.Persona;
import java.util.Comparator;

public class ComparedByAll implements Comparator<Persona> {

    // Comparing by surname [A-Z], name[A-Z] and id [1-9]
    @Override
    public int compare(Persona o1 , Persona o2) {

        if (o1.getSurname().compareToIgnoreCase(o2.getSurname()) == 0) {

            if (o1.getName().compareToIgnoreCase(o2.getName()) == 0) {

                return o2.getId().compareTo(o1.getId());

            } else {

                return o1.getName().compareToIgnoreCase(o2.getName());
            }

        } else {

            return o1.getSurname().compareToIgnoreCase(o2.getSurname());
        }

    }
}