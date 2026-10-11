// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java DSA (Linear Data Structures)
// Problem 03: Generic LIFO Stack Implementation
import java.util.EmptyStackException;

public class CustomStack<T> {
    private Object[] elements;
    private int top;
    private int capacity;

    public CustomStack() {
        this(16);
    }

    public CustomStack(int initialCapacity) {
        this.capacity = initialCapacity;
        this.elements = new Object[initialCapacity];
        this.top = -1;
    }

    public void push(T item) {
        if (top == capacity - 1) {
            resize();
        }
        elements[++top] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T item = (T) elements[top];
        elements[top--] = null;
        return item;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return (T) elements[top];
    }

    public boolean isEmpty() { return top == -1; }
    public int size() { return top + 1; }

    private void resize() {
        capacity *= 2;
        Object[] newElements = new Object[capacity];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }
}
