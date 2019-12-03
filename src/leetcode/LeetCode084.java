package leetcode;

public class LeetCode084 {
    /**
     * 84. 柱状图中最大的矩形
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
     * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
     * 示例:
     * 输入: [2,1,5,6,2,3]
     * 输出: 10
     */

    public static void main(String[] args) {
//        int[] heights = {2,1,5,6,2,3};
        int[] heights = {2,2};
        System.out.println(largestRectangleArea(heights));
    }

    private static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int minHeight;
        int maxArea = 0;
        int tempArea;
        for (int i = 0; i < heights.length; i++) {
            minHeight = -1;
            for (int j = i; j < heights.length; j++) {
                if (minHeight < 0) {
                    minHeight = heights[j];
                } else {
                    if (heights[j] < minHeight) {
                        minHeight = heights[j];
                    }
                }
                tempArea = minHeight * (j - i + 1);
                if (tempArea > maxArea) {
                    maxArea = tempArea;
                }
            }
        }
        return maxArea;
    }
}
