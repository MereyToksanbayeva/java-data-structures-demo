import java.util.Stack;

//  TEXT STACK IMPLEMENTATION 
class TextStack {
    private Stack<String> stack = new Stack<>();

    public void push(String text) {
        stack.push(text);
    }

    public String pop() {
        if (stack.isEmpty()) return "";
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

class TextEditor {
    private TextStack undo = new TextStack();
    private TextStack redo = new TextStack();
    private StringBuilder text = new StringBuilder();

    public void write(String newText) {
        undo.push(text.toString());
        text.append(newText);
        redo = new TextStack(); // reset redo
    }

    public void undo() {
        if (!undo.isEmpty()) {
            redo.push(text.toString());
            text = new StringBuilder(undo.pop());
        }
    }

    public void redo() {
        if (!redo.isEmpty()) {
            undo.push(text.toString());
            text = new StringBuilder(redo.pop());
        }
    }

    public void show() {
        System.out.println("Text: " + text.toString());
    }
}

public class TextStackDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        System.out.println("=== STACK DEMO ===");
        editor.write("Data ");
        editor.write("Structures ");
        editor.show();

        editor.undo();
        editor.show();

        editor.redo();
        editor.show();
    }
}
