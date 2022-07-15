package question.nowcoder.huawei.od;

import java.util.Arrays;

/**
 * 华为机试22题：https://blog.nowcoder.net/n/36ad345ecaeb40fba686cabc262fa9da
 * @author vonline
 * @since 2022-07-14 12:26
 */
public class QuestionCollection2 {

    /**
     * https://blog.nowcoder.net/n/8152e16f1a2d4b88a95f418c6e4078f0
     */
    public void question21() {

    }


    // 数字涂色
    // 涂相同色的数字都可以被同色的最小数整除，问最少需要多少种颜色？

    /**
     * 【数字图色】疫情过后，希望小学终于又重新开学了，三年二班开学第一天的任务是将后面的黑板报重新制作。黑板上已经写了N个正整数，同学们需要给这每个数分别上一种颜色。为了让黑板报既美观又有学习意义，老师要求同种颜色的所有数都可以被这种颜色中最小的那个数整除。现在请你帮帮小朋友们，算算至少需要多少种颜色才能给这N个数进行上色。
     * 输入描述:
     * 第一行有一个正整数N，其中1<=N<=100。
     * 第二行有个N个int型整数(保证输入数据在[1,100]范围内)，表示黑板上各个正整数的值。
     * 输出描述:
     * 输出只有一个整数，为最少需要的颜色种数。
     * 示例1:
     * 输入
     * 3
     * 2 4 6
     * 输出
     * 1
     */
    public void question22() {
        int[] nums = {2, 5, 7, 4, 6};
        System.out.println(tushe(nums));
    }

    // 输入一个K，从1到100报数，报到K后移除K，然后下一个从1开始继续报数，直到剩下的人数比K小，问剩下的人原来的编号是多少？

    // 找到最小的数，然后看其他的数字中能被它整除的数为1种颜色
    private int tushe(int[] nums) {
        int rest = nums.length;
        int color = 0;
        // 先进行升序排序
        Arrays.sort(nums);
        int minValue = -1;
        while (rest > 0) {
            // 每轮循环都会找出一种颜色
            for (int i = 0; i < nums.length; i++) {
                // 已经删除了
                if (nums[i] == 0) continue;
                // 第一个不为0的数
                if (minValue == -1) minValue = nums[i];
                if (nums[i] % minValue == 0) {
                    nums[i] = 0;
                    rest--;
                }
            }
            color++;
            // 只在每轮循环第一次时进行赋值，找到最小值，
            minValue = -1;
        }
        return color;
    }

    public static void main(String[] args) {
        QuestionCollection2 solution = new QuestionCollection2();

        solution.question22();
    }
}
