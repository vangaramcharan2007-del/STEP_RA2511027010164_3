// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java DSA (Linear Data Structures)
// Problem 04: Generic Circular Queue Implementation with Modulo Arithmetic
public class CircularQueue<T> {
    private Object[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.data = new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isFull() { return size == capacity; }
    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    public boolean enqueue(T item) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        data[rear] = item;
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) return null;
        T item = (T) data[front];
        data[front] = null;
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) return null;
        return (T) data[front];
    }
}
