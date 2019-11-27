package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode078 {
    /**
     * 78. 子集
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
     * 示例:
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */

    public static void main(String[] args) {
        List<List<Integer>> lists = subsets(new int[]{1, 2, 3});
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums != null || nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0, len = lists.size(); j < len; j++) {
                    List<Integer> tempList = new ArrayList<>(lists.get(j));
                    tempList.add(nums[i]);
                    lists.add(tempList);
                }
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                lists.add(list);
            }
        }
        lists.add(new ArrayList<Integer>());
        return lists;
    }
}
