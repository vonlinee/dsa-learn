package question.leetcode.leetbook.easy.dp;

import java.util.StringJoiner;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn3cg3/
 */
public class LargestSubSum {

//    给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//    子数组 是数组中的一个连续部分。

    public int maxSubArray(int[] nums) {
        // dp[i]表示端点为i的最大和，因为要求是连续的
        int[] dp = new int[nums.length];
        // 边界条件
        dp[0] = nums[0];
        // 也可以找到dp中最大值即可，这里用一个变量来存
        int max = dp[0];
        int i = 1;
        while (i < nums.length) {
            // 状态转移公式
            if (dp[i - 1] > 0) {
                // 为正数继续累加
                dp[i] = dp[i - 1] + nums[i];
            } else {
                // 为负数或者0
                dp[i] = nums[i]; // 将前面累加的和丢弃，因为是负数，加上只可能更小
            }
            max = Math.max(max, dp[i]);
            i++;
        }
        return max;
    }

    // 如果要知道是哪个子区间呢？
    public void maxSubArray1(int[] nums) {
        // dp[i]表示端点为i的最大和，因为要求是连续的
        int[] dp = new int[nums.length];
        // 边界条件
        dp[0] = nums[0];
        // 也可以找到dp中最大值即可，这里用一个变量来存
        int max = dp[0];

        // 记录最大子数组的区间端点
        int left = 0, right = 0; // 实际上right可能有多个

        int i = 1;
        while (i < nums.length) {
            // 状态转移公式
            if (dp[i - 1] > 0) {
                // 为正数继续累加
                dp[i] = dp[i - 1] + nums[i];
                right++;
            } else {
                // 为负数或者0
                dp[i] = nums[i]; // 将前面累加的和丢弃，因为是负数，加上只可能更小
                left = i;
                right = i;
            }
            // 右端点位置
            if (max > dp[i]) {
                right = i; // 让right重新开始计数
            }
            // 可能存在多个子数组同时满足最大值的情况

            max = Math.max(max, dp[i]);
            i++;
        }

        StringJoiner sb = new StringJoiner(", ", "[", "]");
        for (int j = left; j <= right; j++) {
            sb.add(nums[j] + "");
        }
        System.out.println("区间范围 = [" + left + ", " + (right - 1) + "] 对应的数组为: " + sb);
        System.out.println("最大值 = " + max);
    }

    // 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        LargestSubSum solution = new LargestSubSum();

        solution.maxSubArray1(nums);

    }

}
