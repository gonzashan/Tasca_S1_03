package n3exercici3.comparator;

import n3exercici3.Persona;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class FirstNameSorter implements Comparator<Persona> {


    @Override
    public int compare(Persona o1, Persona o2) {
        //Collator to get è é à á ì í ò ó ù ú, and sort it
        Collator spCollator = Collator.getInstance(new Locale("es")); //Your locale here
        spCollator.setStrength(Collator.PRIMARY);
        return spCollator.compare(o1.getName(), o2.getName());

    }

    @Override
    public Comparator<Persona> reversed() {
        return Comparator.super.reversed();
    }
}
