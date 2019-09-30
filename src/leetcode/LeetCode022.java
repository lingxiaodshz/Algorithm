package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode022 {
    /**
     * 22. 括号生成
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * 例如，给出 n = 3，生成结果为：
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     *
     * 注意：此题采用的是二叉树深度优先搜索算法，需要学习
     */

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(0, 0, "", list, n);
        return list;
    }

    private static void generate(int left, int right, String str, List<String> list, int n) {
        //如果左右括号数量都是n，那就是结果集了
        if (left == n && right == n) {
            list.add(str);
            return;
        }
        //递归过程中，如果left还小于n，继续增加左括号
        if (left < n) {
            generate(left + 1, right, str + "(", list, n);
        }
        //如果发现左括号数量大于右括号了，马上增加一个右括号
        if (left > right) {
            generate(left, right + 1, str + ")", list, n);
        }
    }
}
