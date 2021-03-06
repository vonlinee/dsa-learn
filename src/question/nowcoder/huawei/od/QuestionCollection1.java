package question.nowcoder.huawei.od;

import utils.Utils;

import java.util.*;

/**
 * 华为机试23题总结
 * https://blog.csdn.net/u013598405/article/details/114239804?ops_request_misc=&request_id=&biz_id=102&utm_term=%E5%A4%AA%E9%98%B3%E8%83%BD%E6%9D%BF%E6%9C%80%E5%A4%A7%E9%9D%A2%E7%A7%AF&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-6-114239804.nonecase&spm=1018.2226.3001.4187
 */
public class QuestionCollection1 {

    // 如果三个正整数A B C满足A²+B²=C²则为勾股数
    // 如果ABC之间两两互质，即A与B A与C B与C均互质没有公约数，则称其为勾股数元组。
    //  请求出给定n m 范围内所有的勾股数元组
    //   输入描述：起始范围 1<n<10000    n<m<10000
    //   输出描述：a b c 保证a<b<c输出格式  a b c
    //   多组勾股数元组 按照a升序b升序 c升序的排序方式输出。
    //    定范围内，找不到勾股数元组时，输出 Na
    public void question1(int m, int n) {
        // a, b互质，即a和b的公约数==1
        // 这里用阿基里德算法（辗转相除法），递归方式，如果最后结果==1，表示a,b 互质
        int count = 0;
        for (int i = n; i < m; i++) {
            for (int j = n + 1; j < m; j++) {
                for (int k = j + 1; k <= m; k++) {
                    if (i < j && j < k && (i * i + j * j == k * k) && gcd(i, j) == 1 && gcd(j, k) == 1 && gcd(i, k) == 1) {
                        System.out.println(i + "," + j + "," + k);
                        count++;
                    }
                }
            }
        }
        if (0 == count) System.out.println("Na");
    }

    public static int gcd(int a, int b) {
        if (0 == b) return a;
        return gcd(b, a % b);
    }

    /**
     * 整数对最小和
     */
    // 给定两个整数数组 array1 array2  数组元素按升序排列, 假设从arr1 arr2中分别取出一个元素，可构成一对元素
    // 现在需要取出k对元素，并对取出的所有元素求和,计算和的最小值
    // 注意：两对元素对应arr1 arr2的下标是相同的,视为同一对元素，比如1 2和2 1
    // 输入描述：输入两行数组arr1 arr2，每行首个数字为数组大小size   0<size<=100
    //    第二行arr1，2中的每个元素   0< <1000
    //    接下来一行  正整数k   0<k<=arr1.size * arr2.size
    // 输出描述：满足要求的最小值
    public void question2(int[] arr1, int[] arr2, int k) {
        // 计算两个数组任意两两组合的和
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int i1 = 0; i1 < arr2.length; i1++) {
                System.out.println(i + " + " + i1 + " = " + (arr1[i] + arr2[i1]));
                list.add(arr1[i] + arr2[i1]);
            }
        }
        // 升序排序
        Collections.sort(list);
        // 加上前面k个和的结果即可
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }

    /* n 阶方阵和
       给出n阶方阵里所有数，求方阵里所有数的和
       输入描述：输入有多个测试用例，每个测试用例第一个整数n（n<=1000） 表示方阵阶数为n，接下来是n行的数字，每行n个数字用空格隔开
       输出描述：输出一个整数表示n阶方阵的和
       例子：输入
              3
              1 2 3
              2 1 3
              3 2 1
          输出
              18
    */
    public void question3() {
        Scanner sc = new Scanner(System.in);
        // 阶数
        int num = Integer.parseInt(sc.nextLine());
        //int num = sc.nextInt();//这样写的话，下面 sum+那一行会报错 For input string: ""
        int sum = 0;
        for (int j = 0; j < num; j++) {
            String line = sc.nextLine();
            String[] rowNums = line.split("\\s+");
            for (int i = 0; i < rowNums.length; i++) {
                if ("".equals(rowNums[i])) continue;
                sum += Integer.parseInt(rowNums[i].trim());
            }
        }
        System.out.println("sum = " + sum);
    }

    /**
     * TLV解码
     * TLV编码是按 Tag Length Value格式进行编码的一段码流中的信元用tag标识，tag在码流中唯一不重复
     * length表示信元value的长度  value表示信元的值, 码流以某信元的tag开头 ，tag固定占一个字节
     * length固定占两个字节，字节序为小端序, 现给定tlv格式编码的码流以及需要解码的信元tag
     * 请输出该信元的value
     * <p>
     * 大端序：高位字节存入低地址，低位字节存入高地址，例如01 00表示10进制的1，注意：1字节表示为16进制有2个字符
     * 小端序：低位字节存入低地址，高位字节存入高地址，例如01 00表示10进制的4，注意：1字节表示为16进制有2个字符
     * <p>
     * 输入码流的16机制字符中，不包括小写字母，且要求输出的16进制字符串中也不要包含字符字母
     * 码流字符串的最大长度不超过50000个字节
     * <p>
     * 输入描述
     * 第一行为第一个字符串 ，表示待解码信元的tag
     * 输入第二行为一个字符串， 表示待解码的16进制码流 字节之间用空格分割
     * 输出描述
     * 输出一个字符串，表示待解码信元以16进制表示的value
     */
    public void question4() {

    }

    /**
     * 未完成
     * 猴子跳台阶 1级和3级（递归的循环写法）
     * labuladong 书上有提到，大概画了个图，但是尚未完全搞明白
     * 一天一只顽猴想要从山脚爬到山顶，途中经过一个有n个台阶的阶梯，但是这个猴子有个习惯，每一次只跳1步或3步
     * 试问猴子通过这个阶梯有多少种不同的跳跃方式
     * 输入描述：
     * 输入只有一个这个数n，其中0<n<50，表示此阶梯有多个台阶
     * 输出描述：有多少种跳跃方式
     */
    public void question5(int n) {
        int[] dp = new int[n];
        // 基础条件 Base Case
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2; // 跳到第三级阶梯：连跳3次1，或者直接跳1次3
        // 递推公式
        // dp[n] = dp[n-3] + dp[n-1] + dp[n-2]
        for (int i = 4; i < n; i++) {
            dp[i - 1] = dp[i - 4] + dp[i - 2];
            dp[i] = dp[i - 1];
        }
        System.out.printf("猴子跳到%s级阶梯共有%s种方式\n", n, dp[n - 1]);
    }

    public void question6(int n) {

    }

    /**
     * 区间字符串倒转输出
     * <p>
     * 输入一个英文文章片段，翻转指定区域的单词顺序，标点符号和普通字母一样处理
     * 例如输入字符串 I am a developer. [0,3]， 则输出 developer. a am I
     * <p>
     * 输入描述
     * 使用换行隔开3个参数
     * 第一个参数为文章内容 即英文字符串
     * 第二个参数为翻转起始单词下标，下标从0开始
     * 第三个参数为结束单词下标
     * 输出描述
     * 翻转后英文文章片段每个单词之间以一个半角空格分割输出
     * <p>
     * 输入字符串可以在前面或者后面包含多个空格
     * 但是翻转后的字符不能包括
     * <p>
     * 指定反转区间只有一个单词或无有效单词，则输出EMPTY
     */
    public void question8() {
        // 输入
        String sentence = "I am a developer.";
        int start = 0;
        int end = 3;
        //
        String[] words = sentence.split(" ");
        for (int i = start; i <= end; i++) {
            String temp = words[i];
        }
        // 使用栈进行翻转
    }

    /*
        双11众多商品进行打折销售，小明想购买一些自己心意的商品
        但由于受购买资金限制，所以他决定从众多心意商品中购买3件
        而且想尽可能的花完资金
        现在请你设计一个程序帮助小明计算尽可能花费的最大资金额

        输入描述: 第一行为整型数组M 数组长度小于100 数组元素记录单个商品的价格, 单个商品价格<1000
        第二行输入为购买资金的额度R, R<100000
        输出描述: 输出为满足上述条件的最大花费额度，如果不存在满足上述条件的商品请返回-1

        例子1
        输入
         23,26,36,27
         78
        输出
         76
        例子2
            输入
             23,30,40
             26
            输出
              -1
        备注：输入格式正确
    */
    public void question9(int[] prices, int r) {
        // dp[i][0]表示不购买prices[i]还剩的钱
        int[][] dp = new int[prices.length][2];

    }

    /*
           喊7 是一个传统的聚会游戏
           N个人围成一圈
           按顺时针从1-7编号
           编号为1的人从1开始喊数
           下一个人喊得数字是上一个人喊得数字+1
           但是当将要喊出数字7的倍数或者含有7的话
           不能喊出 而是要喊过

           假定N个人都没有失误。
           当喊道数字k时
           可以统计每个人喊 “过"的次数

           现给定一个长度n的数组
           存储打乱的每个人喊”过"的次数
           请把它还原成正确顺序

           即数组的第i个元素存储编号i的人喊“过“的次数

              输入为1行
              空格分割的喊过的次数
              注意k并不提供

              k不超过200
              数字个数为n
              输出描述

              输出为1行
              顺序正确的喊过的次数  空格分割

              例子
              输入
                0 1 0
              输出
                1 0 0

              只有一次过
              发生在7
              按顺序编号1的人遇到7  所以100
              结束时的k不一定是7 也可以是 8 9
                喊过都是100

                例子
              输入
                0 0 0 2 1
              输出
                0 2 0 1 0
              一共三次喊过
              发生在7 14 17
              编号为2 的遇到7 17
              编号为4 的遇到14
            */
    public void question18(int[] nums) {
        // 有几个人
        int N = nums.length;
        // k不超过200，所以只有报数
        // 1.肯定是编号在前的喊到的次数更多

        // 找到最大的喊到的次数

        int sum = Utils.sum(nums);
        System.out.println("喊到的总次数 = " + sum);
        // 喊到的总次数
        int totalNum = 0;
        // 从1开始报数
        int num = 1;
        while (true) {
            if (contains7(num)) {
                System.out.println(num);
                totalNum++;
            }
            if (totalNum == sum) {
                System.out.println("最后喊到报的数字 = " + num);
                break;
            }
            num++;
        }
        // 此时的num为喊到结束的最低次数，最低报数
        System.out.println("最终报的数 = " + num);
        // 然后模拟喊到
        int[] arr = new int[N];

        // i表示每次报的数
        for (int i = 1; i <= num; i++) {
            if (contains7(i)) {
                // 喊到次数加1
                System.out.println("喊到: " + i + "  " + i % N);
                // 因为是从1开始报数，但是数组下标最低是0，因此要减少1
                // 同时 i % N - 1不可能小于0
                arr[i % N - 1]++;
            }
        }

        // 拼上arr的结果即可
        StringBuilder s = new StringBuilder();
        for (int j : arr) {
            s.append(j).append(" ");
        }
        System.out.println(s);
    }

    public boolean contains7(int n) {
        // 数字7的倍数
        if (n % 7 == 0) return true;
        //或者含有7的话
        while (n != 0) {
            int i = n % 10;
            if (i == 7) return true;
            n = n / 10;
        }
        return false;
    }

    /**
     * 【字符统计及重排】给出一个仅包含字母的字符串，不包含空格，统计字符串中各个字母(区分大小写)出现的次数，并按照字母出现次数从大到小的顺序输出各个字母及
     * 其出现次数。如果次数相同，按照自然顺序进行排序，且小写字母在大写字母之前。
     * 输入描述:
     * 输入一行，为一个仅包含字母的字符串。
     * 输出描述:
     * 按照字母出现次数从大到小的顺序输出各个字母和字母次数，用英文分号分隔，注意末尾的分号;字母和次数间用英文冒号分隔。
     * 示例1:
     * 输入
     * xyxyXX
     * 输出
     * x:2;y:2;X:2;
     * @param str
     */
    public void question20(String str) {
        char[] chars = str.toCharArray();

        // 统计字母个数
        int[] arr = new int[52];
        for (int i = 0; i < chars.length; i++) {
            if ('a' <= chars[i] && chars[i] <= 'z') {
                arr[chars[i] - 'a']++;
                continue;
            }
            if ('A' <= chars[i] && chars[i] <= 'Z') {
                arr[chars[i] - 'A' + 26]++;
            }
        }
        // 降序排序
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            char c = 0;
            if (i < 26) {
                c = (char) (i + 'a');
            } else {
                c = (char) (i + 'A' - 26);
            }
            System.out.println(c + ":" + arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 0, 0, 2, 1};
        int[] arr2 = {3, 1, 2, 3};
        int k = 2;
        QuestionCollection1 solution = new QuestionCollection1();
        // solution.question18(arr1);

        solution.question20("xyxyXX");

        Utils.printCharTable();
    }
}
