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

        // ==============================
        // UC2 - Hardcoded Palindrome
        // ==============================
        String word = "madam";
        if (word.equals("madam")) {
            System.out.println("UC2 Result: \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("UC2 Result: \"" + word + "\" is NOT a Palindrome.");
        }
        System.out.println("----------------------------------");

        // ==============================
        // UC3 - Reverse Using String
        // ==============================
        String original = "level";
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }
        if (original.equals(reversed)) {
            System.out.println("UC3 Result: \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("UC3 Result: \"" + original + "\" is NOT a Palindrome.");
        }
        System.out.println("----------------------------------");

        // ==============================
        // UC4 - Character Array Based
        // ==============================
        String wordUC4 = "radar";
        char[] characters = wordUC4.toCharArray();
        int left = 0;
        int right = characters.length - 1;
        boolean isPalindromeUC4 = true;

        while (left < right) {
            if (characters[left] != characters[right]) {
                isPalindromeUC4 = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("UC4 Result: \"" + wordUC4 + "\" is " +
                (isPalindromeUC4 ? "a Palindrome." : "NOT a Palindrome."));
        System.out.println("----------------------------------");

        // ==============================
        // UC5 - Stack Based
        // ==============================
        String wordUC5 = "noon";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < wordUC5.length(); i++) {
            stack.push(wordUC5.charAt(i));
        }

        boolean isPalindromeUC5 = true;
        for (int i = 0; i < wordUC5.length(); i++) {
            if (wordUC5.charAt(i) != stack.pop()) {
                isPalindromeUC5 = false;
                break;
            }
        }

        System.out.println("UC5 Result: \"" + wordUC5 + "\" is " +
                (isPalindromeUC5 ? "a Palindrome." : "NOT a Palindrome."));
        System.out.println("----------------------------------");

        // ==============================
        // UC6 - Queue + Stack
        // ==============================
        String wordUC6 = "civic";
        Stack<Character> stackUC6 = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < wordUC6.length(); i++) {
            char ch = wordUC6.charAt(i);
            stackUC6.push(ch);
            queue.add(ch);
        }

        boolean isPalindromeUC6 = true;
        for (int i = 0; i < wordUC6.length(); i++) {
            if (stackUC6.pop() != queue.remove()) {
                isPalindromeUC6 = false;
                break;
            }
        }

        System.out.println("UC6 Result: \"" + wordUC6 + "\" is " +
                (isPalindromeUC6 ? "a Palindrome." : "NOT a Palindrome."));
        System.out.println("----------------------------------");

        // ==============================
        // UC7 - Deque Based
        // ==============================
        String wordUC7 = "refer";
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < wordUC7.length(); i++) {
            deque.addLast(wordUC7.charAt(i));
        }

        boolean isPalindromeUC7 = true;
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindromeUC7 = false;
                break;
            }
        }

        System.out.println("UC7 Result: \"" + wordUC7 + "\" is " +
                (isPalindromeUC7 ? "a Palindrome." : "NOT a Palindrome."));
        System.out.println("----------------------------------");

        // ==============================
        // UC8 - Linked List Based
        // ==============================
        String wordUC8 = "racecar";

        class Node {
            char data;
            Node next;
            Node(char data) { this.data = data; }
        }

        Node head = null, tail = null;
        for (int i = 0; i < wordUC8.length(); i++) {
            Node newNode = new Node(wordUC8.charAt(i));
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null, current = slow;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        Node firstHalf = head, secondHalf = prev;
        boolean isPalindromeUC8 = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindromeUC8 = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        System.out.println("UC8 Result: \"" + wordUC8 + "\" is " +
                (isPalindromeUC8 ? "a Palindrome." : "NOT a Palindrome."));
        System.out.println("----------------------------------");

        // ==============================
        // UC9 - Recursive
        // ==============================
        String wordUC9 = "madam";
        boolean isPalindromeUC9 = isPalindrome(wordUC9, 0, wordUC9.length() - 1);

        System.out.println("UC9 Result: \"" + wordUC9 + "\" is " +
                (isPalindromeUC9 ? "a Palindrome." : "NOT a Palindrome."));
        System.out.println("----------------------------------");

        // ==============================
        // UC10 - Ignore Case & Spaces
        // ==============================
        String wordUC10 = "A man a plan a canal Panama";
        String normalized = wordUC10.replaceAll("\\s+", "").toLowerCase();

        int l = 0, r = normalized.length() - 1;
        boolean isPalindromeUC10 = true;

        while (l < r) {
            if (normalized.charAt(l) != normalized.charAt(r)) {
                isPalindromeUC10 = false;
                break;
            }
            l++; r--;
        }

        System.out.println("UC10 Result: \"" + wordUC10 + "\" is " +
                (isPalindromeUC10 ? "a Palindrome (Ignoring Case & Spaces)." : "NOT a Palindrome."));
        System.out.println("----------------------------------");

        // ==============================
        // UC11 - OOP Service
        // ==============================
        PalindromeService service = new PalindromeService();
        String wordUC11 = "level";
        boolean isPalindromeUC11 = service.checkPalindrome(wordUC11);

        System.out.println("UC11 Result: \"" + wordUC11 + "\" is " +
                (isPalindromeUC11 ? "a Palindrome." : "NOT a Palindrome."));
        System.out.println("----------------------------------");

        // ==============================
        // UC12 - Strategy Pattern
        // ==============================
        String wordUC12 = "madam";
        PalindromeContext context = new PalindromeContext();

        context.setStrategy(new StackStrategy());
        System.out.println("UC12 Stack Strategy: " + context.execute(wordUC12));

        context.setStrategy(new DequeStrategy());
        System.out.println("UC12 Deque Strategy: " + context.execute(wordUC12));

        System.out.println("----------------------------------");

        // ==============================
        // UC13 - Performance Comparison
        // ==============================
        String wordUC13 = "racecar";

        long start = System.nanoTime();
        boolean result = service.checkPalindrome(wordUC13);
        long end = System.nanoTime();

        System.out.println("UC13 Performance (Service Method): " +
                result + " | Time: " + (end - start) + " ns");

        System.out.println("----------------------------------");
        System.out.println("Program Finished.");
    }

    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindrome(str, start + 1, end - 1);
    }
}