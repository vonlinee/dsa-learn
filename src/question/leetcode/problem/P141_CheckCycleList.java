package question.leetcode.problem;

import question.leetcode.LeetCode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表: https://leetcode.cn/problems/linked-list-cycle/s
 * <p>
 * <p>
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnwzei/
 */
public class P141_CheckCycleList {

    public static void main(String[] args) {
        P141_CheckCycleList p = new P141_CheckCycleList();
        int[] nums = {3, 2, 0, -4};
        ListNode head = createCycle(nums, 1);

        System.out.println(p.hasCycle(head));
    }

    /**
     * 创建带有环形链表的链表
     * @param nums
     * @param pos
     * @return
     */
    public static ListNode createCycle(int[] nums, int pos) {
        ListNode head = new ListNode(nums[0]);
        ListNode preNode = head;
        ListNode node = null;
        for (int i = 1; i < nums.length - 1; i++) {
            preNode.next = new ListNode(nums[i]);
            // 记录成环的起始节点
            if (pos == i) {
                node = preNode.next;
            }
            preNode = preNode.next;
        }
        // 环形链表的头节点为原链表的头节点
        if (node == null) node = head;
        // 尾节点 - 成环
        preNode.next = new ListNode(nums[nums.length - 1]);
        preNode = preNode.next;
        preNode.next = node;
        return head;
    }

    /**
     * 通过：快慢指针
     * 就像时针和分针总会重叠
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            // 为null只可能是到达尾节点，循环里fast肯定不为null
            if (fast.next == null) return false;
            fast = fast.next.next;
            // 如果快慢指针相等，表明有环
            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * 利用Set去重的特点进行判断
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        ListNode node = head;
        Set<ListNode> set = new HashSet<>();
        while (node != null) {
            if (!set.add(node)) return true;
            node = node.next;
        }
        return false;
    }

}
