package question.leetcode.leetbook.easy.dp;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn854d/
 */
public class ClimbStairs {

    // 1 <= n <= 45
    // 当n比较大的时候会超时，所以不推荐
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // 尾递归也是递归
    // 一般的编译器或解释器有尾递归优化

    // 尾递归
    public static int climbStairs1(int n) {
        return Fibonacci(n, 1, 1);
    }

    /**
     * @param n 递归次数
     * @param a 初始值
     * @param b 每次递归的结果
     * @return
     */
    public static int Fibonacci(int n, int a, int b) {
        if (n <= 1) return b;
        // 每次递归的返回值由参数传入
        // 参数值由自己计算
        return Fibonacci(n - 1, b, a + b);
    }

    // 非递归版本
    public int climbStairs2(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        // 知道递推公式，递归就相当于循环调用，将每次递归的结果进行保存
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 非递归优化
    // 我们看到上面的数组当前值是依赖他前面两个值的（前两个除外），我们只需要用两个临时变量即可，不需要申请一个数组
    public int climbStairs3(int n) {
        if (n <= 2) return n;
        int first = 1, second = 2, sum = 0;
        while (n-- > 2) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

    // 根据状态转移方程，从最简单情况递推，遍历所有状态下的最优情况并保存在一个dp表中

    public static void main(String[] args) {
        ClimbStairs p = new ClimbStairs();
        int i = p.climbStairs(10);
        System.out.println(i);
    }
}
