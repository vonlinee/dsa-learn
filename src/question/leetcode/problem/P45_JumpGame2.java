package question.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 中等：跳跃游戏 II
 * https://leetcode.cn/problems/jump-game-ii/
 */
public class P45_JumpGame2 {

    /**
     * 在此用例下报OOM: {5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5};
     * <p>
     * 转化成多叉树来遍历
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        if (nums.length - 1 < nums[0]) return 1;
        List<Integer> results = new ArrayList<>();
        int val = nums[0];
        if (val == 0) return 0;
        // 多叉树
        jump(nums, 0, 0, results);
        System.out.println(results);
        if (!results.isEmpty()) {
            int min = results.get(0);
            for (int j : results) {
                if (j < min) {
                    min = j;
                }
            }
            return min;
        }
        return 0;
    }

    public static void jump(int[] nums, int index, int totalTimes, List<Integer> list) {
        // 越界
        if (index >= nums.length) return;
        // 刚好到最后一个位置
        if (index == nums.length - 1) {
            list.add(totalTimes);
            return;
        }
        int val = nums[index];
        if (val == 0) return;
        for (int i = 1; i <= val; i++) {

            // index = index + i; // 不能这么写，index值在当前节点处不能变

            jump(nums, index + i, totalTimes + 1, list);
        }
    }

    // 别人的解法
    public static int jump1(int[] nums) {
        if (nums.length == 1) return 0;
        int reach = 0;
        int nextreach = nums[0];
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            // 计算下一次跳到的地点
            // i + nums[i]表示能跳到的最远的位置
            nextreach = Math.max(i + nums[i], nextreach);
            if (nextreach >= nums.length - 1) return (step + 1);
            if (i == reach) {
                step++;
                reach = nextreach;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int jump = jump1(nums);
        System.out.println(jump);
    }
}
