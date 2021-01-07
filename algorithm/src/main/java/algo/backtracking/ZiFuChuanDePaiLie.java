package algo.backtracking;

/**
 * @author fan.li
 * @date 2021-01-07
 * @description
 *
 * 剑指 Offer 38. 字符串的排列
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */


import java.util.HashSet;
import java.util.Set;

/**
 * 0. 数组大小为
 * 1. 是否有重复字符 -> 影响到数组大小
 * 本质是什么？n个字符的排列
 * 方法1：穷举
 * 方法2：回溯
 *
 *
 */
public class ZiFuChuanDePaiLie {

    public static void main(String[] args) {

    }

    static class Solution {

        Set<String> result = new HashSet<String>();

        public String[] permutation(String s) {
            // 得到字符集
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {

            }

            return null;
        }
    }
}



