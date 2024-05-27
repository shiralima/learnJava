package practiceRecursive;

public class Arithmetic {

	// Recursive function that return num1 dived by num 2
	public static int div(int num1, int num2) {
		if (num1 < num2) {
			return 0;
		}
		return 1 + div(num1 - num2, num2);
	}

	public static int mul(int[] arr) {
		return mul(arr, 0);
	}

	public static int mul(int[] arr, int i) {
		if (i == arr.length - 1) {
			return 1 * arr[i];
		}

		return arr[i] * mul(arr, ++i);
	}
}
