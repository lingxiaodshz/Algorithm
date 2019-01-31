package xiaomi;

/*
描述
一个屋子有 n 个开关控制着 n 盏灯，但奇怪的是，每个开关对应的不是一盏灯，而是 n-1 盏灯，每次按下这个开关，其对应的 n-1 盏灯就会由亮变灭，或者由灭变亮。保证不会有两个开关控制同样的 n-1 盏灯。
现在刘同学想把灯全部开好，但是这些灯一开始的状态非常乱，刘同学想知道最少需要按多少次开关才能使所有灯全部亮起。
输入
单组数据输入，每组数据一行，两个数 n,l 分别代表灯的数量、最开始时亮着的灯的数量（1<l<n<10000000000）。
输出
每组数据输出一个数，即能使所有灯全部亮起的最少的按开关的次数，如果无法做到灯全部亮起，输出“Impossible”
输入样例
4 2
复制样例
输出样例
2
*/
public class Test01 {
    private static String solution(String line) {
        if (line == null) {
            return "Impossible";
        }
        String[] datas = line.split(" ");
        if (datas.length != 2) {
            return "Impossible";
        }
        long n = Long.valueOf(datas[0]);
        long l = Long.valueOf(datas[1]);
        if (n % 2 == 0 && l % 2 == 0) {
            return String.valueOf(n - l);
        } else if (n % 2 == 1 && l % 2 == 0) {
            return "Impossible";
        } else if (n % 2 == 0 && l % 2 == 1) {
            return String.valueOf(l);
        } else {
            return String.valueOf(n - l < l ? n - l : l);
        }
    }
}
