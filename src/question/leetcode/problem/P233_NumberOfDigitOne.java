package question.leetcode.problem;

import utils.Utils;

/**
 * 数字 1 的个数:https://leetcode.cn/problems/number-of-digit-one/
 * @author vonline
 * @since 2022-07-14 23:00
 */
public class P233_NumberOfDigitOne {

    public int countDigitOne(int n) {
        return 0;
    }

    //
    public int countOne(int n) {
        int[][] dp = new int[n][2];
        dp[0][0] = 0; // 对应数字0
        dp[0][1] = 1; // 对应数字1
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1] + 1;
        }
        Utils.printlnArray(dp);
        return dp[n - 1][0] + dp[n - 1][1];
    }

    // 暴力求解
    // 很明显数字大了会超时
    public int countDigitOne1(int n) {
        int count = 0;
        while (n >= 0) {
            count += countOfDigitOne(n);
            n--;
        }
        return count;
    }

    public int countOfDigitOne(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (aChar == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        P233_NumberOfDigitOne test = new P233_NumberOfDigitOne();

        int i = test.countDigitOne(122);

        System.out.println(i);
    }
}
