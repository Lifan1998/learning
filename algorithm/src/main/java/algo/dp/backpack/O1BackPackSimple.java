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

    public static class Solution {

        public int maxWeight(int[] costs, int V) {
            // 前i个物品的最大重量
            int[] dp = new int[costs.length];
            for(int i = 0; i < costs.length; i++) {
                dp[i] = Math.max(
                        // 选择不放第i个商品
                        dp[i-1],
                        // 选择放第i个商品
                        dp[i-1] + costs[i]);
            }
            return dp[costs.length - 1];
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


            return 0;
        }
    }
}

