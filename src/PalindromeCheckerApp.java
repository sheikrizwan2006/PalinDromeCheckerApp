import java.util.Stack;

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
        String hardcodedWord = "madam";

        if (hardcodedWord.equals("madam")) {
            System.out.println("UC2 Result: \"" + hardcodedWord + "\" is a Palindrome.");
        } else {
            System.out.println("UC2 Result: \"" + hardcodedWord + "\" is NOT a Palindrome.");
        }

        System.out.println("----------------------------------");


        // ==============================
        // UC3 - Reverse Using String
        // ==============================
        String original = "level";
        String reversedUC3 = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversedUC3 = reversedUC3 + original.charAt(i);
        }

        if (original.equals(reversedUC3)) {
            System.out.println("UC3 Result: \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("UC3 Result: \"" + original + "\" is NOT a Palindrome.");
        }

        System.out.println("----------------------------------");


        // ==============================
        // UC4 - Character Array Based Check
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
        // UC5 - Stack Based Palindrome Check
        // ==============================
        String wordUC5 = "noon";

        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (int i = 0; i < wordUC5.length(); i++) {
            stack.push(wordUC5.charAt(i));
        }

        boolean isPalindromeUC5 = true;

        // Pop and compare
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
        System.out.println("Program Finished.");
    }
}