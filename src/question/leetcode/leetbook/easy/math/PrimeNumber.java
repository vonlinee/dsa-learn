package question.leetcode.leetbook.easy.math;

/**
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。 素数 = 质数
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnzlu6/
 */
public class PrimeNumber {

    public static void main(String[] args) {
        PrimeNumber solution = new PrimeNumber();

        int i = solution.countPrimes(10);

        System.out.println(i);
    }

    public int countPrimes(int n) {
        //boolean默认是false
        boolean[] arr = new boolean[n];
        int count = 0;
        //以下为 “埃拉托斯特尼” 筛选法
        for (int i = 2; i < n; i++) {
            if (arr[i]) continue;
            //为false累加
            count++;
            //for为了素数翻倍(变成合数)，合数翻倍还是合数，剩下的就真素数
            for (int j = i; j < n; j = i + j) {
                //把合数赋为true
                arr[j] = true;
            }
        }
        return count;
    }

}
