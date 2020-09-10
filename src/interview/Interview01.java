package interview;

/**
 * 给定一个正整数，获得大于当前整数的最小2的n次方数
 * 例如，给定4，返回4；给定4，返回8
 */
public class Interview01 {
    public static void main(String[] args) {
        System.out.println(getMinInt(8));
    }

    public static int getMinInt(int n) {
        int min = 1;
        while (n != 0) {
            min *= 2;
            n = n >> 1;
        }
        return min;
    }
}
