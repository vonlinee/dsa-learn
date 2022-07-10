package question.leetcode.leetbook.easy.design;

import utils.Utils;

import java.util.Random;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn6gq1/
 */
public class ShuffleArray {

    //给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。

    int[] nums;
    private final Random random;
    int[] origin;

    public ShuffleArray(int[] nums) {
        this.nums = this.origin = nums;
        random = new Random();
    }

    public int[] reset() {
        return origin;
    }

    //打乱数组
    public int[] shuffle() {
        if (nums == null) return null;
        int[] a = nums.clone();//clone一个新的数组
        for (int j = 1; j < a.length; j++) {
            // 带参的nextInt(int x)则会生成一个范围在0~x（不包含X）内的任意正整数
            int i = random.nextInt(j + 1);
            swap(a, i, j);
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        if (i != j) {
            a[i] = a[i] + a[j];
            a[j] = a[i] - a[j];
            a[i] = a[i] - a[j];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ShuffleArray solution = new ShuffleArray(nums);
    }
}
