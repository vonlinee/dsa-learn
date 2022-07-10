package algorithm.dp;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 * 零钱兑换问题
 */
public class CoinChange {

    /**
     * 暴力递归解法
     * 状态：目标金额 amount
     * 选择：conins 数组中列出的所有硬币面额
     * 函数的定义：凑出总金额amount，至少需要coninChange(coins, amount)枚硬币
     * base case: amount == 0时，需要 0 枚硬币；amount < 0 时，不可能凑出
     */
    public int coinChange1(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = coinChange1(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解
            res = Math.min(res, subProblem + 1);
        }
        // 最后判断是否有解
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // 使用备忘录的递归
    public int coinChange2(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        // 填充特殊值
        Arrays.fill(memo, -2);
        return helper(coins, amount, memo);
    }

    // memo长度为amount + 1，初始值为特殊值，不为0或者-1，可以使用-1之外的任意负数
    public int helper(int[] coins, int amount, int[] memo) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        // 返回备忘录的结果
        if (memo[amount] != -2) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = coinChange1(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解
            res = Math.min(res, subProblem + 1);
        }
        // 将计算结果存到备忘录
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }

    // 动态规划解法
    // 自底向上的迭代解法
    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 填充特殊值: amount + 1
        // 因为状态转移方程是取最小值，因此要选一个比较大的数据，而且不可能取到该值
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        // 外层for循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层for循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) continue;
                // 状态转移
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        // 看看能不能凑出来
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1};
        int amount = 0;

        CoinChange ans = new CoinChange();

        System.out.println(ans.coinChange3(coins, amount));
    }
}
