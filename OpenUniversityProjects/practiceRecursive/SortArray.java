package practiceRecursive;

public class SortArray {
    public static int halfMinValue(int[] array) {
        return halfMinValue(array, 0, 0);
    }

    private static int halfMinValue(int[] array, int i, int minValue) {
        boolean isEvenArray = array.length % 2 == 0;
        boolean isMiddle = (array.length / 2) + 1 == i;
        boolean isBeforeMiddle = array.length / 2 == i;
        System.out.println("mi: " + isMiddle + " index: " + i);
        System.out.println("b mi: " + isBeforeMiddle);

        if (isEvenArray ? isBeforeMiddle : isMiddle) {
            return minValue;
        }
        System.out.println("i val: " + array[i] + " min val: " + array[minValue]);
        if (array[i] < array[minValue]) {
            return halfMinValue(array, ++i, i);
        }

        return halfMinValue(array, ++i, minValue);
    }

    public static int maxEven(int[] array) {
        return maxEven(array, 0);
    }

    private static int maxEven(int[] array, int i) {
        if (i == array.length || i == array.length + 1) {
            return array[array.length % 2 == 0 ? array.length : array.length - 1];
        }

        int value = maxEven(array, i + 2);
        return Math.min(array[i], value);
    }

    public static boolean twoAscending(int[] a) {
        return twoAscending(a, 0, false);
    }

    private static boolean twoAscending(int[] a, int i, boolean isEven) {
        if (i >= a.length) {
            if (!isEven) {
                return twoAscending(a, 1, true);
            }

            return true;
        }

        if (a[i] >= a[i + 2]) {
            System.out.println("false in " + (isEven ? "even" : "ood") + " places");
            return false;
        }

        return twoAscending(a, ++i, isEven);
    }

}
