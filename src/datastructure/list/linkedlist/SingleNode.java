package datastructure.list.linkedlist;

/**
 * @author Von
 * @createTime 2021-10-11 23:34
 * @description TODO
 * @since 1.8
 **/
public class SingleNode<T> {

    public T element;
    public SingleNode<T> next;

    public SingleNode(T element) {
        this.element = element;
    }
}
