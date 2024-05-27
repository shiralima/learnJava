package practiceRecursive;

public class Count7 {
    public static int count7InNum(int n) {

        if (n < 10) {
            return n == 7 ? 1 : 0;
        }

        return ((n % 10) == 7 ? 1 : 0) + count7InNum(n / 10);
    }
}
