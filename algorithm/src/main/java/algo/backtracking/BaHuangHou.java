package algo.backtracking;

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
     * 3. 判断这个棋子十字线和对角线没有其他的棋子
     */
    static class Solution {
        public List<List<String>> solveNQueens(int n) {
            // n * n 棋盘
            int[][] a = new int[n][n];

            return null;
        }
    }
}

