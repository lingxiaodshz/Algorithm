package algorithm.stackandqueue;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 有一个整型数组arr和一个大小为w的窗口，从左滑到右，每次滑动一个位置，生成一个窗口最大值数组
 */
public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 2, 4, 3, 6, 7 };

		int[] max = getMaxWindow(arr, 3);
		for (int i = 0; i < max.length; i++) {
			System.out.println(max[i]);
		}

	}

	public static int[] getMaxWindow(int[] arr, int w) {
		if (arr == null || w < 1 || arr.length < w) {
			return null;
		}
		LinkedList<Integer> list = new LinkedList<Integer>();
		int[] res = new int[arr.length - w + 1];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			while (!list.isEmpty() && arr[list.peekLast()] <= arr[i]) {
				list.pollLast();
			}
			list.addLast(i);
			if (list.peekFirst() == i - w) {
				list.pollFirst();
			}
			if (i >= w - 1) {
				res[index++] = arr[list.peekFirst()];
			}
		}
		return res;
	}
}
