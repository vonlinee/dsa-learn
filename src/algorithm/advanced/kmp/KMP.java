package algorithm.advanced.kmp;

import utils.Utils;

/**
 * @author vonline
 * @since 2022-07-13 5:44
 */
public class KMP {

    // 暴力匹配
    //http://data.biancheng.net/view/179.html
    int bruteForce(String text, String pattern) {
        // 双指针：i指向文本串，j指向模式串
        int i = 0, j = 0;
        // 循环遍历，类似于两层循环
        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                // 主串跳到本次开始匹配的位置的右边一个位置
                i = i - j + 1;
                // 模式串从0开始匹配
                j = 0;
            }
        }
        //跳出循环有两种可能
        // 1.i = text.length()说明已经遍历完主串，匹配失败
        // 2.j == pattern.length(),说明子串遍历完成，在主串中成功匹配
        if (j == pattern.length()) {
            return i - j;
        }
        //运行到此，为i = text.length()的情况
        return 0;
    }

    public int kmp(String t, String p) {
        int[] next = build_next(p);
        int i = 0;
        int j = 0;
        while (i < t.length()) {
            if (t.charAt(i) == p.charAt(j)) { // 单个字符匹配，指针右移动
                i++;
                j++;
            } else if (j > 0) {
                j = next[j - 1]; // 字符匹配失败，根据next跳过子串前面的一些字符
            } else {
                i++;
            }
            if (j == p.length()) { // 匹配成功
                return i - j;
            }
        }
        return -1;
    }

    // 动态规划
    private int[] build_next(String pattern) {
        int[] next = new int[pattern.length()];
        int i = 1;
        int prefix_len = 0; // 当前共同前后缀的长度
        while (i < pattern.length()) {
            // 下一个字符相同，可以构成一个更长的前后缀
            if (pattern.charAt(prefix_len) == pattern.charAt(i)) {
                prefix_len++;
                next[i] = prefix_len;
                i += 1;
            } else {
                // 如果不相同，往前找看有没有更小的，前面的是已经计算好的
                if (prefix_len == 0) {
                    next[i] = 0;
                    i++;
                } else {
                    prefix_len = next[prefix_len - 1];
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        int i = kmp.bruteForce("AAAAAAAAAAAAB", "AAAB");
        System.out.println("AAAAAAAAAAAAB".indexOf("AAAB"));
        Utils.printlnArray(kmp.build_next("ABACABAB"));
        System.out.println(i);
    }
}
