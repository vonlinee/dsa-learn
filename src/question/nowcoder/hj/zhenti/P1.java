package question.nowcoder.hj.zhenti;

/**
 * https://ac.nowcoder.com/discuss/962489?channel=-1&source_id=discuss_terminal_nctrack&trackId=2aaecp18m7qqsqwsunl9k
 */
public class P1 {

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE); // -2147483648
        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(Integer.MIN_VALUE - 1); // 2147483647
        System.out.println(Math.subtractExact(Integer.MIN_VALUE, 1)); // 抛异常
        System.out.println(Integer.MAX_VALUE + 1); // -2147483648
        System.out.println(Math.addExact(Integer.MAX_VALUE, 1)); // 抛异常
    }

    /**
     * 输入一行字符串全为字母，区分大小写。
     * 输出：按字符出现次数降序输出，如果同字母大小写相同，先输出小写，后输出大写。
     * 用分号隔开
     * @param str
     */
    public static void output(String str) {
        // 可以用计数排序

    }
}
