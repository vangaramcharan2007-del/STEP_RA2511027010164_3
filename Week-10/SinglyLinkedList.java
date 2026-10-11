// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java DSA (Linear Data Structures)
// Problem 01: Generic Singly Linked List Implementation
import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void insertHead(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertTail(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    public boolean delete(T data) {
        if (head == null) return false;
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }
        Node<T> curr = head;
        while (curr.next != null && !curr.next.data.equals(data)) {
            curr = curr.next;
        }
        if (curr.next != null) {
            curr.next = curr.next.next;
            size--;
            return true;
        }
        return false;
    }

    public boolean contains(T data) {
        Node<T> curr = head;
        while (curr != null) {
            if (curr.data.equals(data)) return true;
            curr = curr.next;
        }
        return false;
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> curr = head;
        Node<T> next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public List<T> toList() {
        List<T> result = new ArrayList<>();
        Node<T> curr = head;
        while (curr != null) {
            result.add(curr.data);
            curr = curr.next;
        }
        return result;
    }
}
