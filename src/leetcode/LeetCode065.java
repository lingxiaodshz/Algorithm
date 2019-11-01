package leetcode;

public class LeetCode065 {
    /**
     * 65. 有效数字
     * 验证给定的字符串是否可以解释为十进制数字。
     * 例如:
     * "0" => true
     * " 0.1 " => true
     * "abc" => false
     * "1 a" => false
     * "2e10" => true
     * " -90e3   " => true
     * " 1e" => false
     * "e3" => false
     * " 6e-1" => true
     * " 99e2.5 " => false
     * "53.5e93" => true
     * " --6 " => false
     * "-+3" => false
     * "95a54e53" => false
     * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
     * 数字 0-9
     * 指数 - "e"
     * 正/负号 - "+"/"-"
     * 小数点 - "."
     * 当然，在输入中，这些字符的上下文也很重要。
     */

    public static void main(String[] args) {
//        System.out.println(isNumber("0"));
//        System.out.println(isNumber("0.1"));
//        System.out.println(isNumber("abc"));
//        System.out.println(isNumber("1 a"));
//        System.out.println(isNumber("2e10"));
//        System.out.println(isNumber("-90e3"));
//        System.out.println(isNumber("1e"));
//        System.out.println(isNumber("e3"));
//        System.out.println(isNumber("6e-1"));
//        System.out.println(isNumber("99e2.5"));
//        System.out.println(isNumber("53.5e93"));
//        System.out.println(isNumber("--6"));
//        System.out.println(isNumber("-+3"));
//        System.out.println(isNumber("95a54e53"));
//        System.out.println(isNumber("4e+"));
//        System.out.println(isNumber(" "));
//        System.out.println(isNumber(".1"));
//        System.out.println(isNumber("1."));
//        System.out.println(isNumber("."));
        System.out.println(isNumber("46.e3"));

    }

    public static boolean isNumber(String s) {
        String str = s.trim();
        if (str.length() == 0) {
            return false;
        }
        if (str.startsWith("+") || str.startsWith("-")) {
            str = str.substring(1);
            if (str.length() == 0) {
                return false;
            }
        }
        if (str.startsWith("+") || str.startsWith("-")) {
            return false;
        }
        if (str.endsWith("+") || str.endsWith("-")) {
            return false;
        }
        if (str.startsWith("e") || str.endsWith("e")) {
            return false;
        }
        return isContainChar(str);
    }

    private static boolean isContainChar(String s) {
        char c;
        int indexPoint = -1;
        int indexE = -1;
        for (int i = 0, len = s.length(); i < len; i++) {
            c = s.charAt(i);
            if (c == '.') {
                if (s.length() == 1) {
                    return false;
                }
                if (i == 0) {
                    if (i + 1 < len) {
                        char c2 = s.charAt(i + 1);
                        if ((c2 >= '0' && c2 <= '9')) {
                            if (indexPoint != -1) {
                                return false;
                            }
                            indexPoint = i;
                            if (indexE != -1 && indexPoint > indexE) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                } else if (i == len - 1) {
                    if (i > 0) {
                        char c2 = s.charAt(i - 1);
                        if ((c2 >= '0' && c2 <= '9')) {
                            if (indexPoint != -1) {
                                return false;
                            }
                            indexPoint = i;
                            if (indexE != -1 && indexPoint > indexE) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    char c1 = s.charAt(i - 1);
                    char c2 = s.charAt(i + 1);
                    if ((c1 >= '0' && c1 <= '9') && ((c2 >= '0' && c2 <= '9') || c2 == 'e')) {
                        if (indexPoint != -1) {
                            return false;
                        }
                        indexPoint = i;
                        if (indexE != -1 && indexPoint > indexE) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
            if (c == 'e') {
                char c1 = s.charAt(i - 1);
                char c2 = s.charAt(i + 1);
                if (c2 == '+' || c2 == '-') {
                    char c3 = s.charAt(i + 2);
                    if (!(c3 >= '0' && c3 <= '9')) {
                        return false;
                    }
                } else {
                    if (((c1 >= '0' && c1 <= '9') || c1 == '.') && (c2 >= '0' && c2 <= '9')) {
                        if (indexE != -1) {
                            return false;
                        }
                        indexE = i;
                    } else {
                        return false;
                    }
                }
            }
            if (c == '+' || c == '-') {
                char c1 = s.charAt(i - 1);
                char c2 = s.charAt(i + 1);
                if (!(c1 == 'e') && (c2 >= '0' && c2 <= '9')) {
                    return false;
                }
            }
            if (!((c >= '0' && c <= '9') || (c == 'e') || c == '.' || c == '+' || c == '-')) {
                return false;
            }
        }
        return true;
    }
}
