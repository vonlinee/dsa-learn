package question.leetcode.problem;

import utils.Utils;

/**
 * <p>
 * 最长连续递增序列
 * <p>
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
 * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P674 {

    public int findLengthOfLCIS(int[] nums) {
        int l = 0, r = 0;
        int maxLen = 0;
        while (l < nums.length) {
            r = l;
            // 区间[l, r-1]上是递增的
            while (r < nums.length - 1) {
                // 递增，不包括相等
                if (nums[r] >= nums[r + 1]) break;
                r++;
            }
            // 此时r就是递增区间的右端点
            maxLen = Math.max(maxLen, r + 1 - l);
            // 打印结果
            Utils.printlnArray(nums, l, r);
            //
            l = r + 1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        P674 solution = new P674();
        int[] nums = {1, 3, 5, 7};
        int res = solution.findLengthOfLCIS(nums);
        System.out.println(res);
    }
}
