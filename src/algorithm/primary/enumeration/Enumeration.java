package algorithm.primary.enumeration;

/**
 * 枚举
 */
public class Enumeration {

    /**
     * 设n为正整数，求代数和
     * 求Sn = 1 + 1/2 - 1/3 + 1/4 + 1/5 - 1/6 + ... (+/-) 1/n
     * 和式中各项的符号为两个“+”号后一个“-”号，即分母能被3整除的项为“-”，其余项为“+”。
     * <p>
     * 输入n，要求计算并输出代数和四舍五入精确到小数点后第6位
     */
    public void sum(int N) {
        double sum = 0;
        for (int i = 1; i <= N; i++) {
            if (i % 3 == 0) sum += -1.0 / i;
            if (i % 3 != 0) sum += 1.0 / i;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Enumeration enumeration = new Enumeration();
        System.out.println(1.0 / 3.0);
        enumeration.sum(10);
    }
}
