package question.leetcode.problem;

import utils.Utils;

/**
 * https://leetcode.cn/problems/unique-paths/
 * @author vonline
 * @since 2022-07-13 4:58
 */
public class P62_UniquePaths {

    //一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
    //机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    //问总共有多少条不同的路径？

    // 很明显用动态规划来解

    // [m, n]
    // 从[0, 0] -> [m-1, n-1]的路径数 = 从[0, 0] -> [m-2, n-1]的路径数 + 从[0, 0] -> [m-1, n-2]的路径数

    public int uniquePaths(int m, int n) {
        return 0;
    }

    /**
     * 比较简单的动态规划题目
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了71.53%的用户
     * 通过测试用例：63 / 63
     * @param m
     * @param n
     * @return
     */
    private int countPath(int m, int n) {
        if (m == 2 && n == 2) {
            return 2;
        }
        if (m < 2 || n < 2) {
            return 1;
        }
        // dp[i][j]表示从该点到终点的路径走法
        int[][] dp = new int[m][n];

        // dp[m - 1][n - 1] = 0;
        // 只能向下
        dp[m - 2][n - 1] = 1;
        // 只能向右走一步
        dp[m - 1][n - 2] = 1;

        // 状态转移
        // [i, j]位置只能由[i-1][j]向下或者[i][j-1]向右
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 已经初始化过了
                if (dp[i][j] != 0) continue;
                int a = i + 1 >= m ? 0 : dp[i + 1][j];
                int b = j + 1 >= n ? 0 : dp[i][j + 1];

                Utils.println("[%s, %s] %s + %s = %s", i, j, a, b, a + b);
                dp[i][j] = a + b;

                Utils.printlnArray(dp);
                System.out.println();
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        P62_UniquePaths test = new P62_UniquePaths();

        int i = test.countPath(3, 2);

        System.out.println(i);
    }
}
