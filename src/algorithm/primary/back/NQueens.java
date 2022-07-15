package algorithm.primary.back;

/*
 * 在n×n格的棋盘上放置彼此不受攻击的n个皇后。按照
 * 国际象棋的规则，皇后可以攻击与之处在同一行或同
 * 一列或同一斜线上的棋子。n后问题等价于在n×n格的
 * 棋盘上放置n个皇后，任何2个皇后不放在同一行或同
 * 一列或同一斜线上。
 * 解向量：(x1, x2, … , xn)
 * 显约束：xi=1,2, … ,n
 * 隐约束：
 *  1)不同列：xi!=xj
 *  2)不处于同一正、反对角线：|i-j|!=|xi-xj|
 */
public class NQueens {
    static int n;// 皇后个数
    static int[] x;// 当前解
    static long sum;// 当前已经找到的可行方案数

    public long nQueen(int nn) {
        n = nn;
        sum = 0;
        x = new int[n + 1];
        for (int i = 0; i <= n; i++)
            x[i] = 0;
        backtrack(1);
        return sum;
    }

    private boolean place(int k) {
        for (int j = 1; j < k; j++)
            if ((Math.abs(k - j) == Math.abs(x[j] - x[k])) || (x[j] == x[k])) return false;
        return true;
    }

    /**
     * 对指定的行进行处理，并递归处理剩下行
     * @param t 指定行
     */
    private void backtrack(int t) {
        if (t > n)//所有行均处理（也就是不被回溯）
            sum++;
        else for (int i = 1; i <= n; i++) {
            x[t] = i;//i表示放置的列
            if (place(t)) {
                backtrack(t + 1);
            }
        }
    }
}