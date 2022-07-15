package question.leetcode.primary.string;

import utils.Utils;

import java.util.*;

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

    // 查找给定的一个数组中的所有递增子序列，子序列长度>=2并且可以为本身

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> list = new LinkedList<>();
        dfs(nums, -1, list);
        return lists;
    }

    List<List<Integer>> lists = new LinkedList<>();

    /**
     * 给定一个数组，查找一个所有递增子序列，可以简化成从数组中找到所有长度为2、3、4......n的递增子序列，
     * 而为了从中找到长度为i的递增子序列，我们可以利用深度优先搜索的方式，先将一个数入栈，然后进行向后的深度搜索，
     * 找到一个大于等于栈底的元素，就可以再次入栈，再进行深度搜索，直到遍历完整个数组
     * 同时，我们为了高效利用每一个找到的递增子序列，例如长度为2的递增子序列一定包含在长度为3的递增子序列中，所以我们可以直接遍历一遍数组，
     * 将其中每次深度优先搜索完后长度大于1的序列保存，这样就可以成功找到所有递增子序列
     * @param nums
     * @param now_local
     * @param list
     */
    private void dfs(int[] nums, int now_local, List<Integer> list) {
        if (list.size() > 1) {
            lists.add(new LinkedList<>(list)); // 注意是new一下，因为后面会修改list的内容
        }
        Set<Integer> visited = new HashSet<>(); // 保存已经被访问的数组元素
        for (int i = now_local + 1; i < nums.length; i++) {
            if (visited.contains(nums[i])) {
                continue;
            }
            visited.add(nums[i]);
            if (now_local == -1 || nums[i] >= nums[now_local]) {
                list.add(nums[i]);
                dfs(nums, i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        SubSequence ans = new SubSequence();
        int[] nums = {7, 7, 7, 7, 7, 7, 7};

        List<List<Integer>> subsequences = ans.findSubsequences(nums);

        int a = "AAA".indexOf("A");

        int max = 0;
        for (List<Integer> subsequence : subsequences) {
            max = Math.max(max, subsequence.size());
        }
        Utils.printlnList(subsequences);
    }

}
