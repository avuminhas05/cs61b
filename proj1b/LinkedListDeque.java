public class LinkedListDeque<T> implements Deque<T> {

    private int size;
    private Node headNode;

    private class Node{
        public T item;
        public Node next;
        public Node prev;

        public Node(Node p, T itm, Node n) {
            item = itm;
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque(){
        size = 0;
        headNode = new Node(null, null, null);
        headNode.prev = headNode;
        headNode.next = headNode;
    }

    /* Add item to the front of list */
    @Override
    public void addFirst(T item){
        Node temp = new Node(headNode, item, headNode.next);
        headNode.next = temp;
        temp.next.prev = temp;
        size++;
    }

    /* Add item to the end of the list */
    @Override
    public void addLast(T item){
        Node temp = new Node(headNode.prev, item, headNode);
        headNode.prev = temp;
        temp.prev.next = temp;
        size++;
    }

    @Override
    public boolean isEmpty(){
        return size() == 0;
    }

    @Override
    public int size(){
        return size;
    }

    /* Print the entire list */
    @Override
    public void printDeque(){
        Node temp = headNode.next;
        while(temp != headNode){
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }

    /* Remove the first element and return it.
    * If no such item exist, returns null. */
    @Override
    public T removeFirst(){
        if(isEmpty()) return null;
        size--;
        Node temp = headNode.next;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        return temp.item;
    }

    /* Remove the last item and return it.
     * If no such item exist, returns null.
     */
    @Override
    public T removeLast(){
        if(isEmpty()) return null;
        size--;
        Node temp = headNode.prev;
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        return temp.item;
    }

    /* Returns the ith(index) item from the list.
     * If no such item exists, returns null.
     */
    @Override
    public T get(int index){
        int i = 0;
        Node temp = headNode.next;
        while(i < index && temp != null){
            temp = temp.next;
            i++;
        }
        if(temp == null) return null;
        return temp.item;
    }

    /* Same as get() method but different implementation */
    public T getRecursive(int index){
        return getRecursiveHelper(index, headNode.next);
    }
    /* Helper method for getRecursive() method */
    private T getRecursiveHelper(int index, Node head){
        if(head == null) return null;
        if(index == 0) return head.item;
        return getRecursiveHelper(index - 1, head.next);
    }
}
