package practiceRecursive;

public class Count {

    public static boolean count(int[] a1, int[] a2) {

        return count(a1, a2, 0);

    }

    private static boolean count(int[] a1, int[] a2, int i) {
        if (i == a1.length)

            return true;

        if ((a2[i] == 1 && a1[i] > 9) ||

                (a2[i] == 2 && (a1[i] < 10 || a1[i] > 99)))

            return false;

        return count(a1, a2, i + 1);
    }
}
