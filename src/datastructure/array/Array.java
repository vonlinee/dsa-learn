package datastructure.array;

/**
 * @author Von
 * @createTime 2021-10-11 23:50
 * @description TODO
 * @since 1.8
 **/
public class Array<T> {

    private T[] elements;
    private int index;
    private int size;

    @SuppressWarnings("unchecked")
    public Array(int initialCapacity) {
        this.elements = (T[]) new Object[initialCapacity];
    }

    public void add(T element) {
        this.elements[index] = element;
        index++;
        ensureCapacity();
    }

    /**
     * 确保数组不会出现越界
     */
    private void ensureCapacity() {
        this.size++;
    }

    public final int size() {
        return size;
    }
}
