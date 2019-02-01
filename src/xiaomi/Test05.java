package xiaomi;

import java.util.Arrays;

/*
找出旋转有序数列的中间值
序号：#5
难度：一般
时间限制：1000ms
内存限制：10M
描述
给出一个有序数列随机旋转之后的数列，如原有序数列为：[0,1,2,4,5,6,7] ，旋转之后为[4,5,6,7,0,1,2]。 假定数列中无重复元素，且数列长度为奇数。 求出旋转数列的中间值。如数列[4,5,6,7,0,1,2]的中间值为4。
输入
4,5,6,7,0,1,2
输出
4
输入样例
1
1,2,3
4,5,6,7,0,1,2
12,13,14,5,6,7,8,9,10
 复制样例
输出样例
1
2
4
9
 */
public class Test05 {

    public static void main(String[] args) {
        System.out.println(solution("1"));
        System.out.println(solution("1,2,3"));
        System.out.println(solution("4,5,6,7,0,1,2"));
        System.out.println(solution("12,13,14,5,6,7,8,9,10"));
    }

    private static String solution(String line) {
        String[] arr = line.split(",");
        int len = arr.length;
        if (len == 1) {
            return arr[0];
        }
        Integer[] intArr = new Integer[arr.length];
        for (int i = 0; i < len; i++) {
            intArr[i] = Integer.valueOf(arr[i]);
        }
        Arrays.sort(intArr);
        return String.valueOf(intArr[len/2]);
    }

}
