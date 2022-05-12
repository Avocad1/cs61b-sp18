public class LinkedListDeque<T> {
    private class StuffNode {
        private T item;
        private StuffNode prev;
        private StuffNode next;

        StuffNode(StuffNode p, T i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private int size;
    private StuffNode sentinel;

    /** Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        StuffNode thenode = new StuffNode(sentinel, item, sentinel.next);
        sentinel.next.prev = thenode;
        sentinel.next = thenode;
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        StuffNode thenode = new StuffNode(sentinel.prev, item, sentinel);
        sentinel.prev.next = thenode;
        sentinel.prev = thenode;
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
        for (StuffNode i = sentinel.next; i != sentinel; i = i.next) {
            if (i.next == sentinel) {
                System.out.println(i.item);
                break;
            }
            System.out.print(i.item + " ");
        }
    }

    /** Removes and returns the item at the front of the deque.
    * If no such item exists, returns null. */
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        } else {
            T removedItem = sentinel.next.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return removedItem;
        }
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null. */
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        } else {
            T removedItem = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size -= 1;
            return removedItem;
        }
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null. Must not alter the deque! */
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        StuffNode N = sentinel.next;
        for (int i = 0; i < index; i++) {
            N = N.next;
        }
        return N.item;
    }

    /** Same as get, but uses recursion. */
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        StuffNode newreN = sentinel;
        return getRecursivehelper(index, newreN);
    }

    private T getRecursivehelper(int index, StuffNode N) {
        if (index == 0) {
            return N.item;
        } else {
            return getRecursivehelper(index - 1, N.next);
        }
    }

}
