package sort;

public class SortUtils {
	// √∞≈›≈≈–Ú
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	// —°‘Ò≈≈–Ú
	public static void selectSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		int index;
		for (int i = 0; i < arr.length; i++) {
			index = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					index = j;
				}
			}
			if (index != i) {
				swap(arr, i, index);
			}
		}

	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
