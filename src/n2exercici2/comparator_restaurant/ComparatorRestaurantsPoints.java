package n2exercici2.comparator_restaurant;

import n2exercici2.Restaurant;

import java.util.Comparator;

public class ComparatorRestaurantsPoints implements Comparator<Restaurant> {
    @Override
    public int compare(Restaurant rest1, Restaurant rest2) {

        if(rest1.getPoints() == rest2.getPoints()){
            return 0;

        } else if( rest1.getPoints() > rest2.getPoints()){
            // '<' or '>' to ascending or descending. Or 1 or -1
            return -1;
        }else{
            return 1;
        }
    }
}
