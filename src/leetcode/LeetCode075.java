package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode075 {
    /**
     * 75. 颜色分类
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     * 示例:
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     * 进阶：
     * 一个直观的解决方案是使用计数排序的两趟扫描算法。
     * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     */

    public static void main(String[] args) {
        int[] arr = {0,2,1};
        sortColors(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        int temp;
        while (index <= end) {
            if (nums[index] == 2) {
                while (end >= 0 && nums[index] == nums[end]) {
                    end--;
                }
                if (end > index) {
                    temp = nums[index];
                    nums[index] = nums[end];
                    nums[end] = temp;
                }
            } else if (nums[index] == 0) {
                while (start < nums.length && index < nums.length && nums[index] == nums[start]) {
                    start++;
                }
                if (start <= index) {
                    temp = nums[index];
                    nums[index] = nums[start];
                    nums[start] = temp;
                } else {
                    index++;
                }
            } else {
                index++;
            }
        }
    }
}
