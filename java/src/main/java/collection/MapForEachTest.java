package collection;

import java.util.*;

/**
 * @author fan.li
 * @date 2021-05-24
 * @description
 */

public class MapForEachTest {

    public static void main(String[] args) {
        HashMap<String, Integer> map0 = new HashMap<String, Integer>(1000000);
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        initData(map0);
        initData(map1);


        testIterator(map0);
        testIterator(map1);
        testFor(map0);
        testFor(map1);

        testMapForeach(map0);
        testMapForeach(map1);
        testMapStreamForeach(map0);
        testMapStreamForeach(map1);

        testMapParallelStreamForeach(map0);
        testMapParallelStreamForeach(map1);


    }



    private static void testIterator(HashMap map) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            forEach(map);
        }
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("HashMap Size: " + map.size() +  " 迭代器 耗时: " + (end - start) + " ms");
    }

    private static void testFor(HashMap map) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            forEach0(map);
        }
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("HashMap Size: " + map.size() +  " 增强型For 耗时: " + (end - start) + " ms");
    }

    private static void testMapForeach(HashMap map) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            forEach1(map);
        }
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("HashMap Size: " + map.size() +  " MapForeach 耗时: " + (end - start) + " ms");
    }


    private static void testMapStreamForeach(HashMap map) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            forEach2(map);
        }
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("HashMap Size: " + map.size() +  " MapStreamForeach 耗时: " + (end - start) + " ms");
    }

    private static void testMapParallelStreamForeach(HashMap map) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            forEach2(map);
        }
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("HashMap Size: " + map.size() +  " MapParallelStreamForeach 耗时: " + (end - start) + " ms");
    }

    private static void forEach(HashMap map) {
        for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext();){
            Map.Entry<String, Integer> item = it.next();
            System.out.print(item.getKey());
            // do something
        }
    }


    private static void forEach0(HashMap<String, Integer> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.print(entry.getKey());
        }
    }

    private static void forEach1(HashMap<String, Integer> map) {
        map.forEach((key, value) -> {
            System.out.print(key);
        });

    }

    private static void forEach2(HashMap<String, Integer> map) {
        map.entrySet().stream().forEach(e -> {
            System.out.print(e.getKey());
        });

    }

    private static void forEach3(HashMap<String, Integer> map) {
        map.entrySet().parallelStream().forEach(e -> {
            System.out.print(e.getKey());
        });

    }

    private static void initData(HashMap map) {
        map.put("a", 0);
        map.put("b", 1);
        map.put("c", 2);
        map.put("d", 3);
        map.put("e", 4);
        map.put("f", 5);
    }

}

