package interview;

/**
 * 求两个数的最大公约数和两个数的最小公倍数
 */
public class Interview02 {
    public static void main(String[] args) {
        System.out.println(getMaxNum(12, 6));
        System.out.println(getMinNum(6, 6));
    }

    /**
     * 获取最大公约数
     * @param a
     * @param b
     * @return
     */
    public static int getMaxNum(int a, int b) {
        int temp = 0;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static int getMinNum(int a, int b) {
        int temp = getMaxNum(a, b);
        return a * b / temp;
    }
}
