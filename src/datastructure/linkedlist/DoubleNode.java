package datastructure.linkedlist;

/**
 * @author Von
 * @createTime 2021-10-11 23:37
 * @description 双向链表节点
 * @since 1.8
 **/
public class DoubleNode<T> {
    public T element;
    public DoubleNode<T> previous;
    public DoubleNode<T> next;

    public DoubleNode(T element) {
        this.element = element;
    }
}
