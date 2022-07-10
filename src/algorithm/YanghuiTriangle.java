package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xncfnv/
 * <p>
 * 杨辉三角，是二项式系数在三角形中的一种几何排列
 * 百度百科：https://baike.baidu.com/item/%E6%9D%A8%E8%BE%89%E4%B8%89%E8%A7%92/215098?fr=aladdin
 */
public class YanghuiTriangle {

    public void generate(int numRows) {
        if (numRows < 2) {
            System.out.println("行数需要大与或等于2");
        }
        int[] firstRow = {};
        yanghui(firstRow, numRows);
    }

    // 递归
    public void yanghui(int[] lastRow, int numRows) {
        // 终止条件
        if (numRows == 0) {
            return;
        }
        int len = lastRow.length;
        int[] currentRow = new int[len + 1];
        if (len == 0) { // 第一行
            currentRow[0] = 1;
        } else {
            currentRow[0] = currentRow[len] = 1;
            // 下一行由上一行计算得到
            for (int i = 0; i < len - 1; i++) {
                currentRow[i + 1] = lastRow[i] + lastRow[i + 1];
            }
        }
        // 得到结果并操作
        System.out.println(Arrays.toString(currentRow));
        yanghui(currentRow, numRows - 1);
    }

    public void yanghuiInList(Integer[] lastRow, int numRows, List<List<Integer>> rows) {
        // 终止条件
        if (numRows == 0) {
            return;
        }
        int len = lastRow.length;
        Integer[] currentRow = new Integer[len + 1];
        if (len == 0) { // 第一行
            currentRow[0] = 1;
        } else {
            currentRow[0] = currentRow[len] = 1;
            // 下一行由上一行计算得到
            for (int i = 0; i < len - 1; i++) {
                currentRow[i + 1] = lastRow[i] + lastRow[i + 1];
            }
        }
        // 得到结果并操作
        rows.add(Arrays.asList(currentRow));
        yanghuiInList(currentRow, numRows - 1, rows);
    }

    // 非递归版本
    public static List<List<Integer>> generate_1(int numRows) {
        //结果值
        List<List<Integer>> res = new ArrayList<>();
        //每一行的元素
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            //下面一行都会比上面一行多一个元素，我们在第一个位置给他加个1
            row.add(0, 1);
            //遍历每一行的结果，遍历的时候跳过第一个和最后一个，
            //每个格子的值都是他正上面和左上角元素的和
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            //把结果存放到res中
            res.add(new ArrayList<>(row));
        }
        return res;
    }

    public static void main(String[] args) {
        YanghuiTriangle solution = new YanghuiTriangle();

        solution.generate(10);

    }
}
