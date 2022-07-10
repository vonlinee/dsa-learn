package question.leetcode.leetbook.easy.other;

import utils.Utils;

import javax.rmi.CORBA.Util;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnc5vg/
 * <p>
 * 颠倒给定的 32 位无符号整数的二进制位。
 * <p>
 * 提示：
 * <p>
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnc5vg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReverseBits {

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();

        reverseBits.reverseBits(10);
    }

    public int reverseBits2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //res先往左移一位，把最后一个位置空出来，
            //用来存放n的最后一位数字
            res <<= 1;
            //res加上n的最后一位数字
            res |= n & 1;
            //n往右移一位，把最后一位数字去掉
            n >>= 1;
        }
        return res;
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // 先获取二进制串
        Utils.println32Bits(n);

        String s = Utils.to32BinaryString(n);

        char[] chars = s.toCharArray();

        char temp;
        int len = chars.length;
        for (int i = 0; i < chars.length; i++) {
            // 对称交换
            temp = chars[i];
            chars[i] = chars[len - 1 - i];
            chars[len - 1 - i] = temp;
        }
        // 然后反向输出即可
        return n;
    }

    // 进阶: 如果多次调用这个函数，你将如何优化你的算法？
}
