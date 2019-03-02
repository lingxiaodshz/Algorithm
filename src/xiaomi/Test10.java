package xiaomi;

public class Test10 {
    /*
    斐波纳契数列
查找斐波纳契数列中第 N 个数。
所谓的斐波纳契数列是指：
前2个数是 0 和 1 。
第 i 个数是第 i-1 个数和第i-2 个数的和。
斐波纳契数列的前10个数字是：
0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
样例
样例  1:
	输入:  1
	输出: 0
	样例解释:
	返回斐波那契的第一个数字，是0.
样例 2:
	输入:  2
	输出: 1
	样例解释:
	返回斐波那契的第二个数字是1.
注意事项
在测试数据中第 N 个斐波那契数不会超过32位带符号整数的表示范围
     */
    public int fibonacci(int n) {
        if (n <= 0) {
            return -1;
        }
        int s1 = 0;
        int s2 = 1;
        for (int i = 1; i < n; i++) {
            s2 = s1 + s2;
            s1 = s2 - s1;
        }
        return s1;
    }
}
