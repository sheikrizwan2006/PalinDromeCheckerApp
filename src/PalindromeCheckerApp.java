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

        // Convert String to char[]
        char[] characters = wordUC4.toCharArray();

        int left = 0;
        int right = characters.length - 1;

        boolean isPalindrome = true;

        // Two-pointer comparison
        while (left < right) {

            if (characters[left] != characters[right]) {
                isPalindrome = false;
                break;
            }

            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println("UC4 Result: \"" + wordUC4 + "\" is a Palindrome.");
        } else {
            System.out.println("UC4 Result: \"" + wordUC4 + "\" is NOT a Palindrome.");
        }

        System.out.println("----------------------------------");
        System.out.println("Program Finished.");
    }
}