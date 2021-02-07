package algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fan.li
 * @date 2021-01-08
 * @description
 *
 * 面试题 08.12. 八皇后
 * https://leetcode-cn.com/problems/eight-queens-lcci/
 *
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 *
 * 讲解： https://time.geekbang.org/column/article/74287
 *
 *
 * 输入：4
 *  输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 *  解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/eight-queens-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class BaHuangHou {

    public static void main(String[] args) {

    }

    /**
     * 回溯：
     * 1. 先放第一个棋子
     * 2. 再放下一个棋子
     * 3. 判断这个棋子十字线和对角线没有其他的棋子(ps: 是不是只需要判断当前棋子和上一个棋子是否符合条件就行了？)
     * 4. 有的话换一个，没有的话继续
     *
     * ps：
     * 两个难点，一个是回溯终止条件，使用递归来实现，一个是递归的数据处理
     */
    static class Solution {

        public List<List<String>> solveNQueens(int n) {
            // n * n 棋盘
            int[][] a = new int[n][n];

            // 存储最终结果
            List<String> finalResult = new ArrayList<String>();

            // 放置第一行
            put(a, 0);
            return null;
        }

        /**
         * 获取第n行放置有几个可能的结果
         * @param a 已经放好的棋子
         * @param n
         * @return
         */
        private void put(int[][] a, int n) {
            if (n == a.length) {
                return null;
            }
            List<String> result = new ArrayList<String>();

            // 列
            for (int j = 0; j < a.length; j++) {
                // 判断这个位置符不符合要求
                if (isTrue(a, n, j)) {
                    a[n][j] = 1;

                    // 转化字符串


                    // 获得一种结果
                    result.add("");
                    // 符合的话就开始放下一个行
                    put(a, n + 1);
                }
                // 尝试下一列放置
            }

            return result;
        }


        /**
         * 数据转字符串
         * @param a
         * @return
         */
        private List<List<String>> toStringArray(int[][] a) {
            List<List<String>> result = new ArrayList<List<String>>();

            for (int i = 0; i < a.length; i++) {
                List<String> row = new ArrayList<String>();
                for (int j = 0; j < a[i].length; j++) {

                    if (a[i][j] == 0) {
                        row.add("-");
                    } else {
                        row.add("*");
                    }
                }
                result.add(row);
            }
            return result;
        }


        /**
         * 判断放置于row行cul列的棋子是否符合条件
         * @return
         */
        private boolean isTrue(int [][] a, int row, int cul) {

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    int tmp = a[i][j];
                    // 为1时是棋子
                    if (tmp == 1) {
                        // 如果棋子在对角线上，必满足 两个棋子行距与列距相等，反之亦然
                        if (Math.abs(row - i) == Math.abs(cul - i)) {
                            return false;
                        }
                        // 同行
                        if (i == row) {
                            return false;
                        }
                        // 同列
                        if (j == cul) {
                            return false;
                        }

                    }
                }
            }
            return true;
        }
    }
}

