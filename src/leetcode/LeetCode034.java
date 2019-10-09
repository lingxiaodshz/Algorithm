package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.LongFunction;

public class LeetCode034 {
    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * 如果数组中不存在目标值，返回 [-1, -1]。
     * 示例 1:
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 示例 2:
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     */

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] arr = searchRange(nums, 6);
        System.out.println(arr[0] + "  " + arr[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid-1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }
        if (left >= nums.length) {
            return new int[]{-1, -1};
        }
        if (nums[left] == target) {
            list.add(left);
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        if (right < 0) {
            return new int[]{-1, -1};
        }
        if (nums[right] == target) {
            list.add(right);
        }
        if (list.size() == 0) {
            return new int[]{-1, -1};
        } else {
            return new int[]{list.get(0), list.get(1)};
        }
    }
}
