package question.leetcode.problem;

/**
 * 回文数: https://leetcode.cn/problems/palindrome-number/
 * @author vonline
 * @since 2022-07-14 8:12
 */
public class P9_PalindromeNumber {

    //执行用时：5 ms, 在所有 Java 提交中击败了69.37%的用户
    //内存消耗：41.3 MB, 在所有 Java 提交中击败了7.35%的用户
    //通过测试用例：11510 / 11510
    // 你能不将整数转为字符串来解决这个问题吗？
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        for (int i = 0; i <= num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 判断字符串是否是回文串
    private boolean isPalindrome(String s) {
        // 一左一右两个指针相向而行
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 思路2：通过不断除10的方式获取整数的每位，放到数组里，还是通过for循环判断

    // 思路3：可以每次只获取最高位和最低位进行比较
    // 获取高位需要先知道位数

    // 获取整数的最高位
    // 怎么快速取得一个整数的最高位？ https://www.zhihu.com/question/19695086?sort=created
    // https://stackoverflow.com/questions/701322/how-can-you-get-the-first-digit-in-an-int-c/701621#701621
    public int getMaxDigit(int i) {
        if (i >= 100000000) i /= 100000000;
        if (i >= 10000) i /= 10000;
        if (i >= 100) i /= 100;
        if (i >= 10) i /= 10;
        return i;
    }

    //如果是回文数，显然不会溢出
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        int rem, y = 0;
        int quo = x;
        while (quo != 0) {
            rem = quo % 10;
            // 这里加法可能会溢出
            y = y * 10 + rem;
            quo = quo / 10;
        }
        return y == x;
    }

    public static void main(String[] args) {

        P9_PalindromeNumber test = new P9_PalindromeNumber();

        System.out.println(test.getMaxDigit(223));
    }
}
