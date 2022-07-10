package structure.tree.bintree;

public class BinTreeNode<T> {

    public T element;
    public BinTreeNode<T> left;
    public BinTreeNode<T> right;

    public BinTreeNode(T element) {
        this.element = element;
    }
}
