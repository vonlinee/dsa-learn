package question.leetcode.leetbook.easy.other;

public class BitOperation {

    public static void main(String[] args) {
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;
        System.out.println(low + high);
        int mid = (low + high) >>> 1;
        System.out.println(mid);
    }

    // https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn1m0i/
    // 位1的个数
    // you need to treat n as an unsigned value
    public int hammingWeight_1(int n) {
        // 把n往右移32次，每次都和1进行与运算
        int count = 0;
        for (int i = 0; i < 32; i++) {
            // 无符号右移，
            if (((n >>> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    // >>>运算符使您可以将int和long视为32位和64位无符号整数类型，这是Java语言所缺少的

//    https://www.codenong.com/16763917/
}
