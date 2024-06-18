package practiceRecursive;

public class MinValue {
    public static int minValue(int[] array) {
        return minValue(array, 0, 0);
    }

    private static int minValue(int[] array, int i, int minValueIndex) {
        if (i >= array.length) {
            return minValueIndex;
        }

        if (array[i] < array[minValueIndex]) {
            return minValue(array, ++i, i);
        }

        return minValue(array, ++i, minValueIndex);
    }
}
