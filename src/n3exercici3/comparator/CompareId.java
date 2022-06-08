package n3exercici3.comparator;

import n3exercici3.Persona;

import java.util.Comparator;

public  class CompareId implements Comparator<Persona> {
    @Override
    public int compare(Persona arg0, Persona arg1) {
        return arg0.getId().compareTo(arg1.getId());
    }


}
