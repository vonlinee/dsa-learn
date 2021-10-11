package datastructure.tree.binarytree;

/**
 * @author Von
 * @createTime 2021-10-11 23:29
 * @description TODO
 * @since 1.8
 **/
public class BinaryTreeNode<T> {

    public T element;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T element) {
        this.element = element;
    }
}
