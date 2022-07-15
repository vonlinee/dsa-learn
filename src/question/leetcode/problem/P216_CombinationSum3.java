package question.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和 III: https://leetcode.cn/problems/combination-sum-iii/
 * @author vonline
 * @since 2022-07-15 20:41
 */
public class P216_CombinationSum3 {

    //找出所有相加之和为n的k个数的组合，且满足下列条件：
    //1.只使用数字1到9
    //2.每个数字最多使用一次
    //返回所有可能的有效组合的列表，该列表不能包含相同的组合两次，组合可以以任何顺序返回。
    // 2 <= k <= 9
    // 1 <= n <= 60
    public List<List<Integer>> combinationSum3(int k, int n) {
        // 可选择的数
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int minSum = 0, maxSum = 0;
        for (int i = 0; i < k; i++) {
            minSum += nums[i];
            maxSum += nums[9 - k - 1];
        }
        // 最小，最大
        if (n < minSum || n > maxSum) {
            return new ArrayList<>();
        }
        System.out.println("非空解");
        // 应该是回溯吧
        // 选择k个数
        List<Integer> selected = new ArrayList<>(k);

        choose(nums, k, 0, n, selected);

        // n - k代表列表中出现的数的上限
        return new ArrayList<>();
    }

    public List<Integer> choose(int[] nums, int k, int selectedNum, int restSum, List<Integer> selected) {
        if (selected.size() == k) {
            // 选择了k个符合要求的数字
            if (restSum == 0) {
                System.out.println("选择了" + selected + ", 符合要求");
                return selected;
            }
            //
            System.out.println("选择了k个不符合要求的数字：" + selected);
            return null;
        }
        // 选择该数字
        if (selectedNum > 0) {
            selected.add(selectedNum);
        }
        for (int i = 0; i < nums.length; i++) {
            if (selected.contains(nums[i])) continue;
            List<Integer> mayBeSelected = choose(nums, k, nums[i], restSum - nums[i], selected);
            if (mayBeSelected == null) continue;
            if (mayBeSelected.size() == k) {
                System.out.println(mayBeSelected);
            }
        }
        return selected;
    }

    public static void main(String[] args) {
        P216_CombinationSum3 test = new P216_CombinationSum3();

        test.combinationSum3(3, 9);
    }
}
