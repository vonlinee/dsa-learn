package utils;

import java.util.*;

public abstract class Utils {

    private Utils() {}

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    public static void print(String format, Object... args) {
        System.out.print(new Formatter().format(format, args));
    }

    public static void println(String format, Object... args) {
        System.out.println(new Formatter().format(format, args));
    }

    public static void printlnList(List<?> list) {
        list.forEach(System.out::println);
    }

    public static void printlnMap(Map<?, ?> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void printlnArray(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static String string(int[] nums, int fromIndex, int toIndex) {
        StringJoiner s = new StringJoiner(", ", "[", "]");
        for (int i = fromIndex; i <= toIndex; i++) {
            s.add(String.valueOf(nums[i]));
        }
        return s.toString();
    }

    public static void printlnArray(int[] nums, int val) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            System.out.print(nums[i] + " ");
        }
        System.out.print("]\n");
    }

    public static int maxValueOf(int[] arr) {
        int max = 0; // 最大值
        for (int j : arr) {
            if (j > max) { // 当前值大于最大值，赋值为最大值
                max = j;
            }
        }
        return max;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public static int minValueOf(int[] arr) {
        int max = 0; // 最大值
        for (int j : arr) {
            if (j < max) { // 当前值大于最大值，赋值为最大值
                max = j;
            }
        }
        return max;
    }

    public static int minValueOf(List<Integer> arr) {
        int max = 0; // 最大值
        for (int j : arr) {
            if (j < max) { // 当前值大于最大值，赋值为最大值
                max = j;
            }
        }
        return max;
    }

    /**
     * Math.random生成[0, 1)的伪随机数
     * 伪随机数是用确定性的算法计算出来自[0,1]均匀分布的随机数序列。
     * 并不真正的随机，但具有类似于随机数的统计特征，如均匀性、独立性等。
     * 在计算伪随机数时，若使用的初值（种子）不变，那么伪随机数的数序也不变。
     * @param min
     * @param max
     * @return
     */
    public static int randomInt(int min, int max) {
        while (true) {
            int i = (int) (Math.random() * 10);
            if (i >= min && i < max) {
                return i;
            }
        }
    }

    /**
     * 将整形的二进制打印出来
     * @param num 整形是32位无符号数， long是64位的
     */
    public static void println32Bits(int num) {
        for (int i = 31; i > 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void printlnArray(int[] nums, int start, int end) {
        StringJoiner sb = new StringJoiner(", ", "[", "]");
        for (int i = start; i <= end; i++) {
            sb.add(String.valueOf(nums[i]));
        }
        System.out.println(sb);
    }

    public static String to32BinaryString(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 31; i > 0; i--) {
            sb.append((num & (1 << i)) == 0 ? "0" : "1");
        }
        return sb.toString();
    }

    /**
     * 只打印有的bit位，不会用0补齐
     * @param num
     */
    public static void printlnBits(int num) {
        System.out.println(Integer.toBinaryString(num));
    }

    public static String toBinaryString(int num) {
        return Integer.toBinaryString(num);
    }

    /**
     * https://www.codenong.com/16763917/
     * <p>
     * >>> 是找到两个(大)整数的舍入平均值的安全有效方法
     * <p>
     * 如果整数high和low接近最大的机器整数，则以上内容是正确的
     * @param l
     * @param r
     * @return
     */
    public static int middleOf(int l, int r) {
        // int mid = (low + high) / 2; // 可能由于溢出而得到错误的结果。
        return (l + r) >>> 1;
    }

    /**
     * 判断两个数是否互质，即公约数等于1
     * @param a
     * @param b
     * @return
     */
    public static boolean isCoprime(int a, int b) {
        return greatestCommonDivisor(a, b) == 1;
    }

    // 最大公约数
    // 阿基里德算法
    // https://blog.csdn.net/qq_50882544/article/details/122590108
    public static int greatestCommonDivisor(int a, int b) {
        return b == 0 ? a : greatestCommonDivisor(b, a % b);
    }

    /**
     * int类型一般占4个字节，故取值范围 -2^31 ~ 2^31-1，
     * 对于无符号另当别论，我们的讨论建立在以补码形式存储的带符号整数。
     * <p>
     * 参考：https://www.cnblogs.com/numen-fan/p/10883884.html
     * @param str 以字符串表示的数字
     * @return boolean
     */
    public static boolean isOverflow(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int index = 0;
        int sum = 0; // 记录累加结果
        while (index < length) {
            int digit = str.charAt(index) - '0';
            // 这里假定str是合法的字符串，不需要进行digit合法性判断
            if (Integer.MAX_VALUE / 10 < sum || (Integer.MAX_VALUE / 10 == sum && Integer.MAX_VALUE % 10 < digit)) {
                // 说明溢出
                return true;
            }
            // 说明还没有溢出
            sum = sum * 10 + digit;
            index++;
        }
        return false;
    }

    /**
     * https://www.cnblogs.com/SValley/p/14583363.html
     * <p>
     * Math类提供了一个判断是否溢出的方法
     * 原理: 只有两个相同符号的整数相加的时候才会溢出，一正一负相加不会溢出，溢出后得到的结果符号一定与原值的符号相反
     * 异或的规则是相同为0，不同为1，利用这个原理，将用运算符算出来的r与x和y分别异或，然后看符号位。
     * <p>
     * 例如：假设两个数都为正数，则两个数的符号位都为0，假设这两个数相加以后，如果溢出，则两个异或运算得到的数值符号位都是1，
     * 再将两个数运算得到的值相与，如果符号位不同，那么两个括号得到的数值符号位都是1(小于0)。而与运算又是只有1&1才是1，
     * 有一个为0都是0。所以只要溢出，无论是正溢出负溢出，(x ^ r) & (y ^ r)计算出的结果符号位都为1(数值小于0)。
     * // 符号位 0
     * int a = 2147483647;
     * // 符号位 0
     * int b = 2;
     * // 溢出 符号位 1
     * int c = a + b;
     * // 则
     * // a ^ c 符号位为 1
     * // b ^ c 符号位为 1
     * // 则
     * // (a ^ c) & (b ^ c) 为符号位为 1，小于 0
     * @param x
     * @param y
     * @return
     */
    public static boolean isAddOverflow(int x, int y) {
        int r = x + y;
        // 参考Math.addExact方法
        return ((x ^ r) & (y ^ r)) < 0;
    }

    /**
     * 减法溢出
     * @param x
     * @param y
     * @return
     */
    public static boolean isSubstractOverflow(int x, int y) {
        int r = x - y;
        // 参考Math.addExact方法
        return ((x ^ y) & (x ^ r)) < 0;
    }

    /**
     * 使用位运算将两个数相加
     * @param x
     * @param y
     * @return
     */
    public static int addNumber(int x, int y) {
        return 0;
    }

    public static void inverseArray(Object[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            Object temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    /**
     * 反转数组中某一段,begin和end为反转的下标范围
     * 例如array={1,2,3,4,5,6},reverse(array,1,4)后,array={1,5,4,3,2,6}
     * @param array
     * @param begin
     * @param end
     * @return
     */
    public static int[] reverse(int[] array, int begin, int end) {
        //判断参数下标是否越界
        if (begin < 0 || end > array.length - 1) return null;
        //定义同长度数组,用来存放
        int[] finalArr = new int[array.length];
        //存放第一段,0 ~ begin-1
        for (int i = 0; i < begin; i++) {
            finalArr[i] = array[i];
        }
        //存放第二段,begin ~ end
        int index = begin;
        for (int m = end; m >= begin; m--) {//反向遍历存放
            finalArr[index] = array[m];
            index++;
        }
        //存放第三段,end+1 ~ array.length-1
        for (int j = end + 1; j < array.length; j++) {
            finalArr[j] = array[j];
        }
        return finalArr;
    }

    /**
     * 数组打印
     * @param nums
     */
    public static void arrayBackPrint(int[][] nums) {
        if (nums == null) {
            throw new RuntimeException("invalid param");
        }
        if (nums.length == 0) {
            return;
        }
        int top = 0;
        int bottom = nums.length - 1;
        int left = 0;
        int right = nums[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(nums[top][i] + " ");
            }
            top++;
            if (top > bottom || left > right) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                System.out.print(nums[i][right] + " ");
            }
            right--;
            if (top > bottom || left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                System.out.print(nums[bottom][i] + " ");
            }
            bottom--;
            if (top > bottom || left > right) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                System.out.print(nums[i][left] + " ");
            }
            left++;
            System.out.println();
        }
    }

    public static void printlnArray(int[][] nums) {
        if (nums == null) {
            throw new RuntimeException("invalid param");
        }
        if (nums.length == 0) {
            return;
        }
        for (int[] num : nums) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(num[j] + " ");
            }
            System.out.println();
        }
    }

    public static void printCharTable() {
        for (int i = 'a'; i < 'z'; i++) {
            System.out.println((char) i + " = " + i + " " + (char) (i - 32) + " = " + (i - 32));
        }
    }

    public static <T> void printlnArray(T[] arr) {
        for (T t : arr) {
            System.out.println(t);
        }
    }

    public static void printAllSubString(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }
}
