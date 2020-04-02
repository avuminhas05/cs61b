public class ArrayDequeTest {

    public static void testAdd(){
        System.out.println("Testing add methods..");
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i<=10; i++){
            dq.addLast(i);
        }
        System.out.println("Expected output: 0 1 2 3 4 5 6 7 8 9 10");
        dq.printDeque();
    }

    public static void testRemove(){
        System.out.println("Testing remove methods...");
        ArrayDeque<Integer> dq = new ArrayDeque<>();
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

    public static void testUpdateSize(){
        System.out.println("testing updateSize/resize method...");
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < 9; i++){
            dq.addLast(i);
        }
        System.out.println("Expected: 16\n" + dq.getLength());
        for(int i = 9; i < 17; i++){
            dq.addLast(i);
        }
        System.out.println("Expected: 32\n" + dq.getLength());
        dq.removeFirst();
        dq.removeFirst();
        dq.removeFirst();
        System.out.println("Expected: 16\n" + dq.getLength());

    }

    public static void main(String[] args) {
        testAdd();
        testRemove();
        testUpdateSize();
    }
}
