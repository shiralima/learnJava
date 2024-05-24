package practiceRecursive;

public class InvoiceSeries {
    public static int an(int n, int d, int a1) {
        if (n == 1) {
            return a1;
        }

        return d + a1 + an(--n, d, a1 + d);
    }

    public static int sn(int n, int d, int a1) {
        if (n == 1) {
            return a1;
        }
        return an(n, d, a1) + sn(--n, d, a1 + d);
    }
}
