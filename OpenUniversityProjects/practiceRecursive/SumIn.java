package practiceRecursive;

public class SumIn {

    public static boolean sumInMat(int[][] a, int num) {
        return sumInMat(a, 0, 0, num);
    }

    private static boolean sumInMat(int[][] a, int i, int j, int num) {
        return false;
    }

    public static boolean sumInArray(int[] a, int num) {
        if (a.length == 1) {
            return a[0] == num;
        }

        int[] newArray = order(a, 0);

        System.out.println("ordered array: ");

        for (int element : newArray) {
            System.out.print(element + ", ");
        }

        return sumInArray(a, 0, num, a[0]);
    }

    private static boolean sumInArray(int[] a, int i, int num, int currentNum) {
        if (i == a.length - 1 || i < 0) {
            return false;
        }

        if (currentNum == num) {
            return true;
        }

        if (currentNum < num) {
            currentNum += a[i];
            i++;
        } else {
            if (i == 0) {
                return false;
            }
            currentNum += a[i - 1];
            i--;
        }

        return sumInArray(a, i, num, currentNum);
    }
    private static int[] order(int[] a, int n) {
        // Base case: when the size of the subarray to sort is 1, it's already sorted
        if (n == 1) {
            return a;
        }

        // Find the index of the maximum element in the subarray a[0..n-1]
        int maxIndex = findMaxInArray(a, 0, n);

        // Swap the maximum element with the last element of the subarray a[0..n-1]
        int temp = a[maxIndex];
        a[maxIndex] = a[n-1];
        a[n-1] = temp;

        // Recursively sort the remaining array a[0..n-2]
        return order(a, n-1);
    }

    private static int findMaxInArray(int[] a, int start, int end) {
        int maxIndex = start;
        for (int i = start + 1; i < end; i++) {
            if (a[i] > a[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
