package algorithm.recursive;

/**
 * 排列组合问题
 * <p>
 * 从n个不同元素中任取m个(约定1＜m≤n)，按任意一种次序排成一列，称为排列，其排列种数记为A(n, m)
 * <p>
 * 从n个不同元素中任取m个(约定1＜m＜n)成一组，称为一个组合，其组合种数记为C(n, m)。
 * <p>
 * <p>
 * P 和 C 的本质区别在于：决策的顺序对结果有没有影响。
 */
public class PermutationAndCombination {

    /**
     * 对指定的正整数m, n，具体实现从n个不同元素中任取m个元素A(n, m)的每一排列。
     * @param k
     * @param m 不变
     * @param n 不变
     * @return
     */
    public int permutation(int k, int m, int n, int[] nums, int s) {
        if (k <= m) {
            // 从可选数的范围内枚举
            for (int i = 0; i <= n; i++) {
                nums[k] = i; // 第k个数赋值i
                // 用于判断是否重复
                boolean flag = false;
                for (int j = 1; j <= k - 1; j++) {
                    // 若出现重复数字则将标记设为true
                    if (nums[k] == nums[j]) {
                        flag = true;
                    }
                    // 如果第k个数可以置为i，则检测是否到m个数
                    if (!flag) {
                        if (k == m) {
                            //打印出一个解
                            s++;
                            for (int l = 1; l <= m; l++) {
                                System.out.print(nums[l] + " ");
                            }
                        } else {
                            return permutation(k + 1, m, n, nums, s);
                        }
                    }
                }
            }
        }
        return s;
    }

    public void combination() {

    }

    public static void main(String[] args) {
        PermutationAndCombination test = new PermutationAndCombination();

        int permutation = test.permutation(1, 2, 3, new int[30], 0);

    }
}
