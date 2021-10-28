package algo.dp.backpack;

import java.util.Arrays;

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
 *
 * 优化点1：同时对于相同重量的背包，可以取价值最大的那一个，其他的舍弃掉
 * 优化点2：无需记录重量大于V的组合
 * 优化点3：无需记录具体的物品组合，只需要记录处理过的商品序列
 *
 * 物品组合 + 重量限制 -> 价值
 *
 * 综上所述，变量只有2个，处理过的商品序列 + 重量 -> 价值
 *
 */

public class O1BackPack {



    public static void main(String[] args) {
        int[] costs = {2,2,4,6,3};
        int[] weights = {2,2,4,6,3};
        Solution solution = new Solution();
        System.out.println(solution.maxValue0(costs, weights, 9));

    }

    public static class Solution {

        /**
         *
         * 参考
         * @see O1BackPackSimple
         *
         * @param costs 物品要花费的重量 要求必须大于0
         * @param weights 物品价值 要求必须大于0
         * @param V 背包最大容量
         * @return 最大价值
         */
        public int maxValue(int[] costs, int[] weights, int V) {

            // 如果用状态来表示背包的话有三个变量 【前i个物品，当前重量，当前价值】

            // dp[i]代表重量为V的背包所能存储的最大价值，该数组表示的是某一阶段的状态，
            int[] dp = new int[V + 1];
            // dp = 0 表示该重量限制不可达
            dp[0] = 0;
            // 逐步放入商品
            for(int i = 0; i < costs.length; i++) {
                // 处理这一阶段所能达到的重量枚举，并计算在该重量下的最大价值
                for(int j = V; j >= 0; j--) {
                    // 判断这个重量是否可达
                    if (dp[j] == 0) {
                        // 如果 这个重量不可达并且尝试的当前物品可以放进去（没有超限），那么就可以直接将物品放进去
                        if (j - costs[i] == 0) {
                            dp[j] = weights[i];
                        }
                        if (j - costs[i] > 0 && dp[j - costs[i]] > 0) {
                            // 可达的话去计算下价值
                            dp[j] = dp[j - costs[i]] + weights[i];
                        }
                    } else {
                        // 如果当前重量已经有了，也可以比一比谁大
                        if (j - costs[i] >= 0 && dp[j - costs[i]] > 0) {
                            // 可达的话去计算下价值
                            dp[j] = Math.max(dp[j - costs[i]] + weights[i], dp[j]);
                        }
                    }
                }
            }
            return Arrays.stream(dp).max().getAsInt();
        }


        /**
         *
         * 优化遍历次数
         *
         * @param costs 物品要花费的重量 要求必须大于0
         * @param weights 物品价值 要求必须大于0
         * @param V 背包最大容量
         * @return 最大价值
         */
        public int maxValue0(int[] costs, int[] weights, int V) {

            // 如果用状态来表示背包的话有三个变量 【前i个物品，当前重量，当前价值】

            // dp[i]代表重量为V的背包所能存储的最大价值，该数组表示的是某一阶段的状态，
            int[] dp = new int[V + 1];
            // dp = 0 表示该重量限制不可达
            dp[0] = 0;
            // 逐步放入商品
            for(int i = 0; i < costs.length; i++) {
                // 处理这一阶段所能达到的重量枚举，并计算在该重量下的最大价值，cost[i]之前的重量状态不用去枚举 1. 放不进去 2.不放的话值不用变
                for(int j = V; j >= costs[i]; j--) {
                    // 如果不可达，那么取 dp[j - costs[i]] + weights[i], 如果可达，那么取 Math.max(dp[j], dp[j - costs[i]] + weights[i])
                    dp[j] = Math.max(dp[j], dp[j - costs[i]] + weights[i]);

                }
            }
            return Arrays.stream(dp).max().getAsInt();
        }

    }
}

