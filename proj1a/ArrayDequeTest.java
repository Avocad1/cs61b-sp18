public class ArrayDequeTest {
    /** Test ArrayDeque */
    public static void main(String[] args){
        ArrayDeque<Integer> a1 = new ArrayDeque<>();
        a1.addFirst(1);
        a1.addFirst(2);
        a1.addFirst(3);
        a1.addFirst(4);
        a1.addFirst(5);
        a1.addFirst(6);
        a1.addFirst(7);
        a1.addFirst(8);
        a1.size();
        a1.printDeque();
        a1.removeFirst();
        a1.removeFirst();
        a1.removeFirst();
        a1.removeLast();
        a1.removeLast();
        a1.removeLast();
        a1.get(3);
        a1.get(4);
        a1.removeLast();
        a1.removeLast();
        a1.isEmpty();
    }
}
