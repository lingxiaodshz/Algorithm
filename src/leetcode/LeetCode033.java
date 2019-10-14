package leetcode;

public class LeetCode033 {
    /**
     * 33. 搜索旋转排序数组
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * 你可以假设数组中不存在重复的元素。
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * 示例 1:
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     */

    public static void main(String[] args) {
//        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
//        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
//        System.out.println(search(new int[]{4, 3}, 3));
//        System.out.println(search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
//        System.out.println(search(new int[]{5, 1, 2, 3, 4}, 1));
//        System.out.println(search(new int[]{3, 5, 1}, 3));
//        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        System.out.println(search(new int[]{5, 1, 3}, 3));

    }

    public static int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[left] < nums[right]) {
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else {
                if (nums[mid] < target) {
                    if (nums[mid] < nums[left]) {
                        if (nums[right] < target) {
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[mid] > target) {
                    if (nums[mid] < nums[left]) {
                        right = mid - 1;
                    } else {
                        if (nums[left] > target) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
