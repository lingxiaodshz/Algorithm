package test01;

/**
 * ���һ���㷨�������n�׳���β����ĸ���
 */
public class Test02 {

	public static void main(String[] args) {
		Test02 test02 = new Test02();
		System.out.println(test02.countZero(11));
	}

	public long countZero(long x) {
		if (x < 1) {
			return 0;
		}
		long temp = x;
		long sum = 0;

		while (temp / 5 != 0) {
			sum += temp / 5;
			temp = temp / 5;
		}

		return sum;
	}

}
