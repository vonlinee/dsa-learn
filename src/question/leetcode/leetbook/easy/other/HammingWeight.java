package question.leetcode.leetbook.easy.other;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn1m0i/
 */
public class HammingWeight {

    public static void main(String[] args) {

        HammingWeight hw = new HammingWeight();

        int i = hw.hammingWeight(10);

        System.out.println(i);
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            System.out.println((n >> 1 & 1));
            if ((n >> 1 & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
