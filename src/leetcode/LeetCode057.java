package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode057 {
    /**
     * 57. 插入区间
     * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     * 示例 1:
     * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出: [[1,5],[6,9]]
     * 示例 2:
     * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * 输出: [[1,2],[3,10],[12,16]]
     * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
     */

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] arr = insert(intervals, newInterval);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "  " + arr[i][1]);
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        if (intervals.length == 0) {
            list.add(newInterval);
            return list.toArray(new int[1][]);
        }
        boolean hasAddMerge = false;
        int[] mergeArr = null;
        for (int i = 0; i < intervals.length; i++) {
            if (mergeArr == null) {
                if (hasMerge(intervals[i], newInterval)) {
                    mergeArr = new int[2];
                    mergeArr[0] = Math.min(intervals[i][0], newInterval[0]);
                    mergeArr[1] = Math.max(intervals[i][1], newInterval[1]);
                } else {
                    if (intervals[i][0] > newInterval[1]) {
                        list.add(newInterval);
                        for (int j = i; j < intervals.length; j++) {
                            list.add(intervals[j]);
                        }
                        return list.toArray(new int[list.size()][]);
                    } else {
                        list.add(intervals[i]);
                    }
                }
            } else {
                if (hasMerge(intervals[i], mergeArr)) {
                    mergeArr[0] = Math.min(intervals[i][0], mergeArr[0]);
                    mergeArr[1] = Math.max(intervals[i][1], mergeArr[1]);
                } else {
                    if (!hasAddMerge) {
                        hasAddMerge = true;
                        list.add(mergeArr);
                    }
                    list.add(intervals[i]);
                }
            }
        }
        if (!hasAddMerge) {
            if (mergeArr != null) {
                list.add(mergeArr);
            } else {
                list.add(newInterval);
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    private static boolean hasMerge(int[] arr1, int[] arr2) {
        if (arr2[1] < arr1[0]) {
            return false;
        } else if (arr2[0] > arr1[1]) {
            return false;
        }
        return true;
    }
}
