package question.leetcode.problem;

import question.leetcode.LeetCode;
import question.leetcode.LeetCode.ListNode;
import utils.Utils;

import java.util.Stack;

/**
 * 两数相加: https://leetcode.cn/problems/add-two-numbers/
 */
public class P2 {

    /**
     * 此方法有点问题：题目理解起来，即使溢出也是可以表示的，但是这么写溢出就表示不了
     * 比如：输入
     * [9]
     * [1,9,9,9,9,9,9,9,9,9]
     * 输出：[0,0,0,0,0,0,0,0,0,0,1]
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num1_string = getNumberAsString(l1);
        String num2_string = getNumberAsString(l2);
        // 判断数字是否溢出
        if (Utils.isOverflow(num1_string) || Utils.isOverflow(num2_string)) {
            return toList(0);
        }
        int num1 = Integer.parseInt(num1_string);
        int num2 = Integer.parseInt(num2_string);
        // 判断是否溢出
        if (isOverflow(num1, num2)) {
            return toList(0);
        }
        return toList(num1 + num2);
    }

    public boolean isOverflow(int x, int y) {
        int r = x + y;
        return ((x ^ r) & (y ^ r)) < 0;
    }

    private String getNumberAsString(ListNode head) {
        return getNumberAsString(head, "");
    }

    private ListNode toList(int num) {
        ListNode head = null;
        ListNode cur = null;
        while (true) {
            int i = num % 10;
            if (head == null) {
                head = new ListNode(i);
                cur = head;
            } else {
                cur.next = new ListNode(i);
                cur = cur.next;
            }
            int j = num / 10;
            if (j == 0) break;
            num = (num - i) / 10;
        }
        return head;
    }

    // 尾递归方式
    private String getNumberAsString(ListNode head, String num) {
        if (head == null) return num;
        // 如果后继节点为空，就返回当前节点的值
        // 因此当前节点是从尾部开始数的节点，将它拼在前面
        String number = getNumberAsString(head.next, String.valueOf(head.val));
        num = number + num; // 到尾节点时，num为空字符串，然后从尾节点开始拼接
        return num;
    }

    // 自己的解法：错误解法
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode itr1 = l1;
        ListNode itr2 = l2;
        boolean carry = false;
        // 结果
        ListNode head = null;

        while (true) {
            if (itr1 == null) {

            }
            // 从低位开始相加
            int i = carry ? itr1.val + itr2.val + 1 : itr1.val + itr2.val;
            // 前一位相加是否需要进位
            if (i > 10) {
                carry = true;
                i = i % 10;
            } else carry = false;
            // 结果行成链表
            if (head == null) {
                head = new ListNode(i);
            } else {
                head.next = new ListNode(i);
            }
            // 继续迭代
            itr1 = itr1.next;
            itr2 = itr2.next;
        }
        // 比较两个数字的长短
    }

    /**
     * 错误：题读错了
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode cur = l1;
        // 将链表逆序结果保存
        Stack<Integer> stack1 = new Stack<>();
        while (cur != null) {
            stack1.push(cur.val);
            cur = cur.next;
        }
        Stack<Integer> stack2 = new Stack<>();
        cur = l2;
        while (cur != null) {
            stack2.push(cur.val);
            cur = cur.next;
        }
        // 操作栈即可
        ListNode head = null;
        ListNode itr = null;
        boolean flag = false;
        // 其中一个栈空时退出
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            // 此时弹出的是低位
            Integer i1 = stack1.pop();
            Integer i2 = stack2.pop();
            // 低位数字相加
            int i = flag ? i1 + i2 + 1 : i1 + i2;
            if (i >= 10) {
                i = i % 10; // 需要向前进位
                flag = true;
            } else flag = false;
            if (head == null) {
                head = new ListNode(i);
                itr = head;
            } else {
                itr.next = new ListNode(i);
                itr = itr.next;
            }
        }
        if (itr == null) {
            return null;
        }
        // 同时为空
        if (stack1.isEmpty() && stack2.isEmpty()) {
            if (flag) itr.next = new ListNode(1);
            return head;
        }
        // 如果只有1个为空
        if (stack1.isEmpty()) {
            // 继续弹出不空的那个
            while (!stack2.isEmpty()) {
                int i = stack2.pop();
                // 低位数字相加
                int num = flag ? i + 1 : i;
                if (num >= 10) {
                    num = num % 10; // 需要向前进位
                    flag = true;
                } else flag = false;
                itr.next = new ListNode(num);
                itr = itr.next;
            }
        } else {
            // 继续弹出不空的那个
            while (!stack1.isEmpty()) {
                int i = stack1.pop();
                // 低位数字相加
                int num = flag ? i + 1 : i;
                if (num >= 10) {
                    num = num % 10; // 需要向前进位
                    flag = true;
                } else flag = false;
                itr.next = new ListNode(num);
                itr = itr.next;
            }
        }
        // 最后是否需要进位
        if (flag) itr.next = new ListNode(1);
        return head;
    }

    /**
     * 通过：从头节点开始按位相加即可，若有进位则向前进位
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        // 头节点代表低位
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        // 用于构成结果的链表
        ListNode head = null;
        ListNode node = null;
        int t; // 存储每位相加的值
        boolean flag = false;
        while (cur1 != null && cur2 != null) {
            // 相加
            t = flag ? cur1.val + cur2.val + 1 : cur1.val + cur2.val;
            // 判断是否进位
            if (t >= 10) {
                t = t % 10;
                flag = true;
            } else flag = false;
            // 初始化节点
            if (head == null) {
                head = new ListNode(t);
                node = head;
            } else {
                node.next = new ListNode(t);
                node = node.next;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if (node == null) return null;
        if (cur1 == null && cur2 == null) {
            if (flag) node.next = new ListNode(1);
            return head;
        }
        // 必然只有一个为null
        cur1 = cur2 == null ? cur1 : cur2;
        // 遍历链表2
        while (cur1 != null) {
            // 相加
            t = flag ? cur1.val + 1 : cur1.val;
            // 判断是否进位
            if (t >= 10) {
                t = t % 10;
                flag = true;
            } else flag = false;
            // 初始化节点
            node.next = new ListNode(t);
            node = node.next;
            cur1 = cur1.next;
        }
        // 当所有节点都加完了仍需要进位
        if (flag) node.next = new ListNode(1);
        return head;
    }

    /**
     * 别人的题解：很简洁
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers5(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), pre = dummyHead;
        int t = 0;
        // t != 0这个条件有必要的，如果不加t!=0的判断，那在两个链表长度相等但有进位的时候，结果链表的遍历就停止了
        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(t % 10);
            pre = pre.next;
            // 经过这部操作：t必然为0或1，因为每位数字相加的范围是[0, 18]
            t /= 10;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 9};
        int[] nums2 = {5, 6, 4, 9};

        ListNode head1 = LeetCode.create(nums1);
        ListNode head2 = LeetCode.create(nums2);

        P2 p2 = new P2();

        ListNode listNode = p2.addTwoNumbers4(head1, head2);

        LeetCode.traverse(listNode);
    }

    public static void test1() {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        P2 solution = new P2();
        String s = solution.getNumberAsString(listNode1);
        System.out.println(s);
        ListNode listNode = solution.toList(234);
        String s1 = solution.getNumberAsString(listNode);
        System.out.println(s1);
    }
}
