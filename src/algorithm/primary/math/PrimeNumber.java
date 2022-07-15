package algorithm.primary.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 素数
 * @author vonline
 * @since 2022-07-15 18:03
 */
public class PrimeNumber {

    public boolean isPrimeNumber(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrimeNumber1(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            //如果有能整除的数，则n不是素数，循环结束
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int greatestCommonDivisor(int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);

        int mod = max % min;
        while (mod != 0) {

            mod = max % min;
        }
        return 0;
    }

    // 递归实现辗转相除法
    public int maxCommonDivisor(int a, int b) {
        if (b != 0) {
            return maxCommonDivisor(b, a % b);
        }
        return a;
    }

    public void getFactor(int m) {
        for (int i = 1; i <= m; i++) {    //如果i<=m/2,则输出的因子不包括那个数本身
            if (m % i == 0) System.out.println(i + " ");
        }
    }

    private void f(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("必须是正整数");
        }
        StringBuilder result = new StringBuilder("1 ");
        for (int i = 2; i < num; i++) {
            while (num % i == 0) {
                result.append(i).append(" ");
                num = num / i;
            }
        }
        if (num > 1) {
            result.append(num);
        }
        System.out.println(result);
    }

    public void func(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                int j = i + num / i;
                if (!list.contains(j)) {
                    list.add(j);
                    System.out.println(i + "x" + (num / i) + "=" + num);
                }
            }
        }
    }

    public static void main(String[] args) {
        PrimeNumber main = new PrimeNumber();
        // main.func(12);

        System.out.println(Math.sqrt(2));
    }
}
