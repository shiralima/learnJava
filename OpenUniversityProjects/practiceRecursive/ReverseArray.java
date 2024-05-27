package practiceRecursive;

public class ReverseArray {
    public static int[] reverse(int[] a) {
        return reverse(a, 0);
    }

    public static int[] reverse(int[] a, int i) {

        if (i < a.length / 2) {
            int n = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = n;
            reverse(a, ++i);
        }
        return a;
    }
}
