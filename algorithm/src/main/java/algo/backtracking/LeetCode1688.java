package algo.backtracking;

/**
 * @author fan.li
 * @date 2021-01-07
 * @description
 * 1688. 比赛中的配对次数
 * https://leetcode-cn.com/problems/count-of-matches-in-tournament/
 *
 * 给你一个整数 n ，表示比赛中的队伍数。比赛遵循一种独特的赛制：
 *
 * 如果当前队伍数是 偶数 ，那么每支队伍都会与另一支队伍配对。总共进行 n / 2 场比赛，且产生 n / 2 支队伍进入下一轮。
 * 如果当前队伍数为 奇数 ，那么将会随机轮空并晋级一支队伍，其余的队伍配对。总共进行 (n - 1) / 2 场比赛，且产生 (n - 1) / 2 + 1 支队伍进入下一轮。
 * 返回在比赛中进行的配对次数，直到决出获胜队伍为止。
 *
 */
public class LeetCode1688 {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfMatches(14));
    }

    /**
     * 透过现象看本质：
     * 共有n个队伍，一个冠军，需要淘汰n-1个 队伍。
     * 每一场比赛淘汰一个队伍，因此进行了n-1场比赛。
     */
    static class Solution0 {
        public int numberOfMatches(int n) {
            return n - 1;
        }
    }

    /**
     * 递归
     */
    static class Solution {
        public int numberOfMatches(int n) {
            if (n == 1) {
                return 0;
            }
            if (n == 2) {
                return 1;
            }
            int result = 0;
            if (n % 2 != 0) {
                // 如果当前队伍数为 奇数 ，那么将会随机轮空并晋级一支队伍
                n = n - 1;
                // 配对次数
                result = n / 2;
                // 剩下配对队伍数
                n = n/2 + 1;
            } else {
                // 配对次数
                result = n / 2;
                // 剩下配对队伍数
                n = n / 2;
            }
            return result + numberOfMatches(n);
        }
    }
}

