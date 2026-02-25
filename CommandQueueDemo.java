import java.util.LinkedList;
import java.util.Queue;

// COMMAND QUEUE

class CommandQ {
    private Queue<String> queue = new LinkedList<>();

    public void enqueue(String cmd) {
        queue.add(cmd);
    }

    public String dequeue() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

class CommandProcessor {

    private StringBuilder text = new StringBuilder();
    private LinkedList<String> undo = new LinkedList<>();
    private LinkedList<String> redo = new LinkedList<>();

    public void process(String cmd, String value) {
        switch (cmd) {
            case "w": // write
                undo.push(text.toString());
                text.append(value).append(" ");
                redo.clear();
                break;

            case "u": // undo
                if (!undo.isEmpty()) {
                    redo.push(text.toString());
                    text = new StringBuilder(undo.pop());
                }
                break;

            case "s": // show
                System.out.println("Output: " + text.toString());
                break;
        }
    }

    public void execute(CommandQ queue, String[] tokens) {
        int idx = 0;

        while (!queue.isEmpty()) {
            String cmd = queue.dequeue();

            if (cmd.equals("w")) {
                idx++;
                process("w", tokens[idx]);
            }
            else if (cmd.equals("u")) {
                process("u", "");
            }
            else if (cmd.equals("s")) {
                process("s", "");
            }

            idx++;
        }
    }
}

// ========== MAIN DEMO ==========

public class CommandQueueDemo {
    public static void main(String[] args) {

        String input = "w Data w MINING u w Structures s";
        String[] tokens = input.split(" ");

        CommandQ queue = new CommandQ();

        for (String t : tokens) {
            if (t.equals("w") || t.equals("u") || t.equals("s"))
                queue.enqueue(t);
        }

        CommandProcessor cp = new CommandProcessor();
        cp.execute(queue, tokens);
    }
}
