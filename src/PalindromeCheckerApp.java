import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;

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

        if (isPalindromeUC4) {
            System.out.println("UC4 Result: \"" + wordUC4 + "\" is a Palindrome.");
        } else {
            System.out.println("UC4 Result: \"" + wordUC4 + "\" is NOT a Palindrome.");
        }

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
            char popped = stack.pop();
            if (wordUC5.charAt(i) != popped) {
                isPalindromeUC5 = false;
                break;
            }
        }

        if (isPalindromeUC5) {
            System.out.println("UC5 Result: \"" + wordUC5 + "\" is a Palindrome.");
        } else {
            System.out.println("UC5 Result: \"" + wordUC5 + "\" is NOT a Palindrome.");
        }

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

        if (isPalindromeUC6) {
            System.out.println("UC6 Result: \"" + wordUC6 + "\" is a Palindrome.");
        } else {
            System.out.println("UC6 Result: \"" + wordUC6 + "\" is NOT a Palindrome.");
        }

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

        if (isPalindromeUC7) {
            System.out.println("UC7 Result: \"" + wordUC7 + "\" is a Palindrome.");
        } else {
            System.out.println("UC7 Result: \"" + wordUC7 + "\" is NOT a Palindrome.");
        }

        System.out.println("----------------------------------");


        // ==============================
        // UC8 - Linked List Based
        // ==============================
        String wordUC8 = "racecar";

        class Node {
            char data;
            Node next;

            Node(char data) {
                this.data = data;
                this.next = null;
            }
        }

        Node head = null;
        Node tail = null;

        for (int i = 0; i < wordUC8.length(); i++) {
            Node newNode = new Node(wordUC8.charAt(i));

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current = slow;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        Node firstHalf = head;
        Node secondHalf = prev;

        boolean isPalindromeUC8 = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindromeUC8 = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        if (isPalindromeUC8) {
            System.out.println("UC8 Result: \"" + wordUC8 + "\" is a Palindrome.");
        } else {
            System.out.println("UC8 Result: \"" + wordUC8 + "\" is NOT a Palindrome.");
        }

        System.out.println("----------------------------------");


        // ==============================
        // UC9 - Recursive Based
        // ==============================
        String wordUC9 = "madam";

        boolean isPalindromeUC9 = isPalindrome(wordUC9, 0, wordUC9.length() - 1);

        if (isPalindromeUC9) {
            System.out.println("UC9 Result: \"" + wordUC9 + "\" is a Palindrome.");
        } else {
            System.out.println("UC9 Result: \"" + wordUC9 + "\" is NOT a Palindrome.");
        }

        System.out.println("----------------------------------");
        System.out.println("Program Finished.");
    }

    // Recursive Method for UC9
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