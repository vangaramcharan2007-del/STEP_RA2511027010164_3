// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java DSA (Linear Data Structures)
// Problem 02: Generic Doubly Linked List with Bidirectional Traversal
import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void insertTail(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void insertHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public boolean remove(T data) {
        Node<T> curr = head;
        while (curr != null) {
            if (curr.data.equals(data)) {
                if (curr == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                    else tail = null;
                } else if (curr == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                    else head = null;
                } else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public List<T> toForwardList() {
        List<T> list = new ArrayList<>();
        Node<T> curr = head;
        while (curr != null) {
            list.add(curr.data);
            curr = curr.next;
        }
        return list;
    }

    public List<T> toBackwardList() {
        List<T> list = new ArrayList<>();
        Node<T> curr = tail;
        while (curr != null) {
            list.add(curr.data);
            curr = curr.prev;
        }
        return list;
    }
}
