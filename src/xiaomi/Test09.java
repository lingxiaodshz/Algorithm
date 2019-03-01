package xiaomi;

/*
寻找旋转排序数组中的最小值
假设一个排好序的数组在其某一未知点发生了旋转（比如0 1 2 4 5 6 7 可能在第3和第4个元素间发生旋转变成4 5 6 7 0 1 2）。
你需要找到其中最小的元素。
你可以假设数组中不存在重复的元素。
 */
public class Test09 {
    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 3, 4, 5};

        System.out.print(findMin(arr));
    }

    public static int findMin(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (mid == left) {
                return Math.min(nums[left], nums[right]);
            }
            if (nums[mid] > nums[right]) {
                if (nums[left] < nums[right]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                right = mid;
            }
        }
        // write your code here
        return nums[left];
    }
}
