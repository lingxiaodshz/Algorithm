package leetcode;

import java.util.HashMap;

public class Test01 {
    /**
     * 气球问题
     *
     * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
     * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
     * 示例 1：
     * 输入：text = "nlaebolko"
     * 输出：1
     * 示例 2：
     * 输入：text = "loonbalxballpoon"
     * 输出：2
     * 示例 3：
     * 输入：text = "leetcode"
     * 输出：0
     * 提示：
     * 1 <= text.length <= 10^4
     * text 全部由小写英文字母组成
     *
     * @param text
     * @return
     */
    public int maxNumberOfBalloons(String text) {
        if (text == null || text.equals("")) {
            return 0;
        }
        if (text.length() < 7) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>(8);
        map.put('b', 0);
        map.put('a', 0);
        map.put('l', 0);
        map.put('o', 0);
        map.put('n', 0);
        for (int i = 0, len = text.length(); i < len; i++) {
            if (text.charAt(i) == 'b') {
                map.put('b', map.get('b') + 1);
            }
            if (text.charAt(i) == 'a') {
                map.put('a', map.get('a') + 1);
            }
            if (text.charAt(i) == 'l') {
                map.put('l', map.get('l') + 1);
            }
            if (text.charAt(i) == 'o') {
                map.put('o', map.get('o') + 1);
            }
            if (text.charAt(i) == 'n') {
                map.put('n', map.get('n') + 1);
            }
        }
        int min = 0;
        if (map.get('b') == null) {
            return 0;
        } else {
            min = map.get('b');
        }
        if (map.get('a') == null) {
            return 0;
        } else {
            if (min > map.get('a')) {
                min = map.get('a');
            }
        }
        if (map.get('l') == null) {
            return 0;
        } else {
            if (min > map.get('l') / 2) {
                min = map.get('l') / 2;
            }
        }
        if (map.get('o') == null) {
            return 0;
        } else {
            if (min > map.get('o') / 2) {
                min = map.get('o') / 2;
            }
        }
        if (map.get('n') == null) {
            return 0;
        } else {
            if (min > map.get('n')) {
                min = map.get('n');
            }
        }
        return min;
    }
}
