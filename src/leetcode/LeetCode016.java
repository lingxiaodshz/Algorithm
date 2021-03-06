package leetcode;

import java.util.Arrays;

public class LeetCode016 {
    /**
     * 16. 最接近的三数之和
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     */

    public static void main(String[] args) {
//        int[] nums = {-1, 2, 1, -4};
//        int target = 1;
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128};
        int target = 82;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int min = nums[0] + nums[1] + nums[2];
        int temp = 0;
        Arrays.sort(nums);
        for (int i = 0, len = nums.length; i < len - 2; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                temp = nums[i] + nums[left] + nums[right];
                if (Math.abs(temp - target) < Math.abs(min - target)) {
                    min = temp;
                }
                if (temp-target < 0) {
                    left++;
                    while (left < right - 1 && nums[left + 1] == nums[left]) {
                        left++;
                    }
                } else if (temp - target > 0) {
                    right--;
                    while (left < right - 1 && nums[right - 1] == nums[right]) {
                        right--;
                    }
                } else {
                    return temp;
                }
            }
        }
        return min;
    }
}
