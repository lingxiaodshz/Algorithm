package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode054 {
    /**
     * 54. 螺旋矩阵
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     * 示例 1:
     * 输入:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     * 示例 2:
     * 输入:
     * [
     *   [1, 2, 3, 4],
     *   [5, 6, 7, 8],
     *   [9,10,11,12]
     * ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     */

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        int[][] matrix = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}
//        };
//        int[][] matrix = {};
//        int[][] matrix = {{3}, {2}};
        int[][] matrix = {{3}, {2}, {1}};
        System.out.println(spiralOrder(matrix));
    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int rLen = matrix[0].length; //行长度
        int cLen = matrix.length; //列长度
        int row = 0, column = 0;
        while (row < (rLen + 1) / 2 && column < (cLen + 1) / 2) {
            for (int i = column; i < rLen - column; i++) {
                list.add(matrix[row][i]);
            }
            for (int i = row + 1; i < cLen - row; i++) {
                list.add(matrix[i][rLen - column - 1]);
            }
            for (int i = rLen - column - 2; i >= column; i--) {
                if (row != cLen - row - 1) {
                    list.add(matrix[cLen - 1 - row][i]);
                }
            }
            for (int i = cLen - row - 2; i > row; i--) {
                if (column != rLen - column - 1) {
                    list.add(matrix[i][column]);
                }
            }
            row++;
            column++;
        }
        return list;
    }
}
