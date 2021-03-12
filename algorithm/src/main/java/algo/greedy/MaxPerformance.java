package algo.greedy;

import java.util.Arrays;

/**
 * @author fan.li
 * @web https://www.lifan.org.cn
 * @date 2021-02-28
 * @description
 */

public class MaxPerformance {
    public static void main(String[] args) {
        int[] speed = new int[]{2,10,3,1,5,8};
        int[] efficiency = new int[]{5,4,3,9,7,2};

        System.out.println(new Solution().maxPerformance(speed.length, speed, efficiency, 2));
    }

    static class Solution {
        public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
            // 速度和无法枚举，但是效率是可以枚举的
            int maxPerformance = 0;
            for (int i = 0; i < n ; i++) {
                int efficiency_ = efficiency[i];
                // 找到效率比它高的人，求出最大速度和，最多k人
                // 记录满足条件的人的速度
                int[] speed0 = new int[n];
                for (int j = 0; j < n; j++) {
                    if (efficiency[j] >= efficiency_) {
                        speed0[j] = speed[j];
                    }
                }
                int maxPerformance_ = getMaxSpeedSum(speed0, k, efficiency_);
                if (maxPerformance < maxPerformance_) {
                    maxPerformance = maxPerformance_;
                }
            }
            return maxPerformance;
        }

        private int getMaxSpeedSum(int[] speed0, int k, int e) {
            Arrays.sort(speed0);
            int sum = 0;
            for (int i = speed0.length; i > speed0.length - k; i--) {
                sum += speed0[i - 1];
            }
            return (sum * e) % 1000000007;
        }
    }
}

