package leetcode;

public class LeetCode042 {
    /**
     * 42. 接雨水
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
     * 示例:
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     */

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {
        int count = 0;
        int len = height.length;
        int i = 0;
        int right = 0;
        int left = 0;
        int min = 0;
        while (i < len - 1) {
            while (i + 1 < len && height[i + 1] >= height[i]) {
                i++;
            }
            left = i;
            i++;
            right = searchMaxIndex(height, i, height[left]);
            min = Math.min(height[left], height[right]);
            for (int j = right - 1; j > left; j--) {
                if (height[j] <= min) {
                    count += min - height[j];
                }
            }
            i = right;
        }
        return count;
    }

    private static int searchMaxIndex(int[] height, int start, int target) {
        int len = height.length;
        for (int i = start; i < len; i++) {
            if (height[i] >= target) {
                return i;
            }
        }
        int maxIndex;
        while (start + 1 < len && height[start + 1] <= height[start]) {
            start++;
        }
        start++;
        maxIndex = start;
        while (start + 1 < len) {
            start++;
            if (height[start] > height[maxIndex]) {
                maxIndex = start;
            }
        }
        if (maxIndex >= len) {
            return len - 1;
        }
        return maxIndex;
    }
}
