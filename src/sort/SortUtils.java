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
		if (arr == null || arr.length <= 1) {
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

	//插入排序
	public static void insertSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		int temp;
		int index;
		for (int i = 1, len = arr.length; i < len; i++) {
			temp = arr[i];
			index = i;
			while (index >= 0 && temp < arr[index - 1]) {
				arr[index] = arr[index - 1];
				index--;
			}
			arr[index] = temp;
		}
	}

	public static void shellSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		int len = arr.length;
		int temp;
		int index;
		for (int gap = len / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < len; i += gap) {
				index = i;
				temp = arr[i];
				while (index >= 0 && temp < arr[index - gap]) {
					arr[index] = arr[index - gap];
					index -= gap;
				}
				arr[index] = temp;
			}
		}
	}
}
