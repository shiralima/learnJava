package practiceRecursive;

public class MaxInMat {

    public static int findMaxValueInMatrix(int[][] a) {
        return findMaxValueInMatrix(a, 0, 0, a[0][0]);
    }

    private static int findMaxValueInMatrix(int[][] a, int i, int j, int maxValue) {
        if (j == a[0].length - 1) {
            if (i == a.length - 1) {
                return maxValue;
            }

            i++;
            j = 0;
        } else {
            j++;
        }

        if(a[i][j] > maxValue) {
            maxValue = a[i][j];
        }

        return findMaxValueInMatrix(a, i, j, maxValue);
    }
}
