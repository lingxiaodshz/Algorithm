package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeetCode056 {
    /**
     * 56. 合并区间
     * 给出一个区间的集合，请合并所有重叠的区间。
     * 示例 1:
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2:
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     */

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = {{1, 4}, {4, 5}};
//        int[][] intervals = {{1, 4}, {0, 4}};
//        int[][] intervals = {{1, 4}, {0, 1}};
//        int[][] intervals = {{2,3}, {4,5}, {6,7}, {8,9}, {1,10}};
//        int[][] intervals = {{1, 10}, {8, 9}, {2, 3}, {4, 5}, {6, 7}};
//        int[][] intervals = {{2,3}, {5,5}, {2,2}, {3,4}, {3,4}};
        int[][] arr = merge(intervals);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "  " + arr[i][1]);
        }
    }

//    执行结果：
//    解答错误
//            显示详情
//    输入:
//            [[2,3],[5,5],[2,2],[3,4],[3,4]]
//    输出
//[[2,3],[5,5],[2,2],[3,4]]
//    预期结果
//[[2,4],[5,5]]

    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return list.toArray(new int[list.size()][]);
        }
        list.add(intervals[intervals.length - 1]);
        int[] arr, temp;
        for (int i = intervals.length - 2; i >= 0; i--) {
            temp = intervals[i];
            Iterator<int[]> iterator = list.iterator();
            while (iterator.hasNext()) {
                arr = iterator.next();
                if (hasMerge(arr, temp)) {
                    temp[0] = Math.min(arr[0], temp[0]);
                    temp[1] = Math.max(arr[1], temp[1]);
                    iterator.remove();
                }
            }
            list.add(0, temp);
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
