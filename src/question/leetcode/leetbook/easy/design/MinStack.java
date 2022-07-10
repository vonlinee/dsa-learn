package question.leetcode.leetbook.easy.design;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnkq37/
 */
public class MinStack {

    private int minValueIndex;

    // 第一个元素表示栈底
    int[] elements;
    int index;

    public MinStack() {
        this.elements = new int[10];
    }

    public void push(int val) {
        if (index == elements.length) {
            // 扩容
            resize();
        }
        elements[++index] = val;
    }

    private void resize() {

    }

    public void pop() {
        elements[index] = 0;
    }

    public int top() {
        return 1;
    }

    public int getMin() {
        return 1;
    }

}
