package practiceRecursive;

public class SumDigit {
    public static int sumDigit(int n) {
        if (n < 10) { 
            return n;
        }

        return n % 10 + sumDigit(n / 10);
    }
}
