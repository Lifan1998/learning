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
        testArrayClone();
        testArrayClone0();
    }


    /**
     *
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





}

