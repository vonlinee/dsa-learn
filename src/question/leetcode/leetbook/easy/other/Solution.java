package question.leetcode.leetbook.easy.other;

import java.util.Stack;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnbcaj/
 */
public class Solution {

//    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

    //    有效字符串需满足：
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int slow = 0, fast = 0;
        for (int i = 0; i < chars.length; i++) {

        }
        return true;
    }

    public char matchedCharacter(char c) {
        return 0;
    }

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        //遍历所有的元素
        for (char c : chars) {
            //如果是左括号，就把他们对应的右括号压栈
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                //否则就只能是右括号。
                //1，如果栈为空，说明括号无法匹配。
                //2，如果栈不为空，栈顶元素就要出栈，和这个右括号比较。
                //如果栈顶元素不等于这个右括号，说明无法匹配，
                //直接返回false。
                return false;
            }
        }
        //最后如果栈为空，说明完全匹配，是有效的括号。
        //否则不完全匹配，就不是有效的括号
        return stack.isEmpty();
    }

    // 使用计数排序来做

    public static void main(String[] args) {
        System.out.println(((int) '(')); // 40
        System.out.println(((int) '{')); // 123
        System.out.println(((int) '[')); // 91
        System.out.println(((int) ')')); // 41
        System.out.println(((int) '}')); // 125
        System.out.println(((int) ']')); // 93
    }
}