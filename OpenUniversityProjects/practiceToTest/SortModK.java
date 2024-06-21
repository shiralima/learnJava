package practiceToTest;

public class SortModK {

    public static int[] sortMod(int[] a, int k) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i >= j) {
                    break;
                }

                if (a[i] % k > a[j] % k) {

                }
            }
        }

        return a;
    }

    public static int[] sortMod1(int[] a, int k) {
        for (int i = 0; i < a.length; i++) {
            int minIndexInArrayFromIndex = findMinK(a, k, i);
            int temp = a[i];
            int nextMin = a[minIndexInArrayFromIndex];
            System.out.println("Current min index: " + minIndexInArrayFromIndex + " from index: " + i);

            a[i] = nextMin;
            a[minIndexInArrayFromIndex] = temp;

            System.out.println("Current array:");
            for (int j = 0; j < a.length; j++) {
                System.out.println(a[j]);
            }
        }

        return a;
    }

    public static int findMinK(int[] a, int k, int index) {
        int m = a[index] % k;
        System.out.println("start m: " + m);
        int mI = index;

        for (int i = index + 1; i < a.length; i++) {
            System.out.println("current %: " + (a[i] % k));
            if (a[i] % k < m) {
                m = a[i] % k;
                mI = i;
            }
        }

        System.out.println("min : " + m);
        return mI;
    }

    public static int countTriple(int[] a, int n) {

        if (a.length < 3) {
            return 0;
        }

        int n1 = a[0];
        int n2 = a[1];
        int n3 = a[2];

        int sum = n1 + n2 + n3;
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] > n) {
                return sum;
            }
            for (int j = 0; j < a.length; j++) {
                if (a[j] > n) {
                    return sum;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 1, 2, 3 };

        int[] aSort = sortMod1(a, 3);

        for (int i = 0; i < aSort.length; i++) {
            System.out.println(a[i]);
        }

        // findMinK(a, 3, 2);
    }
}

// [1, 2, 3, 1, 2, 3]
// findMinK -> i = 0, minI = 0(1) -> a[0] = 1.
// findMinK -> i = 1, minI = 3(1) -> a[1] = 1. [1, 1, 3, 2, 2, 3]
// findMinK -> i = 2, minI = 3 -> a[2] = 2. [1, 1, 2, 3, 2, 3]
// findMinK -> i = 3, minI = 4 -> a[3] = 2. [1, 1, 2, 2, 3, 3]
