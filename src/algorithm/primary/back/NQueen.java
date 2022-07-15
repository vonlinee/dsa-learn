package algorithm.back;

/**
 * N皇后问题
 */
public class NQueen {

    /**
     * 回溯算法实际上一个类似枚举的搜索尝试过程，主要是在搜索尝试过程中寻找问题的解，当发现已不满足求解条件时，就“回溯”返回，尝试别的路径。
     * @param N
     */
    public void queen(int N) {
        // N x N 的数组存储皇后的摆放位置信息
        int[] arr = new int[N];

        // 每行放一个

    }

    // 检测放第n个皇后是否冲突
    public boolean isConflicted(int[] arr, int n) {
        for (int i = 0; i < n; i++) {

        }
        return false;
    }

}
