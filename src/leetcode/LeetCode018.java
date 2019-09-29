package leetcode;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode018 {
    /**
     * 18. 四数之和
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * 注意：
     * 答案中不可以包含重复的四元组。
     * 示例：
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     * 满足要求的四元组集合为：
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     */

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));//
//        int[] nums1 = {-3, -1, 0, 2, 4, 5};
//        System.out.println(fourSum(nums1, 0));//[[-3,-1,0,4]]
//        int[] nums2 = {-3, -2, -1, 0, 0, 1, 2, 3};
//        System.out.println(fourSum(nums2, 0));//[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        int pre, next;
        int temp;
        for (int i = 0, len = nums.length; i < len - 3; ) {
            for (int j = i + 1; j < len - 2; ) {
                pre = j + 1;
                next = len - 1;
                while (pre < next) {
                    temp = nums[i] + nums[j] + nums[pre] + nums[next];
                    if (temp - target < 0) {
                        while (pre < next && nums[pre] == nums[++pre]) ;
                    } else if (temp - target > 0) {
                        while (pre < next && nums[next] == nums[--next]) ;
                    } else {
                        list.add(Arrays.asList(nums[i], nums[j], nums[pre], nums[next]));
                        while (pre < next && nums[pre] == nums[++pre]) ;
                        while (pre < next && nums[next] == nums[--next]) ;
                    }
                }
                while (++j < len - 2 && nums[j] == nums[j - 1]) ;
            }
            while (++i < len - 3 && nums[i] == nums[i - 1]) ;
        }
        return list;
    }
}
