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
        int[] costs = {2,2,4,6,3};
        Solution solution = new Solution();
        System.out.println(solution.maxWeight0(costs, 9));

        Solution0  solution0 = new Solution0();
        solution0.f(0, 0);
        System.out.println(solution0.maxW);
    }


    /**
     * 来自极客
     */
    public static class Solution0 {

        // 回溯算法实现。注意：我把输入的变量都定义成了成员变量。
        public int maxW = Integer.MIN_VALUE; // 结果放到maxW中
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
            //maxWeight00(costs, V, 0, 0);
            status = new boolean[V][costs.length];
            maxWeight000(costs, V, 0, 0);
            System.out.println("count" + count);
            return maxWeight0;
        }

        /**
         * 这个递归的有意思之处是目标值不是根节点，而是叶子节点，并且是求子节点的最大值，
         * 并且子节点的值一定大于等于父节点 -> 所有求子节点最大值就可以只判断叶子节点的值
         * @param costs 物品列表
         * @param V 背包容量
         * @param costIndex 准备加入的物品序号
         * @param v 当前背包重量（还没加入物品）
         * @return 这个树要求有返回值吗？其实不要求，因为父节点不依赖子节点，他不是分治，这里仅仅起到排列组合，递推的一个过程数，每个节点对应一个排列组合的状态
         */
        private int maxWeight0 = 0; // 记录最大的叶子节点值
        private void maxWeight00(final int[] costs, final int V, int costIndex, int v) {
            count++;
            // 递归结束条件: 1. 所有物品都处理完了 2. 重量已经达标（最大了）
            if (costIndex == costs.length || v == V) {
                maxWeight0 = Math.max(maxWeight0, v);
                return;
            }

            // 注意，这里一定不能只选择一个，因为你选择不一定是最优解！，你要做的是放或者不放，严格来说，都不用去判断重量限制
            // 不加，重量不变
            maxWeight00(costs, V, costIndex + 1, v);
            if (v + costs[costIndex] <= V) { // 这里用来剪枝，减少后面的计算次数，因为重量是递增的，所以如果加入这个物品导致超过限制了，那么就没必要加了
                // 加
                maxWeight00(costs, V, costIndex + 1, v + costs[costIndex]);
            }

        }


        /**
         * 同上，如何继续优化，记忆化搜索，先观察方法入参，发现只有 costIndex 和 v 两个变量，那么这两个变量会有被重复执行的可能吗
         * 在整个迭代树里，costIndex 是树的层次，取值范围是 [0, size]，v 是重量，由于经过剪枝，所以取值范围是 [0, v]，两者合计 size * V 的时间复杂度
         * 递归树的时间复杂度是 2^size次方，所以肯定会出现重复计算，所以可以将这两个值存起来，一般是用map，但是因为取值范围可控，所以可以用二维数组，那么值是什么呢？
         * 检查代码，发现需要计算的操作就是 v + costs[costIndex] <= V, 即在重量为v且处理i个商品的情况下是否可以加入背包，可以用一个布尔值来表示
         *
         * 看上去好像没有优化什么东西，递归树的层次能减少吗？不能，节点能少吗？不能，优化的只是判断次数而已
         *
         * 进一步思考，能不能减少递归数的节点数量，当遇到一个相同节点的子树时，还有没有必要往下走？没有
         * 什么时候会出现相同的节点？首先相同必须保证 i 相同，即在同一层，那么同一层是可能出现重量相同额背包吗，当然可能，两个重量相同的物品交替放就可以，这样就优化了递归数，
         * 而不是其中某个计算的流程
         * @param costs
         * @param V
         * @param costIndex
         * @param v
         */
        private boolean[][] status;
        public int count;
        private void maxWeight000(final int[] costs, final int V, int costIndex, int v) {
            // true的话说明已经走过该子树了，就和标记一样
            // 递归结束条件: 1. 所有物品都处理完了 2. 重量已经达标（最大了）
            if (costIndex == costs.length || v == V) {
                maxWeight0 = Math.max(maxWeight0, v);
                return;
            }

            if (status[v][costIndex] == true) {
                return;
            } else {
                status[v][costIndex] = true;
            }
            count++;

            // 注意，这里一定不能只选择一个，因为你选择不一定是最优解！，你要做的是放或者不放，严格来说，都不用去判断重量限制
            // 不加，重量不变
            maxWeight000(costs, V, costIndex + 1, v);
            if (v + costs[costIndex] <= V) { // 这里用来剪枝，减少后面的计算次数，因为重量是递增的，所以如果加入这个物品导致超过限制了，那么就没必要加了
                // 加
                maxWeight000(costs, V, costIndex + 1, v + costs[costIndex]);
            }

        }
    }
}

