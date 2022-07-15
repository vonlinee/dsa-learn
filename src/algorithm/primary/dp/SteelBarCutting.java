package algorithm.primary.dp;

/**
 * 钢条切割问题：摘自算法导论第三版
 */
public class SteelBarCutting {

    public void cutting(int[] prices) {

    }

    // 自顶向下递归实现
    public int cutting1(int[] prices, int n) {
        if (n == 0) {
            return 0;
        }
        int q = 0;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, prices[i] + cutting1(prices, n - i));
        }
        return q;
    }

    public static void main(String[] args) {
        SteelBarCutting ans = new SteelBarCutting();
        // 长度[1, 10]对应的价格
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        int i = ans.cutting1(prices, 4);

        System.out.println(i);
    }
}
