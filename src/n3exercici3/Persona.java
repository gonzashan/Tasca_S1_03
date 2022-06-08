package n3exercici3;

public class Persona implements Comparable<Persona>  {

    private String name,surname;
    private String id;

    public Persona(String name, String surname, String id) {
        super();
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s %15s %s"
                , Library.fillString(this.name,18)
                , Library.fillString(this.surname,38)
                , Library.fillString(this.id,10));
    }


    @Override
    public int compareTo(Persona o) {
        return 0;
    }
}

