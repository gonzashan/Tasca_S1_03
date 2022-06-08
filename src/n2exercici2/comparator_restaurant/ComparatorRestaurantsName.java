package n2exercici2.comparator_restaurant;

import n2exercici2.Restaurant;
import java.util.Comparator;

public class ComparatorRestaurantsName implements Comparator<Restaurant> {
    @Override
    public int compare(Restaurant rest1, Restaurant rest2) {
        return rest1.getName().compareTo(rest2.getName());
    }

}
