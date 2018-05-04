package test01;

import com.sun.javafx.geom.AreaOp.AddOp;

/**
 * 给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。
 */
public class Test01 {
	public static void main(String[] args) {
		Test01 test01 = new Test01();
		System.out.println(test01.add(1000, 100));
	}

	public int add(int a, int b) {
		if (a == 0) {
			return b;
		}
		if (b == 0) {
			return a;
		}

		int sum, i;
		i = a ^ b;
		sum = (a & b) << 1;
		return add(sum, i);
	}
}
