package question.leetcode.problem;

/**
 * 斐波拉契问题
 * https://ssg.leetcode-cn.com/problems/fibonacci-number/  简单
 * <p>
 * <p>
 * 斐波那契数列（Fibonacci sequence），又称黄金分割数列、因数学家列昂纳多·斐波那契（Leonardoda Fibonacci）
 * 以兔子繁殖为例子而引入，故又称为“兔子数列”，指的是这样一个数列：1、1、2、3、5、8、13、21、34、……
 * 在数学上，斐波那契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 3，n ∈ N*）
 */
public class P509_FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(fibonacci3(1));
        System.out.println(fibonacci3(2));
        System.out.println(fibonacci3(3));
        System.out.println(fibonacci3(4));
        System.out.println(fibonacci3(5));
    }

    /**
     * 普通的递归写法
     * 时间复杂度：O(2^n)
     * 即递归树中节点的总数。显然二叉树节点总数为指数级别，所以子问题个数为 O(2^n)。
     * @param n
     * @return
     */
    public static int fibonacci1(int n) {
        if (n == 0 || n == 1) return n;
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    // 加了备忘录的自顶向下的递归
    // 剪枝：时间复杂度 O(1) x O(n) = O(n)，但空间复杂度提高为O(n)
    // 将递归树转化为链表了
    public int fibonacci2(int N) {
        // 备忘录
        int[] memo = new int[N + 1];
        // 通过备忘录进行递归
        return helper(memo, N);
    }

    public int helper(int[] memo, int n) {
        // base case
        if (n == 0 || n == 1) return n;
        // 已经计算过，不用再计算了
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    /**
     * 迭代写法
     * 自底向上：从第一项开始，推出第N项
     * @param N
     * @return
     */
    public static int fibonacci3(int N) {
        if (N == 0 || N == 1) return N;
        // 备忘录
        int[] memo = new int[N];
        // base case
        memo[0] = 1;
        memo[1] = 1;
        // 迭代：状态转移方程
        for (int i = 2; i < N; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[memo.length - 1];
    }

    /**
     * 不使用数组，使用变量来存，更节省空间
     * @param n
     * @return
     */
    public static int fibonacci4(int n) {
        int i, n1 = 1, n2 = 1, sum = 0;
        for (i = 3; i <= n; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return sum;
    }
}
