package sort;

public class SortUtils {
	// ð������
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

	// ѡ������
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

	// 堆排序
	public static void heapSort(int[] arr) {
		if (arr == null || arr.length == 1) {
			return;
		}
		int len = arr.length;
		for (int i = len / 2 - 1; i >= 0; i--) {
			buildHead(arr, i, len);
		}
		for (int j = len - 1; j > 0; j--) {
			swap(arr, 0, j);
			buildHead(arr, 0, j);
		}
	}

	private static void buildHead(int[] arr, int i, int len) {
		for (int k = 2 * i + 1; k < len; k = 2 * i + 1) {
			if (k + 1 < len && arr[k] < arr[k + 1]) {
				k++;
			}
			if (arr[i] < arr[k]) {
				swap(arr, i, k);
				i = k;
			} else {
				break;
			}
		}
	}
}
