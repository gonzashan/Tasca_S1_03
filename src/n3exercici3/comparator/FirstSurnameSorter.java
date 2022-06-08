package n3exercici3.comparator;

import n3exercici3.Persona;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class FirstSurnameSorter implements Comparator<Persona> {
    Collator myCollator = Collator.getInstance(Locale.getDefault());


    @Override
    public int compare(Persona o1, Persona o2) {
        Collator spCollator = Collator.getInstance(new Locale("es")); //Your locale here
        spCollator.setStrength(Collator.PRIMARY);
        return spCollator.compare(o1.getSurname(), o2.getSurname());
    }

    @Override
    public Comparator<Persona> reversed() {
        return Comparator.super.reversed();
    }
}
