
import java.util.HashMap;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class Arrays {


    public static void uniqueness(String[] arrays) {

        Map<String, Integer> map = new HashMap<>();
        for (String array : arrays) {
            map.put(array, map.getOrDefault(array, 0) + 1);
        }

        System.out.println("Уникальное слово = сколько раз встречается каждое слово");
        System.out.println(map);
        System.out.println("");


    }
}
