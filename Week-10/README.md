# Week 10 — Linear Data Structures & Practical Applications

## Overview & Modules Implemented
This directory contains production-grade solutions for the 5 linear data structure assignment problems:

| Problem ID | Data Structure / Module | Key Operations & Complexities |
| :---: | :--- | :--- |
| **Problem 01** | `SinglyLinkedList<T>` | `insertHead` ($O(1)$), `insertTail` ($O(n)$), `delete` ($O(n)$), `reverse` in-place ($O(n)$ time, $O(1)$ space). |
| **Problem 02** | `DoublyLinkedList<T>` | Bidirectional pointers (`prev`, `next`), forward traversal, backward traversal, node deletion ($O(1)$ pointer rewiring). |
| **Problem 03** | `CustomStack<T>` & `ParenthesesEvaluator` | Generic LIFO stack ($O(1)$ amortized push/pop), balanced bracket validator for `()`, `{}`, `[]`. |
| **Problem 04** | `CircularQueue<T>` | Fixed-capacity circular buffer with circular modulo arithmetic (`(rear + 1) % capacity`), overflow/underflow prevention. |
| **Problem 05** | `TextEditorUndoEngine` | Dual-Stack undo/redo engine implementing command history and state restoration. |

## Verification
```bash
cd Week-10
javac *.java
java -ea Week10LinearDSATest
```
