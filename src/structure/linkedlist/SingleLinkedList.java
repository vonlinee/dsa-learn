package structure.linkedlist;

/**
 * 单链表
 */
public class SingleLinkedList {

    //第一个节点不存放数据或者存放一个无意义数据的叫带头节点链表，第一个节点直接存放第一个数据的叫不带头节点链表。

    // 头节点为空节点
    private Node head;

    public SingleLinkedList() {
        this.head = new Node(Integer.MIN_VALUE);
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            super();
            this.value = value;
        }
    }

    /**
     * 遍历链表
     * @param head
     */
    public void traverse(Node head) {
        for (Node current = head; current != null; current = current.next) {
            // 对链表节点的操作
            System.out.print(current.value + " ");
        }
        System.out.println();
    }

    // 要满足JVM可达性分析，不能导致头节点之后的被垃圾回收
    // 反转单链表
    public static Node reverse(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            // 每次都拆下一个节点让其变成头节点，然后将顺序遍历的节点作为其后继节点即可
            next = head.next;
            head.next = pre;
            pre = head;
            // 继续拆下一个节点
            head = next;
        }
        return pre;
    }

    /**
     * https://blog.csdn.net/alpgao/article/details/86509265
     * 将单向链表逆序输出，方法有三种：
     * a.遍历链表，将每个节点的内容存入一个数组中，然后逆序输出数组(最简单的做法)
     * b.使用栈来逆序输出
     * c.直接将链表逆序然后输出
     * d.尾递归
     * @param head
     */
    public static void showInReverseOrder(Node head) {
        System.out.println(valueToString(head, ""));
    }

    // 尾递归从后往前遍历
    public static String valueToString(Node head, String output) {
        // 刚开始会一直进到此分支，直到到达最后一个节点
        if (head == null) return output;
        // 当前节点拼在前面
        output = head.value + " " + output;
        return valueToString(head.next, output);
    }

    /**
     * 通过数组来构建链表
     * https://blog.csdn.net/lenfranky/article/details/89889884
     * @param nums
     * @return
     */
    public static Node create(int[] nums) {
        Node head = new Node(nums[0]);
        Node preNode = head;
        for (int i = 1; i < nums.length; i++) {
            preNode.next = new Node(nums[i]);
            preNode = preNode.next;
        }
        return head;
    }

    // 通过数组来构建链表
    public static Node constructList(int[] nums) {
        Node dummy = new Node(-1);
        Node preNode = dummy;
        for (int num : nums) {
            preNode.next = new Node(num);
            preNode = preNode.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6};
        Node node = constructList(nums);

        SingleLinkedList list = new SingleLinkedList();

        list.traverse(node);

        showInReverseOrder(node);
    }

}
