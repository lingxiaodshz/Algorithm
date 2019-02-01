package xiaomi;

/*
第一个缺失正数
序号：#7
难度：有挑战
时间限制：1000ms
内存限制：10M
描述
给出一个无序的数列，找出其中缺失的第一个正数，要求复杂度为 O(n) 如：[1,2,0]，第一个缺失为3。 如：[3,4,-1,1]，第一个缺失为2。
输入
1,2,0
输出
3
输入样例
1,2,0
3,4,-1,1
-1,-3,-5
1,2,3
-1,-10,0
 复制样例
输出样例
3
2
1
4
1
 */
public class Test07 {
    public static void main(String[] args) {
        String line1 = "1,2,0";
        String line2 = "3,4,-1,1";
        String line3 = "-1,-3,-5";
        String line4 = "1,2,3";
        String line5 = "-1,-10,0";
        System.out.println(solution(line1));
        System.out.println(solution(line2));
        System.out.println(solution(line3));
        System.out.println(solution(line4));
        System.out.println(solution(line5));
    }

    private static String solution(String line) {
        String[] arr = line.split(",");
        int len = arr.length;
        int[] intArr = new int[len];

        for (int i = 0; i < len; i++) {
            if (Integer.valueOf(arr[i]) > 0 && Integer.valueOf(arr[i]) <= len) {
                intArr[Integer.valueOf(arr[i]) - 1] = Integer.valueOf(arr[i]);
            }
        }

        int i = 1;
        for (; i <= len; i++) {
            if (intArr[i - 1] != i) {
                break;
            }
        }
        return String.valueOf(i);
    }
}
