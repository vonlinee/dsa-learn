package question.leetcode.problem;

import utils.Utils;

/**
 * 长度最小的子数组
 * https://leetcode.cn/problems/minimum-size-subarray-sum/submissions/
 * @author vonline
 * @since 2022-07-13 2:59
 */
public class P209_MiniumSizeSubArray {

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * <p>
     * 本题目考察滑动窗口算法
     * <p>
     * 情况：
     * 执行用时： 1442 ms , 在所有 Java 提交中击败了5.04%的用户
     * 内存消耗：48.7 MB, 在所有 Java 提交中击败了11.53%的用户
     * 通过测试用例： 20 / 20
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int min = 0;
        int sum = 0;
        while (left < nums.length) {
            // 单个值满足条件直接返回1，这就是最小的
            if (nums[left] >= target) return 1;
            // 下面满足：nums[i] < target
            // 找到和 >= target 的最小区间[left, right - 1]
            right = left;
            while (right < nums.length && sum < target) {
                sum += nums[right];
                right++;
            }
            // 可能到达末尾，没有找到和 >= target的区间
            if (sum < target) {
                return min;
            }
            System.out.println("满足 sum >= target 的区间: [" + left + ", " + (right - 1) + "]" + ", 子数组 => " + Utils.string(nums, left, right - 1));
            // 记录区间长度
            min = min == 0 ? right - left : Math.min(right - left, min);
            sum = 0;
            // 窗口右移一格
            left = left + 1;
        }
        return min;
    }

    public static void main(String[] args) {
        P209_MiniumSizeSubArray test = new P209_MiniumSizeSubArray();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int i = test.minSubArrayLen(7, nums);
        System.out.println(i);
    }
}
