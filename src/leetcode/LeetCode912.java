package leetcode;

public class LeetCode912 {
    /**
     * 912. 排序数组
     * 给你一个整数数组 nums，请你将该数组升序排列。
     * 示例 1：
     * 输入：nums = [5,2,3,1]
     * 输出：[1,2,3,5]
     * 示例 2：
     * 输入：nums = [5,1,1,2,0,0]
     * 输出：[0,0,1,1,2,5]
     * 提示：
     * 1 <= nums.length <= 50000
     * -50000 <= nums[i] <= 50000
     */

    public static void main(String[] args) {
        System.out.println();
    }

    public static int[] sortArray(int[] nums) {

        return nums;
    }

    /**
     * 选择排序
     * @param nums
     */
    public static void selectSort(int[] nums) {
        int maxIndex;
        for (int i = 0, len = nums.length; i < len; i++) {
            maxIndex = 0;
            for (int j = 1; j < len - i; j++) {
                if (nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(nums, maxIndex, len - i - 1);
        }
    }

    /**
     * 堆排序排序
     *
     * @param nums
     */
    public static void heapSort(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            buildHeap(nums, len, i);
        }

        for (int i = len - 1; i >= 0; i--) {
            swap(nums, 0, i);
            buildHeap(nums, i, 0);
        }

    }

    public static void buildHeap(int[] nums, int len, int i) {
        for (int j = 2 * i + 1; j < len; j = 2 * i + 1) {
            if (j + 1 < len && nums[j + 1] < nums[j]) {
                j++;
            }
            if (nums[i] > nums[j]) {
                swap(nums, i, j);
                i = j;
            } else {
                break;
            }
        }
    }

    /**
     * 希尔排序
     *
     * @param nums
     */
    public static void shellSort(int[] nums) {
        int len = nums.length;
        int index;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i += gap) {
                index = i;
                while (index - gap >= 0 && nums[index] < nums[index - gap]) {
                    swap(nums, index, index - gap);
                    index -= gap;
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param nums
     */
    public static void insertSort(int[] nums) {
        for (int i = 1, len = nums.length; i < len; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    /**
     * 快速排序
     *
     * @param nums
     */
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mL = left;
        int mR = right;
        int temp = left;
        while (mL < mR) {
            while (mL < mR && nums[mR] >= temp) {
                mR--;
            }
            if (mL < mR) {
                nums[mL] = nums[mR];
            }
            while (mL < mR && nums[mL] <= temp) {
                mL++;
            }
            if (mL < mR) {
                nums[mR] = nums[mL];
            }
        }
        nums[mL] = temp;

        quickSort(nums, left, mL-1);
        quickSort(nums, mL + 1, right);
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        for (int i = 0, len = nums.length; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    public static void heapSort1(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            buildHeap1(nums, len, i);
        }
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            buildHeap1(nums, i, 0);
        }
    }

    private static void buildHeap1(int[] nums, int len, int i) {
        for (int k = 2 * i + 1; k < len; k = 2 * i + 1) {
            if (k + 1 < len && nums[k + 1] > nums[k]) {
                k++;
            }
            if (nums[i] < nums[k]) {
                swap(nums, i, k);
                i = k;
            } else {
                break;
            }
        }
    }
}
