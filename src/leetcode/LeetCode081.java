package leetcode;

public class LeetCode081 {
    /**
     * 81. 搜索旋转排序数组 II
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
     * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
     * 示例 1:
     * 输入: nums = [2,5,6,0,0,1,2], target = 0
     * 输出: true
     * 示例 2:
     * 输入: nums = [2,5,6,0,0,1,2], target = 3
     * 输出: false
     * 进阶:
     * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
     * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
     */

    public static void main(String[] args) {
//        int[] nums = {2,5,6,0,0,1,2};
//        int[] nums = {3, 5, 1};
//        int[] nums = {3, 1};
        int[] nums = {3, 1, 2, 2, 2};
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 1));
    }

    private static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return nums[0] == target;
        }
        int left =0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            while (left < right && nums[left] == nums[right]) {
                if (target == nums[left]) {
                    return true;
                } else {
                    int temp = nums[left];
                    while (left < right && nums[left] == temp) {
                        left++;
                    }
                    while (left < right && nums[right] == temp) {
                        right--;
                    }
                }
            }
            while (left < right && nums[left] == nums[left + 1]) {
                left++;
            }
            while (left < right && nums[right] == nums[right - 1]) {
                right--;
            }
            if (nums[left] == target || nums[right] == target) {
                return true;
            }
            mid = (left + right) / 2;
            if (nums[left] < nums[right]) {
                if (target < nums[mid]) {
                    right = mid - 1;
                } else if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    return true;
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
                    return true;
                }
            }
        }

        return false;
    }
}
