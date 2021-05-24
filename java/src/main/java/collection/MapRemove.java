package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author fan.li
 * @date 2021-05-24
 * @description
 */

public class MapRemove {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>(1000000);
        map.put("a", 0);
        map.put("b", 1);
        map.put("c", 2);
        map.put("d", 3);
        long start = System.currentTimeMillis();
        clear0(map, 2);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        print(map);
    }

    private static void clear0(HashMap<String, Integer> map, int value) {
        for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext();){
            Map.Entry<String, Integer> item = it.next();
            if (item.getValue() < value) {
                it.remove();
            }
        }
    }

    private static void print(HashMap<String, Integer> map) {
        for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext();){
            Map.Entry<String, Integer> item = it.next();
            System.out.println("key: " + item.getKey() + " value: " + item.getValue());
        }
    }

}

