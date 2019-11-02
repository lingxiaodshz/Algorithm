package leetcode;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.util.ArrayList;
import java.util.List;

public class LeetCode068 {
    /**
     * 68. 文本左右对齐
     * 要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
     * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
     * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
     * 说明:
     * 单词是指由非空格字符组成的字符序列。
     * 每个单词的长度大于 0，小于等于 maxWidth。
     * 输入单词数组 words 至少包含一个单词。
     * 示例:
     * 输入:
     * words = ["This", "is", "an", "example", "of", "text", "justification."]
     * maxWidth = 16
     * 输出:
     * [
     *    "This    is    an",
     *    "example  of text",
     *    "justification.  "
     * ]
     * 示例 2:
     * 输入:
     * words = ["What","must","be","acknowledgment","shall","be"]
     * maxWidth = 16
     * 输出:
     * [
     *   "What   must   be",
     *   "acknowledgment  ",
     *   "shall be        "
     * ]
     * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
     *      因为最后一行应为左对齐，而不是左右两端对齐。
     *      第二行同样为左对齐，这是因为这行只包含一个单词。
     * 示例 3:
     * 输入:
     * words = ["Science","is","what","we","understand","well","enough","to","explain",
     *          "to","a","computer.","Art","is","everything","else","we","do"]
     * maxWidth = 20
     * 输出:
     * [
     *   "Science  is  what we",
     *   "understand      well",
     *   "enough to explain to",
     *   "a  computer.  Art is",
     *   "everything  else  we",
     *   "do                  "
     * ]
     */

    public static void main(String[] args) {
        String[] words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth = 20;
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//        int maxWidth = 16;
//        String[] words = {"Listen", "to", "many,", "speak", "to", "a", "few."};
//        int maxWidth = 6;
//        String[] words = {"What","must","be","acknowledgment","shall","be"};
//        int maxWidth = 16;
        List<String> list = fullJustify(words, maxWidth);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        List<String> line = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!line.isEmpty() && getLineLength(line) + 1 + word.length() > maxWidth) {
                list.add(generateLine(line, maxWidth, false));
                line.clear();
            }
            line.add(word);
        }
        if (!line.isEmpty()) {
            list.add(generateLine(line, maxWidth, true));
        }
        return list;
    }

    private static int getLineLength(List<String> line) {
        if (line == null || line.size() == 0) {
            return 0;
        }
        int lenght = 0;
        for (String str : line) {
            lenght += str.length();
        }
        lenght += line.size() - 1;
        return lenght;
    }

    private static int getLineWordLength(List<String> line) {
        int lenght = 0;
        for (String str : line) {
            lenght += str.length();
        }
        return lenght;
    }

    private static String generateLine(List<String> line, int maxWidth, boolean isLastLine) {
        StringBuilder sb = new StringBuilder();
        int size = line.size();
        sb.append(line.get(0));
        if (size == 1) {
            for (int i = 0, len = maxWidth - line.get(0).length(); i < len; i++) {
                sb.append(" ");
            }
        } else if (size > 1) {
            if (!isLastLine) {
                int len = getLineWordLength(line);
                int a = (maxWidth - len) / (size - 1);
                int b = (maxWidth - len) % (size - 1);
                StringBuilder blankSb = null;
                if (a > 0) {
                    blankSb = new StringBuilder();
                    for (int i = 0; i < a; i++) {
                        blankSb.append(" ");
                    }
                }
                for (int i = 1; i < size; i++) {
                    if (a > 0 && blankSb != null) {
                        sb.append(blankSb);
                    }
                    if (i <= b) {
                        sb.append(" ");
                    }
                    sb.append(line.get(i));
                }
            } else {
                for (int i = 1; i < size; i++) {
                    sb.append(" ");
                    sb.append(line.get(i));
                }
                for (int i = 0, len = maxWidth - sb.length(); i < len; i++) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}
