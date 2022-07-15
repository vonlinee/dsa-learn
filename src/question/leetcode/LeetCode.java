package question.leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @since created on 2022年6月21日
 */
public abstract class LeetCode {

    /**
     * Leetcode通用的树结构
     */
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {}

        public TreeNode(int val) {this.val = val;}

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Leetcode通用的链表结构
     */
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {}

        public ListNode(int val) {this.val = val;}

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 构造一棵树
     * @param nums
     * @return
     */
    public static TreeNode createTree(Integer[] nums) {
        if (nums.length == 0) return new TreeNode(0);
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        // 创建一个根节点
        TreeNode root = new TreeNode(nums[0]);
        nodeQueue.offer(root);
        TreeNode cur;
        // 记录当前行节点的数量（注意不一定是2的幂，而是上一行中非空节点的数量乘2）
        int lineNodeNum = 2;
        // 记录当前行中数字在数组中的开始位置
        int startIndex = 1;
        // 记录数组中剩余的元素的数量
        int restLength = nums.length - 1;
        while (restLength > 0) {
            // 只有最后一行可以不满，其余行必须是满的
            // 若输入的数组的数量是错误的，直接跳出程序
            //if (restLength < lineNodeNum) {
            //    System.out.println("Wrong Input!");
            //    return new TreeNode(0);
            //}
            for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2) {
                // 说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i == nums.length) return root;
                cur = nodeQueue.poll();
                if (nums[i] != null) {
                    cur.left = new TreeNode(nums[i]);
                    nodeQueue.offer(cur.left);
                }
                // 同上，说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i + 1 == nums.length) return root;
                if (nums[i + 1] != null) {
                    cur.right = new TreeNode(nums[i + 1]);
                    nodeQueue.offer(cur.right);
                }
            }
            startIndex += lineNodeNum;
            restLength -= lineNodeNum;
            lineNodeNum = nodeQueue.size() * 2;
        }

        return root;
    }

    public static void showTree(TreeNode root) {
        if (root != null) {

        }
    }

    public static ListNode create(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode preNode = head;
        for (int i = 1; i < nums.length; i++) {
            preNode.next = new ListNode(nums[i]);
            preNode = preNode.next;
        }
        return head;
    }

    /**
     * 遍历链表
     * @param head
     */
    public static void traverse(ListNode head) {
        for (ListNode current = head; current != null; current = current.next) {
            // 对链表节点的操作
            System.out.print(current.val + " ");
        }
        System.out.println();
    }

    /**
     * \t 是补全（8-前面字符的位数%8）的距离，也就是说前面有1个字符那么在1个字符后输出一个\t,则\t的长度为7个字符长度
     * <p>
     * 将整形的二进制打印出来
     * @param num 整形是32位无符号数， long是64位的
     */
    public static void printlnBits(int num) {
        for (int i = 31; i > 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println(" [" + num + "]");
    }

    public static int[] randomIntArray(int maxLen, int maxValue) {
        return randomIntArray(maxLen, maxValue, true, false);
    }

    // 随机数组：长度随机，值随机
    public static int[] randomIntArray(int maxLen, int maxValue, boolean fixedLength) {
        return randomIntArray(maxLen, maxValue, true, fixedLength);
    }

    // 随机数组：长度随机，值随机
    public static int[] randomIntArray(int maxLen, int maxValue, boolean allowRepeatableValue, boolean fixedLength) {
        if (maxLen < 1) {
            maxLen = 1;
        }
        // 长度随机
        // 产生[0, maxLen)范围的随机数，再强转成整数
        int len = fixedLength ? maxLen : (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (allowRepeatableValue) {
            for (int i = 0; i < len; i++) {
                arr[i] = (int) (Math.random() * maxValue);
            }
        } else {
            // 产生不重复的数组值
            if (maxValue < maxLen) {
                throw new RuntimeException("[0, " + maxValue + "]的不重复整数值不足" + maxLen + "个！");
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < len; i++) {
                while (!set.add((int) (Math.random() * maxValue))) {
                    // 重复添加
                    System.out.println("重复添加");
                }
            }
            Iterator<Integer> it = set.iterator();
            int i = -1;
            while (it.hasNext()) {
                Integer type = it.next();
                arr[++i] = type;
            }
        }
        return arr;
    }

    /*
     * 判断数组中是否有重复的值
     */
    public static boolean cheakIsRepeat(int[] array) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }
        return hashSet.size() == array.length;
    }

    // 拷贝数组
    public static int[] copyArray(final int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    // 保证输入参数是等长的
    // 验证两个数组是否值相等
    public static boolean arrayEquals(final int[] arr1, final int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // 找到给定变量 的二进制等价物
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 此方法其实是没用的，因为Java的值传递
     * @param x
     * @param y
     */
    public static void swap(int x, int y) {
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
    }

    public static void printlnArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static int[] parseInt(String[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        return arr;
    }

    public static Integer[] valueOf(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }

    public static Integer[] valueOf(String[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.valueOf(nums[i]);
        }
        return arr;
    }
}
