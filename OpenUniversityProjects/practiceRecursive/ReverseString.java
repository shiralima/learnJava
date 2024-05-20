package practiceRecursive;

public class ReverseString {
    public static void printReversed(String str) {
        printReversedHelper(str, "");
    }

    private static void printReversedHelper(String str, String newStr) {
        if (str.length() == 0) {
            System.out.println(newStr);
            return;
        }

        char c = str.charAt(str.length() - 1);
        String remainingStr = str.substring(0, str.length() - 1);
        printReversedHelper(remainingStr, newStr + c);
    }
}
