package question.nowcoder.huawei.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 服务器广播：https://blog.csdn.net/liudaxia1990/article/details/104977525
 * <p>
 * Java版本：
 * https://blog.csdn.net/weixin_44052055/article/details/124148459?spm=1001.2101.3001.6650.3&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-3-124148459-blog-104977525.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-3-124148459-blog-104977525.pc_relevant_default&utm_relevant_index=5
 * @author vonline
 * @since 2022-07-14 18:04
 */
public class ServerBroadcast {

    //题目描述：
    //服务器连接方式包括直接相连，间接连接。A 和 B 直接连接，B 和 C 直接连接，则 A 和 C 间接连接。直接连接和间接连接都可以发送广播。
    //
    //给出一个 N*N 数组，代表 N 个服务器，matrix[i][j]==1，则代表 i 和 j 直接连接；
    //不等于 1 时，代表 i 和 j 不直接连接。
    //matrix[i][i]==1，即自己和自己直接连接。matrix[i][j]==matrix[j][i]。
    //计算初始需要给几台服务器广播，才可以使每个服务器都收到广播。
    //
    //输入描述
    //输入为N行，每行有N个数字，为0或1，由空格分隔，构成N*N的数组，N的范围为 1<=N<=50
    //
    //输出描述
    //输出一个数字，为需要广播的服务器数量

    // 输入  1 0 0
    //      0 1 0
    //      0 0 1
    // 输出：3 3台服务器互不连接，所以需要分别广播这3台服务器

    // 输入：1 1
    //      1 1
    // 输出1：2台服务器相互连接，所以只需要广播其中一台服务器

    public int boradcast(int[][] nums) {
        // N台服务器
        int N = nums.length;

        // 每个list存放互相联通的服务器列表
        List<List<Integer>> res = new ArrayList<>(); // 存储需要广播的服务器

        for (int i = 0; i < N; i++) {
            // 统计和i直连的有哪些
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (nums[i][j] == 1) {
                    // i和j直连
                    nums[i][i]++;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            // 解析输入
            String[] str = in.nextLine().split(" ");
            List<Integer> list = new ArrayList<>();
            for (String value : str) {  // 把第一行加入list
                list.add(Integer.parseInt(value));
            }
            for (int i = 0; i < str.length - 1; i++) {  // 把剩下的行都加入list
                String[] s = in.nextLine().split(" ");
                for (String value : s) {
                    list.add(Integer.parseInt(value));
                }
            }
            // 主体逻辑
            int N = str.length;
            List<List<Integer>> res = new ArrayList<>(); // 存储需要广播的服务器
            for (int i = 0; i < N; i++) {  // 每一行
                if (isContainer(res, i)) {  // 判断某个服务器是否已经存在其连通的服务器集合中
                    continue;
                }
                // 一个list代表联通的服务器
                // 比如 1-2-3，
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                int lastLength = 0;
                while (lastLength != newList.size()) { // 判断当前集合可以联通的服务器
                    for (int k = 0; k < newList.size(); k++) {
                        // x是代表某个服务器的编号：0-N
                        int x = newList.get(k);
                        for (int j = 0; j < N; j++) {
                            // list就是输入的二维数组，只不过这里是以一维数组来存的
                            int index = x * (N) + j;  // 找到在对应list的索引
                            // == 表示连接
                            if (list.get(index).equals(1)) {
                                if (!newList.contains(j)) {
                                    newList.add(j);
                                }
                            }
                        }
                    }
                    lastLength = newList.size();
                    System.out.println(lastLength + " " + newList.size());
                }
                res.add(newList);
            }
            System.out.println(res.size());
        }
    }

    public static Boolean isContainer(List<List<Integer>> res, int x) {
        for (List<Integer> integers : res) {
            if (integers.contains(x)) {
                return true;
            }
        }
        return false;
    }
}
