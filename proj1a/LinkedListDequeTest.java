/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
    public static void testAdd(){
        System.out.println("Testing add methods..");
        LinkedListDeque<Integer> dq = new LinkedListDeque<>();
        for(int i = 0; i<=10; i++){
            dq.addLast(i);
        }
        System.out.println("Expected output: 0 1 2 3 4 5 6 7 8 9 10");
        dq.printDeque();
    }

    public static void testRemove(){
        System.out.println("Testing remove methods...");
        LinkedListDeque<Integer> dq = new LinkedListDeque<>();
        dq.addLast(1);
        dq.addLast(2);
        System.out.println("Expected: 1");
        System.out.println(dq.removeFirst());
        dq.addLast(3);
        System.out.println("Expected: 2 3");
        dq.printDeque();
        System.out.println("Expected: 3\n" + dq.removeLast());
        System.out.println("Expected: 2");
        dq.printDeque();
    }


    public static void testGet(){
        System.out.println("Running testGet...");
        LinkedListDeque<Integer> dq  = new LinkedListDeque<>();
        dq.addLast(0);
        dq.addLast(1);
        dq.addFirst(-1);
        dq.addFirst(-2);
        System.out.println("Expected: -2\n" + dq.get(0));
        System.out.println("Expected: 0\n" + dq.get(2));
    }

    public static void main(String[] args) {
        testAdd();
        testRemove();
        testGet();
    }
} 