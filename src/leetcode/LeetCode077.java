package leetcode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LeetCode077 {
    /**
     * 77. 组合
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * 示例:
     * 输入: n = 4, k = 2
     * 输出:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     */

    public static void main(String[] args) {
        List<List<Integer>> lists = combine(4, 3);
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        if (n < k || n == 0) {
            return null;
        }
        List<List<Integer>> lists = new ArrayList<>();
        if (k == 0) {
            return lists;
        }

        List<Integer> indexList = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            indexList.add(i);
        }
        int j = 0, len = indexList.size();
        List<Integer> list1 = new ArrayList<>();
        for (j = 0; j < len; j++) {
            list1.add(indexList.get(j));
        }
        lists.add(list1);
        while (hasCombin(indexList, n)) {
            List<Integer> list = new ArrayList<>();
            for (j = 0; j < len; j++) {
                list.add(indexList.get(j));
            }
            lists.add(list);
        }
        return lists;
    }

    public static boolean hasCombin(List<Integer> indexList, int n) {
        int len = indexList.size();
        for (int i = len - 1; i >= 0; i--) {
            if (indexList.get(i) < n + 1 - len + i) {
                indexList.set(i, indexList.get(i) + 1);
                return true;
            } else {
                int k = i;
                while (k >= 0 && indexList.get(k) >= n + 1 - len + k) {
                    k--;
                }
                if (k >= 0) {
                    int temp = indexList.get(k);
                    for (int j = k; j < len && temp <= n; j++) {
                        temp++;
                        indexList.set(j, temp);
                    }
                    return true;
                }

            }
        }
        return false;
    }
}
