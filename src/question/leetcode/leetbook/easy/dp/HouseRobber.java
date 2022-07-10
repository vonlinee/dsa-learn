package question.leetcode.leetbook.easy.dp;

import utils.Utils;

/**
 * 打家劫舍系列：https://www.cnblogs.com/gzshan/p/11188104.html
 * <p>
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnq4km/
 */
public class HouseRobber {

//    你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素
//    就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//    给定一个代表每个房屋存放金额的非负整数数组，计算你不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

    // 同一天不能进入两件相邻的房屋，即使那样金额更高
    // 报警意味着不能再进行偷窃

    // 如果数组元素没有重复的话，可以使用计数排序

    public int rob(int[] nums) {
        // 找到最大值
        int maxValue = Utils.maxValueOf(nums);
        String[] newArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {

        }
        // 如果要先排序，根据值找到索引，关键是值可能有相同的

        // 先排序
        for (int i = 0; i < newArr.length; i++) {

        }
        return 0;
    }

    public int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return rob(nums, 0, false);
    }

    // 问题：每次都尽可能选最高的能不能保证结果就是最大的？ 不是
    // 比如[2, 3, 2]

    // 贪心解决-部分通过
    public int rob(int[] nums, int max, boolean exit) {
        if (exit) {
            return max;
        }
        int index = -1;
        // 每次都偷最大的
        int maxValue = 0;
        // 找到[1, length -2]上的最小值
        for (int i = 0; i < nums.length; i++) {
            //  如果被偷过：那么不可能满足  nums[i] > maxValue
            if (!canBeStolen(nums, i)) {
                continue;
            }
            if (maxValue <= nums[i]) {
                maxValue = nums[i];
                index = i;
            }
        }
        // 比较端点值
        // 确定要偷谁
        if (index >= 0) {
            nums[index] = 0;
        } else {
            // 找了一轮还没找到合适偷的对象，此时应该终止递归
            exit = true;
        }
        // 如果0没被偷，但又不可能偷它
        return rob(nums, max + maxValue, exit);
    }

    public boolean canBeStolen(int[] nums, int index) {
        if (nums[index] == 0) {
            return false;
        }
        // 注意两个端点值也要互相比较
        int i = nums.length;
        if (index == 0) {
            return nums[1] != 0;
        }
        if (index == i - 1) {
            return nums[i - 2] != 0;
        }
        // 相邻的房屋被偷了
        return !(nums[index - 1] == 0 || nums[index + 1] == 0);
    }

    /**
     * 动态规划-迭代版本 （正解）
     * @param nums
     * @return
     */
    public int rob_2(int[] nums) {
        //边界条件判断
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;
        // 其中dp[i][0]表示第i+1（因为数组下标是从0开始的，所以这里是i+1）家偷了的最大总金额，
        // dp[i][1]表示的是第i+1家没偷的最大总金额
        int[][] dp = new int[length][2];
        dp[0][0] = 0;//第1家没偷
        dp[0][1] = nums[0];//第1家偷了
        //从第2个开始判断
        for (int i = 1; i < length; i++) {
            //下面两行是递推公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        //最后取最大值即可
        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        HouseRobber solution = new HouseRobber();
        int i = solution.rob1(nums);
        System.out.println(i);
    }
}
