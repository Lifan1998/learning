package algo.dp.backpack;

/**
 * @author fan.li
 * @date 2021-10-25
 * @description
 *
 * 有N件物品和一个容量为V的背包。第i件物品的费用是c[i]。求解将哪些物品装入背包可使重量总和最大。
 *
 *
 *
 */
public class O1BackPackSimple {
    public static void main(String[] args) {

    }


    public static class Solution0 {

        // 回溯算法实现。注意：我把输入的变量都定义成了成员变量。
        private int maxW = Integer.MIN_VALUE; // 结果放到maxW中
        private int[] weight = {2,2,4,6,3};  // 物品重量
        private int n = 5; // 物品个数
        private int w = 9; // 背包承受的最大重量

        public void f(int i, int cw) { // 调用f(0, 0)
            if (cw == w || i == n) { // cw == w表示装满了，i==n表示物品都考察完了，递归树的叶子节点
                if (cw > maxW) {
                    maxW = cw;
                }
                return;
            }
            f(i+1, cw); // 选择不装第i个物品
            if (cw + weight[i] <= w) { // 剪枝
                f(i+1,cw + weight[i]); // 选择装第i个物品
            }
        }
    }

    public static class Solution {

        /**
         * 错误写法1：
         * 为什么不能这样，因为前面的状态是可能被后面的影响到的，不具有无后效性，动态规划记录的状态应该是终态
         * @param costs
         * @param V
         * @return
         */
        public int maxWeight(int[] costs, int V) {
            // 前i个物品的最大重量
            int[] dp = new int[costs.length];
            for(int i = 0; i < costs.length; i++) {
                if (dp[i-1] + costs[i] > V) {
                    // 放不下
                    dp[i] = dp[i-1];
                } else {
                    // 放的下当然要放
                    dp[i] = dp[i-1] + costs[i];
                }
            }
            return dp[costs.length - 1];
        }

        /**
         *
         * @param costs
         * @param V
         * @return
         */
        public int maxWeight1(int[] costs, int V) {
            // dp[i] 表示 当前重量为V的情况下是否可达（即是否存在能装到V的物品），如果可达的话那么肯定就可以了
            boolean[] dp = new boolean[costs.length];
            for(int i = 0; i < costs.length; i++) {
                // 尝试在重量为j的时候放入第i个物品
                for (int j = 0; j < V; j++) {
                    if (dp[j] == false) {
                        // 不可达
                    } else {

                    }
                }
            }

            return 0;
        }

        /**
         * 常规思路：
         * 1. 暴力解法（终态）：因为物品不要求有序，所以可以将 costs 排列组合拆分
         * 2. 回溯：一个一个物品往里面加，如果要加入的物品超过限制了，就不加这个，去加下一个，直到遍历所有物品（物品只有1个）或者重量达到上限；不断换起始商品去尝试
         * @param costs
         * @param V
         * @return
         */
        public int maxWeight0(int[] costs, int V) {
            int maxWeight = 0;
            // 假设有一个递归树，其叶子节点必然是 2的n次方(可以剪枝)，然后计算其叶子节点的值，因为叶子节点是最大的
            for (int i = 0; i < costs.length; i++) { // 处理第i个物品
                // 放

                // 不放
            }

            return 0;
        }
    }
}

