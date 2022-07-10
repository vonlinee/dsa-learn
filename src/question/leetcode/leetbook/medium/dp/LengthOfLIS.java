package question.leetcode.leetbook.medium.dp;

/**
 * <p>
 * https://leetcode.cn/leetbook/read/top-interview-questions-medium/xwhvq3/
 * </p>
 * 最长递增子序列
 */
public class LengthOfLIS {

    //给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    //
    //子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

    //示例1
    //输入：nums = [10,9,2,5,3,7,101,18]
    //输出：4
    //解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

    /**
     * 部分通过
     * <p>
     * 错误原因；因为是从左向右比，只要出现递增就算一个结果，但是右边可能有递减的，但是相对前一个数还是递增的
     * 例如： 1 9 2 3 4 5 6，最长的应该是1 2 3 4 5 6，而下面的算法不会把1 2 3 4 5 6算进去
     * @param nums
     * @return
     */
    public int lengthOfLIS_1(int[] nums) {
        int maxLen = 0;
        // 从每个数开始，遍历数组找到以该数开始的递增子序列
        for (int i = 0; i < nums.length; i++) {
            // 当前数字开头的递增序列
            int cur = nums[i];
            int count = 1;
            System.out.print("递增子序列: " + cur + " ");
            for (int k = i + 1; k < nums.length; k++) {
                if (nums[k] > cur) {
                    System.out.print(nums[k] + " ");
                    cur = nums[k];
                    count++;
                }
            }
            if (count > maxLen) maxLen = count;
            System.out.print("\n");
        }
        return maxLen;
    }

    /**
     * 思路：因为递增子序列的元素在原数组中的顺序必然有：出现的顺序从左到右
     * 索引肯定是从前面的的某个元素开始构成递增子序列的第一个元素
     * @param nums
     * @return
     */
    public int lengthOfLIS_2(int[] nums) {
        return process1(nums, 0, 0);
    }

    /**
     * 没写完整
     * <p>
     * 回溯算法就类似遍历多叉树
     * 又是遍历多叉树
     * @param nums
     * @param start
     * @param totalLen
     * @return
     */
    public int process1(int[] nums, int start, int totalLen) {
        // 从start这个元素开始，如果每找到第一个递增的元素，那么就向下递归，长度加1
        // 注意是相邻
        System.out.print(nums[start] + " ");
        // 找到递增的元素时就向下递归
        for (int j = start; j < nums.length; j++) {
            if (nums[j] > nums[start]) {
                process1(nums, j + 1, totalLen + 1);
            }
        }
        // 如果没有找到，直接返回结果
        System.out.print("\n");
        return totalLen;
    }

    public static void main(String[] args) {
        LengthOfLIS ans = new LengthOfLIS();
        int[] nums = {1, 9, 2, 3, 4, 5, 6};
        int i = ans.lengthOfLIS_2(nums);
        System.out.println("最长递增子序列的长度 = " + i);
    }
}
