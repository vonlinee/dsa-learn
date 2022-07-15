package question.leetcode.primary.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 子字符串和子序列问题
 */
public class SubSequence {

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

}
