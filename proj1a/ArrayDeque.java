public class ArrayDeque<T> {

    private T[] items;
    private int capacity;
    private int size;
    private int pointer;
    private int nextFirst;
    private int nextLast;

    //         0 1  2 3 4 5 6 7
    // items: [6 9 -1 2 0 0 0 0 ...]
    // size: 5

    /** Creates an empty array deque. */
    public ArrayDeque() {
        capacity = 8;
        items = (T[]) new Object[capacity];
        size = 0;
        pointer = 0;
        nextFirst = capacity - 1;
        nextLast = capacity - 2;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        if (nextFirst == capacity) {
            nextFirst = 0;
            while (items[nextFirst] != null) {
                nextFirst += 1;
            }
        }
        items[nextFirst] = item;
        nextFirst = nextFirst + 1;
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = nextLast - 1;
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return this.size;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        int k = 0;
        for (int i = 0; i < capacity; i += 1) {
            if (items[i] != null) {
                k += 1;
                if (k == size) {
                    System.out.println(items[i]);
                }
                System.out.print(items[i] + " ");
            }
        }
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    public T removeFirst() {
        for (int i = 0; i < capacity; i += 1) {
            if (items[i] != null) {
                T removedT = items[i];
                items[i] = null;
                nextFirst = i;
                size -= 1;
                return removedT;
            }
        }
        return null;
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null. */
    public T removeLast() {
        for (int i = capacity - 1; i >= 0; i -= 1) {
            if (items[i] != null) {
                T removedT = items[i];
                items[i] = null;
                nextLast = i;
                size -= 1;
                return removedT;
            }
        }
        return null;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null. Must not alter the deque! */
    public T get(int index) {
        if (items[index] != null) {
            return items[index];
        } else {
            return null;
        }
    }

}
