package algorithm.primary.dp;

import utils.Utils;

/**
 * 背包问题
 * @author vonline
 * @since 2022-07-13 22:28
 */
public class Package {

    public int getMaxValue(int[] weight, int[] value, int bag) {
        return process(weight, value, 0, 0, bag);
    }

    public int process(int[] w, int[] v, int index, int alreadyW, int bag) {
        if (alreadyW > bag) {
            return -1;
        }
        // 重量没超
        if (index == w.length) return 0;
        int p1 = process(w, v, index + 1, alreadyW, bag);
        int p2next = process(w, v, index + 1, alreadyW + w[index], bag);
        int p2 = -1;
        if (p2next != -1) {
            p2 = v[index] + p2next;
        }
        return Math.max(p1, p2);
    }

    public int getMaxValue1(int[] weight, int[] value, int bag) {
        return process(weight, value, 0, 0, bag);
    }

    // 只剩下rest的空间了
    // index 货物自由选择，但是不要超过rest的空间
    // 返回能够获得的最大价值
    public int process2(int[] w, int[] v, int index, int rest) {
        // 小于0认为是无效解
        if (rest < 0) return -1; // base case 1
        // rest >= 0
        if (index == w.length) return 0; // base case 2
        // 有货也有空间
        int p1 = process2(w, v, index + 1, rest);
        int p2 = -1;
        int p2Next = process2(w, v, index + 1, rest - w[index]);
        if (p2Next != -1) {
            p2 = v[index] + p2Next;
        }
        return Math.max(p1, p2);
    }

    // 动态规划方式
    public int dpWay(int[] w, int[] v, int bag) {
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        // 单层for循环
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 1; rest <= bag; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest >= w[index]) {
                    dp[index][rest] = Math.max(dp[index][rest], v[index] + dp[index + 1][bag]);
                }
            }
        }
        return dp[0][bag];
    }

    int knapsack(int capacity, int count, int[] weight, int[] value) {
        // base case 为0
        // dp[i][j]：对于前i个物品，当背包的容量为j时，可以装的最大价值是dp[i][j]
        int[][] dp = new int[count + 1][capacity + 1];
        // 容量和个数都从1开始遍历
        for (int i = 1; i <= count; i++) { // 遍历物品
            // 在capacity的约束下
            for (int j = 1; j <= capacity; j++) {
                // 背包容量比第i个物品的重量小，显然第i个物品不可能放入
                if (j - weight[i - 1] < 0) {
                    // 这种情况下只能选择不装入背包，因为容量不够了
                    dp[i][j] = dp[i - 1][j];
                } else { // 装入或不装如背包，择优
                    dp[i][j] = Math.max(
                            //把第i个物品装入背包
                            dp[i - 1][j - weight[i - 1]] + value[i - 1],
                            //不把第i个物品装入背包
                            dp[i - 1][j]);
                }
            }
        }
        return dp[count][capacity];
    }

    public static void main(String[] args) {
        int W = 4; // 容量
        int N = 3; // 物品个数
        int[] weight = {2, 1, 3};
        int[] value = {4, 2, 3};

        Package test = new Package();

        int maxValue = test.knapsack(W, N, weight, value);

        System.out.println(maxValue);

    }
}
