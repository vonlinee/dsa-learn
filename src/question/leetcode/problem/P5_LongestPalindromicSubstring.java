package question.leetcode.problem;

/**
 * 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/
 * @author vonline
 * @since 2022-07-14 9:00
 */
public class P5_LongestPalindromicSubstring {

    // 通过测试用例： 86 / 180
    public static String longestPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        boolean move = true;
        while (left < right) {
            boolean isPalindrome = true;
            // 取中位数
            int mid = (left + right) >>> 1;
            // [2, 8] -> 7个数，中位数5
            // [2, 7] -> 6个数，中位数4
            for (int i = left; i <= mid; i++) {
                // [left, right]区间有奇数个，
                // 计算对称坐标
                int index = (left + right) % 2 == 0 ? 2 * mid - i : 2 * mid - i + 1;
                if (s.charAt(i) != s.charAt(index)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) break;
            else {
                // 一次只移动一个指针
                if (move) {
                    left++;
                    move = false;
                } else {
                    right--;
                    move = true;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = left; i <= right; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    // 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
    private static String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // 双指针，向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }

    //执行用时：30 ms, 在所有 Java 提交中击败了67.20%的用户
    //内存消耗：42.4 MB, 在所有 Java 提交中击败了43.24%的用户
    //通过测试用例：180 / 180
    public static String longestPalindrome1(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome1("cbbd"));
    }
}
