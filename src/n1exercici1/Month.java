package n1exercici1;

import java.util.Objects;

public class Month {

    private String nameOfMonth;

    public Month(String nameOfMonth) {
        this.nameOfMonth = nameOfMonth;
    }

    public String getNameOfMonth() {
        return nameOfMonth;
    }

    @Override
    public String toString() {
        return "[" + "\033[0;34m" + nameOfMonth + "\033[0m" + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Month)) return false;
        Month month = (Month) o;
        return Objects.equals(getNameOfMonth(), month.getNameOfMonth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfMonth());
    }
}
