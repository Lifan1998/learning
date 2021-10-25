package algo.dp.backpack;

/**
 * @author fan.li
 * @date 2021-10-25
 * @description
 *
 * 有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]。求解将哪些物品装入背包可使价值总和最大。
 *
 * 每种物品仅有一件，可以选择放或不放。
 *
 * f[i][v]=max{f[i-1][v],f[i-1][v-c[i]]+w[i]}
 *
 * 用暴力解的话，就是对物品排列组合，然后去掉重量大于V的，计算他们的价值
 * 同时对于相同重量的背包，可以取价值最大的那一个，其他的舍弃掉
 *
 * 物品组合 + 重量限制 -> 价值
 *
 */

public class O1BackPack {



    public static void main(String[] args) {

    }



    public static class Solution0 {

        /**
         *
         * @param costs 物品要花费的重量
         * @param weights 物品价值
         * @param V 背包最大容量
         * @return 最大价值
         */
        public int maxValue(int[] costs, int[] weights, int V) {

            // 如果用状态来表示背包的话有三个变量 【前i个物品，当前重量，当前价值】

            // dp[i]代表前i个物品的最大价值
            int[] dp = new int[costs.length];
            // dp[i]代表前i个物品的最小重量
            int[] dp0 = new int[costs.length];
            // 逐步放入商品
            for(int i = 0; i < costs.length; i++) {
                // 选择放还是不放
                dp[i] = Math.max(
                        // 选择不放
                        dp[i-1],
                        // 选择放，放的话要计算下重量符不符合规则，即有没有重量小于背包V，重量存哪呢
                        dp[i-1] + weights[i]);
            }

            return 0;
        }
    }

    public static class Solution {

        /**
         *
         * @param costs 物品要花费的重量
         * @param weights 物品价值
         * @param V 背包最大容量
         * @return 最大价值
         */
        public int maxValue(int[] costs, int[] weights, int V) {

            // 如果用状态来表示背包的话有三个变量 【前i个物品，当前重量，当前价值】

            // dp[i][j]代表前i个物品的最大价值，且当前重量是dp[j],dp[j]是用来核对是否符合条件的
            int[][] dp = new int[costs.length][V];
            // 逐步放入商品
            for(int i = 0; i < costs.length; i++) {
                // 【不同重量下（其实这里就是限制条件，完整版可以是序列）】的最大价值
                // 不存储重量大于V的情况
                for(int j = 0; j < V; i++) {

                }
            }

            return 0;
        }
    }
}

