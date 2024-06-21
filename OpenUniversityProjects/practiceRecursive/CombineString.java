package practiceRecursive;

public class CombineString {

    public static String combineStrings(String s1, String s2) {
        return combineStrings(s1, s2, 0);
    }

    private static String combineStrings(String s1, String s2, int i) {
        if (s1.length() == i) {
            if (s2.length() == i) {
                return "";
            }

            return "" + s2.charAt(i) + "" + combineStrings(s1, s2, ++i);
        }

        return "" + s1.charAt(i) + "" + s2.charAt(i) + "" + combineStrings(s1, s2, ++i);
    }

}
