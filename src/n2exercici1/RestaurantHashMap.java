package n2exercici1;

import java.util.HashMap;

public class RestaurantHashMap<K> extends HashMap<K,String> {

    /**
     * Use usesKey en HashMap para determinar si la clave ya existe
     * @param key
     * @param value
     * @return
     */
    @Override
    public String put(K key, String value) {

        String newV = value;
        if (containsKey(key)) {

            String oldV = get(key);
            newV = oldV + "\n\t\t*---" + newV;
        } else {

        System.out.println(newV);
        }
        return super.put(key, newV);
    }

    }
//    public Restaurant put(K key, Object restaurant) {
//        int point = restaurant.
//        return super(key,)
//    }

//if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))