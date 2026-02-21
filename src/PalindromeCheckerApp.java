import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // ==============================
        // UC1 - Application Entry
        // ==============================
        System.out.println("==================================");
        System.out.println(" Welcome to Palindrome Checker ");
        System.out.println("==================================");

        System.out.println("Application Name : Palindrome Checker App");
        System.out.println("Version          : 1.0.0");
        System.out.println("----------------------------------");


        // ==============================
        // UC6 - Queue + Stack Based Check
        // ==============================
        String wordUC6 = "civic";

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Push to Stack and Enqueue to Queue
        for (int i = 0; i < wordUC6.length(); i++) {
            char ch = wordUC6.charAt(i);
            stack.push(ch);      // LIFO
            queue.add(ch);      // FIFO
        }

        boolean isPalindromeUC6 = true;

        // Compare dequeue (FIFO) and pop (LIFO)
        for (int i = 0; i < wordUC6.length(); i++) {

            char fromStack = stack.pop();     // Last In First Out
            char fromQueue = queue.remove();  // First In First Out

            if (fromStack != fromQueue) {
                isPalindromeUC6 = false;
                break;
            }
        }

        if (isPalindromeUC6) {
            System.out.println("UC6 Result: \"" + wordUC6 + "\" is a Palindrome.");
        } else {
            System.out.println("UC6 Result: \"" + wordUC6 + "\" is NOT a Palindrome.");
        }

        System.out.println("----------------------------------");
        System.out.println("Program Finished.");
    }
}