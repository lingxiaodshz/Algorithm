package test01;

import com.sun.javafx.geom.AreaOp.AddOp;

/**
 * ������������a��b, �����ǵĺ�, ������ʹ�� + ����ѧ�������
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
