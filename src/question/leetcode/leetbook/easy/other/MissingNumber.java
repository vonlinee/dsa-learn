package question.leetcode.leetbook.easy.other;

import java.util.Arrays;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnj4mt/
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
public class MissingNumber {

    // nums 中的所有数字都 独一无二
    // 0 <= nums[i] <= n
    public int missingNumber(int[] nums) {
        // nums有n个数，【0, n】
        int[] arr = new int[nums.length + 1]; // 索引是[0, n]
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    // 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?

    // 可以使用计数排序做，因为数字都是相邻的
    // 线性时间复杂度，但是是O(n)的额外空间
    public int missingNumber_1(int[] nums) {
        // nums有n个数，【0, n】
        int[] arr = new int[nums.length + 1]; // 索引是[0, n]
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    // 使用位运算

    // 相减：中间差了一个数，必然有一个位置的相邻两个数的差不为1
    public int missingNumber_2(int[] nums) {
        // 只有两种情况
        if (nums.length == 1) {
            return nums[0] == 0 ? 1 : 0;
        }
        // 先按递增顺序排序
        Arrays.sort(nums);
        int val = -1;
        // 中间差了一个数，必然有一个位置的相邻两个数的差不为1
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                val = nums[i] - 1;
            }
        }
        // 如果不存在，则肯定是开头或者结尾少了一个
        if (val < 0) {
            // 少了开头
            if (nums[0] != 0) return 0;
            // 少了结尾
            return nums[nums.length - 1] + 1;
        } else return val;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};

        MissingNumber solution = new MissingNumber();

        System.out.println(solution.missingNumber_2(arr));
    }
}
