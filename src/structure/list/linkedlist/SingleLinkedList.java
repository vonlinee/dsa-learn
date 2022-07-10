package structure.list.linkedlist;

/**
 * @author Evarb
 * @date 2021/10/12
 * @description
 **/
public class SingleLinkedList<T> {

    private SingleNode<T> root;
    private SingleNode<T> last;

    public SingleLinkedList(T value) {
        last = this.root = new SingleNode<>(value);
    }

    public void addLast(T value) {
        SingleNode<T> node = new SingleNode<>(value);
        last.next = node;
        last = node;
    }

    public void show() {
        SingleNode<T> next;
        if (root != null) {
            System.out.println(root);
            next = root.next;
            while (next != null) {
                System.out.println(next);
                next = next.next;
            }
        }
    }

    public static void main(String[] args) {


    }


}