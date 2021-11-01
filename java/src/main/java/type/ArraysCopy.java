package type;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author fan.li
 * @web https://www.lifan.org.cn
 * @date 2021-03-09
 * @description
 */

public class ArraysCopy {

    public static void main(String[] args) {
//        testArrayClone();
//        testArrayClone0();
//        testArrayClone1();
        //testArrayClone2();

        int[] arr = new int[]{1,2,3,4};
        testUpdateValue(arr);
        System.out.println(arr[0]);

    }

    /***
     * 更新数组的值，会影响原数组
     * @param arr
     * @return
     */
    public static int[] testUpdateValue(int[] arr) {
        int[] arr_ = arr.clone();
        arr_[0] = 999;
        return arr;
    }


    /**
     * int数组
     * 深拷贝
     */
    public static void testArrayClone() {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(arr));
        int[] arr_ = arr.clone();
        System.out.println(Arrays.toString(arr_));
        // 修改arr[0]的值
        arr[0] = 99;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr_));
        arr[0] = 1;
        // 修改arr_[0]的值
        arr_[0] = 99;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr_));

    }

    /**
     * 二维数组
     * 第二维浅拷贝
     */
    public static void testArrayClone0() {
        int[][] arr = new int[2][2];
        System.out.println(Arrays.deepToString(arr));
        int[][] arr_ = arr.clone();
        System.out.println(Arrays.deepToString(arr_));
        // 修改arr[0]的值
        arr[0][0] = 99;
        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(arr_));
        arr[0][0] = 0;
        // 修改arr_[0]的值
        arr_[0][0] = 99;
        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(arr_));
    }

    /**
     * String 数组
     * 深拷贝
     */
    public static void testArrayClone1() {
        String[] arr = new String[]{"1","2","3","4"};
        System.out.println(Arrays.toString(arr));
        String[] arr_ = arr.clone();
        System.out.println(Arrays.toString(arr_));
        // 修改arr[0]的值
        arr[0] = "99";
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr_));
        arr[0] = "1";
        // 修改arr_[0]的值
        arr_[0] = "99";
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr_));

    }



    /**
     * Object 数组
     * 浅拷贝
     */
    public static void testArrayClone2() {

        Node[] arr = new Node[]{new Node(1), new Node(2),new Node(3), new Node(4)};
        System.out.println(Arrays.toString(arr));
        Node[] arr_ = arr.clone();
        System.out.println(Arrays.toString(arr_));
        // 修改arr[0]的值
        arr[0].id = 99;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr_));
        arr[0].id = 1;
        // 修改arr_[0]的值
        arr_[0].id = 99;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr_));

    }


    static class Node {
        Integer id;

        public Node(Integer id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return id + "";
        }
    }


}

