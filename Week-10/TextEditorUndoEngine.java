// Student: RAM CHARAN VANGA | Reg: RA2511027010164
// SRMIST Department of CSE (Big Data Analytics)
// Course: STEP Semester 3 - Java DSA (Linear Data Structures)
// Problem 05: Practical Linear Data Structure Application: Dual-Stack Undo/Redo Engine
public class TextEditorUndoEngine {
    private StringBuilder currentText;
    private CustomStack<String> undoStack;
    private CustomStack<String> redoStack;

    public TextEditorUndoEngine() {
        this.currentText = new StringBuilder();
        this.undoStack = new CustomStack<>();
        this.redoStack = new CustomStack<>();
    }

    public void type(String text) {
        if (text != null && !text.isEmpty()) {
            undoStack.push(currentText.toString());
            // Clear redo history on new user action
            while (!redoStack.isEmpty()) {
                redoStack.pop();
            }
            currentText.append(text);
        }
    }

    public boolean undo() {
        if (undoStack.isEmpty()) return false;
        redoStack.push(currentText.toString());
        currentText = new StringBuilder(undoStack.pop());
        return true;
    }

    public boolean redo() {
        if (redoStack.isEmpty()) return false;
        undoStack.push(currentText.toString());
        currentText = new StringBuilder(redoStack.pop());
        return true;
    }

    public String getText() {
        return currentText.toString();
    }
}
