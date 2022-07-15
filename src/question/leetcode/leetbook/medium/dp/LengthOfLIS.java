package question.leetcode.leetbook.medium.dp;

import utils.Utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        return process1(nums, 0, 1, null);
    }

    /**
     * 没写完整
     * <p>
     * 回溯算法就类似遍历多叉树
     * 遍历多叉树的当问题规模比较大时会超时
     * @param nums
     * @param start
     * @param totalLen
     * @return
     */
    public int process1(int[] nums, int start, int totalLen, int[] memo) {
        // 边界条件
        if (start >= nums.length - 1) {
            // 如果没有找到，直接返回结果
            return totalLen;
        }
        // 初始化结果
        if (memo == null) {
            memo = new int[nums.length - start + 1];
            Arrays.fill(memo, -1);
            nums[0] = nums[start];
        }
        memo[start] = nums[start];
        System.out.print(nums[start] + " ");
        // 从start这个元素开始，如果每找到第一个递增的元素，那么就向下递归，长度加1
        // 注意是相邻
        // 找到递增的元素时就向下递归
        for (int j = start + 1; j < nums.length; j++) {
            if (nums[j] > nums[start]) {
                // 找到一个连续的递增的

                // 子问题
                totalLen = Math.max(totalLen, totalLen + process1(nums, j, 1, memo));
            }
        }
        Utils.println("找到从%s开始的一个递增子序列", nums[start]);
        return totalLen;
    }

    /**
     * 此方法有问题
     * 求所有递增的子序列，这里只算长度大于1的
     * 单个值不构成子序列
     * @param nums
     * @return
     */
    public void findAllLIS(int[] nums) {
        int index = 0;
        int maxLen = 0;
        while (index < nums.length) {
            int prev = nums[index];
            int k = index;
            while (k < nums.length) {
                // 存储结果
                // 先放开头
                int len = 1;
                StringBuilder res = new StringBuilder(String.valueOf(nums[index]));
                for (int i = k; i < nums.length; i++) {
                    if (nums[i] > prev) {
                        prev = nums[i];
                        len++;
                        res.append(" ").append(prev);
                    }
                }
                if (res.length() > 1) {
                    System.out.println(res);
                    maxLen = Math.max(maxLen, len);
                }
                k++;
                // 重置前一个值为当前开头的值
                prev = nums[index];
            }
            index++;
        }
        System.out.println("最长 = " + maxLen);
    }

    // 求所有子序列，不要求递增 => 排列问题
    // 求出给定数组的所有子序列
    private List<List<Integer>> getAllSubArray(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int mark = 0;
        int count = 1 << nums.length;
        boolean flag = false;
        for (mark = 0; mark < count; mark++) {
            List<Integer> temp = new ArrayList<>();
            flag = true;
            for (int i = 0; i < nums.length; i++) {
                if (((1 << i) & mark) != 0) {
                    flag = false;
                    temp.add(nums[i]);
                }
            }
            result.add(temp);
        }
        return result;
    }

    // 组合问题
    // 子序列有顺序要求
    public void findAllSubSequence(int[] nums) {
        // 每个数有出现和不出现两种状态
        int N = nums.length;
        //
        boolean[] flag = new boolean[N];
        for (int i = 0; i < N; i++) {
            System.out.println(helper(flag, nums));
            flag[i] = true;
        }
        System.out.println(helper(flag, nums));
    }

    public String helper(boolean[] flag, int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(flag[i] ? nums[i] : "");
        }
        return sb.toString();
    }

    public int lengthOfLIS_5(int[] nums) {
        int[] dp = new int[nums.length];
        // base case
        dp[0] = 1;
        // 状态转移
        for (int i = 1; i < nums.length; i++) {
            // 如果到dp[i]还是递增的
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                continue;
            }
            // 往前寻找，找到比当前位置小的数的位置
            int j = i - 1;
            while (j >= 0 && nums[j] >= nums[i]) {
                j--;
            }
            dp[i] = dp[j] + 1;
        }
        return dp[nums.length - 1];
    }

    /*
        根据官方题解，这里动态转移方程是：
        dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
        官方意思就是  （以示例2为例）
        用一个dp数组保存 以nums数组当前索引位置的元素为末尾的最长的递增子序列的长度
        dp[0] = 1  //一个数就是一个子序列的长度1  最长子序列：[0]
        dp[1] = max(dp[0]+1 = 2, 前面所有元素中比当前元素的小的最大dp值  [0,1]
        dp[2] = max(没有==0)+1 = 1，没有比0小的，所以直接是1     [0]
        dp[3] = max(dp[0],dp[1],d[2])+1 = 3,通过nums数组得有0,1,2位置的元素小于当前，找最大子序列长度来+1  [0,1,3]
        dp[4] = max(dp[0],dp[1],dp[2])+1 = 3 ......  [0,1,2]
        dp[5] = max(dp[0],dp[1],dp[2],dp[4])+1 = 4  ......  [0,1,2,3]
        所以得到dp数组为[1,2,1,3,3,4]
        依次对应着nums数组索引位置元素为末尾的最长递增子序列的长度
        然后找到其中最大值即可。
    */
    public int lengthOfLIS_7(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        // 单个元素作为序列的长度为1
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < len; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max == Integer.MIN_VALUE ? 1 : max + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        // 单个元素作为序列的长度为1
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < len; i++) {
            int max = Integer.MIN_VALUE;
            // 找到前面的比i位置小的数
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max == Integer.MIN_VALUE ? 1 : max + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 通过
    public int lengthOfLIS_10(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        // 单个元素作为序列的长度为1
        int max = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            // 找到前面的比i位置小的数
            for (int j = 0; j < i; j++) {
                // 这里可能比较多次
                // 实际上肯定有dp[i] >= dp[i-1]
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * 看懂思路
     * @param nums
     * @return
     */
    public int lengthOfLIS_9(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 1;
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = 1;
            dp[i][1] = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > dp[j][1]) { //i前面的数有比i小的
                    dp[i][0] = dp[j][0] + 1;
                    break;
                }
            }
            for (int tp = i; tp >= 0; tp--) {  //将到i为止的所有子序列按照长度从短到长排列
                if (dp[tp][0] < dp[tp - 1][0]) {
                    int temp0 = dp[tp - 1][0];
                    int temp1 = dp[tp - 1][1];
                    dp[tp - 1][0] = dp[tp][0];
                    dp[tp - 1][1] = dp[tp][1];
                    dp[tp][0] = temp0;
                    dp[tp][1] = temp1;
                } else {
                    break;
                }
            }
        }
        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        LengthOfLIS ans = new LengthOfLIS();
        int[] nums = {0, 1, 0, 3, 2, 3};
        ans.lengthOfLIS_5(nums);

    }
}
