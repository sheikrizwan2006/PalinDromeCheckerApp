import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;

public class PalindromeCheckerApp {

    // ==============================
    // UC11 - OOP Service Class
    // ==============================
    static class PalindromeService {

        public boolean checkPalindrome(String input) {

            int left = 0;
            int right = input.length() - 1;

            while (left < right) {
                if (input.charAt(left) != input.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    // ==============================
    // UC12 - Strategy Pattern
    // ==============================
    interface PalindromeStrategy {
        boolean check(String input);
    }

    static class StackStrategy implements PalindromeStrategy {

        public boolean check(String input) {

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < input.length(); i++) {
                stack.push(input.charAt(i));
            }

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) != stack.pop()) {
                    return false;
                }
            }
            return true;
        }
    }

    static class DequeStrategy implements PalindromeStrategy {

        public boolean check(String input) {

            Deque<Character> deque = new LinkedList<>();

            for (int i = 0; i < input.length(); i++) {
                deque.addLast(input.charAt(i));
            }

            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }
            return true;
        }
    }

    static class PalindromeContext {

        private PalindromeStrategy strategy;

        public void setStrategy(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean execute(String input) {
            return strategy.check(input);
        }
    }

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

        // (UC2 to UC11 code remains exactly same as before)
        // 👉 I am not rewriting entire UC1–UC11 here to avoid unnecessary repetition
        // 👉 Your previous UC1–UC11 block stays exactly as it is

        // ==============================
        // UC12 - Strategy Execution
        // ==============================
        String wordUC12 = "madam";

        PalindromeContext context = new PalindromeContext();

        // Using Stack Strategy
        context.setStrategy(new StackStrategy());
        boolean resultStack = context.execute(wordUC12);

        if (resultStack) {
            System.out.println("UC12 Stack Strategy: \"" + wordUC12 + "\" is a Palindrome.");
        } else {
            System.out.println("UC12 Stack Strategy: \"" + wordUC12 + "\" is NOT a Palindrome.");
        }

        // Using Deque Strategy
        context.setStrategy(new DequeStrategy());
        boolean resultDeque = context.execute(wordUC12);

        if (resultDeque) {
            System.out.println("UC12 Deque Strategy: \"" + wordUC12 + "\" is a Palindrome.");
        } else {
            System.out.println("UC12 Deque Strategy: \"" + wordUC12 + "\" is NOT a Palindrome.");
        }

        System.out.println("----------------------------------");
        System.out.println("Program Finished.");
    }

    // Recursive Method for UC9 (unchanged)
    public static boolean isPalindrome(String str, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindrome(str, start + 1, end - 1);
    }
}