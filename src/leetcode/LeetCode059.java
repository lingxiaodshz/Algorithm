package leetcode;

import java.util.concurrent.CountDownLatch;

public class LeetCode059 {
    /**
     * 59. 螺旋矩阵 II
     * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     * 示例:
     * 输入: 3
     * 输出:
     * [
     *  [ 1, 2, 3 ],
     *  [ 8, 9, 4 ],
     *  [ 7, 6, 5 ]
     * ]
     */

    public static void main(String[] args) {
        int[][] arr = generateMatrix(5);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        if (n <= 0) {
            return null;
        }
        int[][] matrix = new int[n][n];
        int row = 0;
        int count = 1;
        while (row < (n + 1) / 2) {
            for (int i = row; i < n-row; i++) {
                matrix[row][i] = count;
                count++;
            }
            for (int i = row + 1; i < n - row - 1; i++) {
                matrix[i][n - row - 1] = count;
                count++;
            }
            if (n - 1 - row > row) {
                for (int i = n - 1 - row; i >= row; i--) {
                    matrix[n - row - 1][i] = count;
                    count++;
                }
                for (int i = n - 2 - row; i > row; i--) {
                    matrix[i][row] = count;
                    count++;
                }
            }
            row++;
        }

        return matrix;
    }
}
