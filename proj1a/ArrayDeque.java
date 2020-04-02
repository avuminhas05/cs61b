
public class ArrayDeque<T>{

    private T[] arr;
    private int size;
    private int front;
    private int tail;

    public ArrayDeque(){
        arr = (T[])new Object[8];
        size =  0;
        front = 0;
        tail = 0;
    }

    /* Adds and item of type T to the front of the deque */
    public void addFirst(T item){
        updateSize();
        arr[front] = item;
        if(front == 0)
            front = arr.length - 1;
        else
            front = front - 1;
        size++;
    }

    /* Adds and item of type T to the back of the deque */
    public void addLast(T item){
        updateSize();
        tail = (tail + 1) % arr.length;
        arr[tail] = item;
        size++;
    }

    /* Returns true if deque is empty, false otherwise */
    public boolean isEmpty(){
        return size() == 0;
    }

    /* Returns the number of items in the deque */
    public int size(){
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space. */
    public void printDeque(){
        if(isEmpty()) return;
        int num = size();
        int temp = (front+1)%arr.length;
        while(num != 0){
            System.out.print(arr[temp] + " ");
            temp = (temp + 1) % arr.length;
            num--;
        }
        System.out.print("\n");
    }

    /* Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public T removeFirst(){
        updateSize();
        if(isEmpty())
            return null;
        size--;
        front = (front + 1) % arr.length;
        return arr[front];
    }

    /*Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public T removeLast(){
        updateSize();
        if(isEmpty())
            return null;
        size--;
        T item = arr[tail];
        if(tail == 0)
            tail = arr.length - 1;
        else
            tail--;
        return item;
    }

    /* Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index){
        if(index >= size())
            return null;
        return arr[(front + index + 1) % arr.length];
    }

    private boolean isFull(){
        return size() == arr.length;
    }

    /* Update the size of array if more space needed or need to free some memory */
    private void updateSize(){
        if(isFull())
            resize(arr.length * 2);
        else if(arr.length > 16 && (size() < arr.length/2))
            resize(arr.length/2);
    }

    /* Resize the length of array to the given size */
    private void resize(int newSize){
        T[] newArr = (T[])new Object[newSize];
        for(int i = 0; i < size(); i++){
            front = (front + 1) % arr.length;
            newArr[i] = arr[front];
        }
        arr = newArr;
        front = arr.length - 1;
        tail = size() - 1;
    }

    /* Returns the length of the array used to implement deque */
    public int getLength(){
        return arr.length;
    }

}
