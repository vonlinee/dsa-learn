package question.leetcode.leetbook.medium.dp;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-medium/xvb8zs/
 * <p>
 * 跳跃游戏：此题有很多变种
 * @author vonline
 * @since 2022-07-12 18:39
 */
public class JumpGame {

    public static void main(String[] args) {

    }

    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        return false;
    }

    public boolean canJump_1(int[] nums) {
        int len = nums.length;
        //
        int[] dp = new int[len - 1];
        // 只要倒数第二个元素大于0，那么只要能够到达倒数第二个元素，则肯定能到达最后一个元素
        if (nums[len - 2] <= 0) return false;
        // base case
        dp[len - 2] = 0;
        // 最后一个元素不用管
        for (int i = len - 2; i >= 0; i--) {

        }
        return false;
    }

    /**
     * 递归写法
     * @param nums
     * @param from
     * @param to
     * @return
     */
    public boolean jump(int[] nums, int from, int to) {
        if (to == nums.length - 1) {
            System.out.println("跳到了最后一个");
            return true;
        }
        if (nums[from] == 0 || nums[to] == 0) {
            return false;
        }
        for (int i = 1; i <= nums[from]; i++) {
            boolean res = jump(nums, from, from + i);
            if (res) {
                System.out.println("成功");
            }
        }
        return false;
    }

    /**
     * https://leetcode.cn/problems/jump-game-ii/
     * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 假设你总是可以到达数组的最后一个位置。
     */
    private static class JumpGameII {

        public int jump(int[] nums) {
            int len = nums.length;
            // dp表示从i跳到最后位置的最小次数
            int[] dp = new int[len];
            // 只要倒数第二个元素大于0，那么只要能够到达倒数第二个元素，则肯定能到达最后一个元素

            // base case
            dp[len - 1] = 1;





            return 0;
        }
    }
}
