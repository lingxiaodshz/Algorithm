package sort;

public class SortTest {

	public static void main(String[] args) {
		int[] arr = { 1, 9, 4, 3, 8, 6, 3 };

		print(arr);
		System.out.println();

//		SortUtils.bubbleSort(arr);
//		SortUtils.selectSort(arr);
//		SortUtils.heapSort(arr);
		SortUtils.insertSort(arr);
		print(arr);

	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");

		}
	}
}
