// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java DSA (Linear Data Structures)
import java.util.List;

public class Week10LinearDSATest {
    public static void main(String[] args) {
        System.out.println("Running Week 10 Test Suite for RAM CHARAN VANGA (RA2511027010164)...");

        // 1. Problem 01: Singly Linked List Verification
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.insertTail(10);
        sll.insertTail(20);
        sll.insertTail(30);
        sll.insertHead(5);
        assert sll.size() == 4 : "SLL size mismatch";
        assert sll.contains(20) : "SLL search failed";
        assert sll.delete(20) : "SLL deletion failed";
        assert !sll.contains(20) : "SLL deleted element still present";
        assert sll.size() == 3 : "SLL size after deletion failed";

        sll.reverse();
        List<Integer> reversedSll = sll.toList();
        assert reversedSll.get(0) == 30 && reversedSll.get(1) == 10 && reversedSll.get(2) == 5 : "SLL reversal failed";
        System.out.println("-> Problem 01 (Singly Linked List & In-Place Reversal): PASSED");

        // 2. Problem 02: Doubly Linked List Verification
        DoublyLinkedList<String> dll = new DoublyLinkedList<>();
        dll.insertTail("ALPHA");
        dll.insertTail("BETA");
        dll.insertTail("GAMMA");
        dll.insertHead("START");

        List<String> fwd = dll.toForwardList();
        List<String> bwd = dll.toBackwardList();
        assert fwd.get(0).equals("START") && fwd.get(3).equals("GAMMA") : "DLL forward traversal failed";
        assert bwd.get(0).equals("GAMMA") && bwd.get(3).equals("START") : "DLL backward traversal failed";

        assert dll.remove("BETA") : "DLL remove failed";
        assert dll.size() == 3 : "DLL size after remove failed";
        System.out.println("-> Problem 02 (Doubly Linked List & Bidirectional Traversal): PASSED");

        // 3. Problem 03: Stack & Balanced Parentheses Verification
        assert ParenthesesEvaluator.isBalanced("{[()()]}") : "Valid parentheses evaluated false";
        assert !ParenthesesEvaluator.isBalanced("{[(])}") : "Mismatched parentheses evaluated true";
        assert !ParenthesesEvaluator.isBalanced("(((") : "Incomplete parentheses evaluated true";
        System.out.println("-> Problem 03 (Custom Stack & Parentheses Evaluator): PASSED");

        // 4. Problem 04: Circular Queue Verification
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        assert queue.enqueue(100) : "Queue enqueue failed";
        assert queue.enqueue(200) : "Queue enqueue failed";
        assert queue.enqueue(300) : "Queue enqueue failed";
        assert queue.isFull() : "Queue should be full";
        assert !queue.enqueue(400) : "Queue allowed enqueue when full";

        assert queue.dequeue() == 100 : "Queue FIFO dequeue mismatch";
        assert queue.enqueue(400) : "Circular modulo wrapping enqueue failed";
        assert queue.dequeue() == 200 : "Queue FIFO dequeue after wrap mismatch";
        System.out.println("-> Problem 04 (Circular Queue with Modulo Arithmetic): PASSED");

        // 5. Problem 05: Practical Dual-Stack Text Editor Undo/Redo Engine
        TextEditorUndoEngine editor = new TextEditorUndoEngine();
        editor.type("Hello ");
        editor.type("World!");
        assert "Hello World!".equals(editor.getText()) : "Typing text failed";

        assert editor.undo() : "Undo failed";
        assert "Hello ".equals(editor.getText()) : "Text after undo mismatch";

        assert editor.redo() : "Redo failed";
        assert "Hello World!".equals(editor.getText()) : "Text after redo mismatch";

        editor.type(" Welcome to SRM.");
        assert "Hello World! Welcome to SRM.".equals(editor.getText()) : "Typing after redo failed";
        System.out.println("-> Problem 05 (Dual-Stack Undo/Redo Engine): PASSED");

        System.out.println("WEEK 10 TESTS PASSED (100%)");
    }
}
