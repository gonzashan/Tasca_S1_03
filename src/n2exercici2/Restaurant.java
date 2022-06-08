package n2exercici2;

import java.util.Objects;

public class Restaurant implements Comparable<Restaurant>{

    private int points;
    /**
     * ¿Quién es el apellido de la niña?
     */
    private String name;

    public Restaurant(int points, String name){
        super();
        this.points = points;
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  String.format("%10s %15d", this.getName(),this.getPoints());
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Restaurant that = (Restaurant) o;
        return Objects.equals(points, that.points) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, name);
    }


    @Override
    public int compareTo(Restaurant name) {
        return this.getName().compareTo(name.getName());
    }
}
