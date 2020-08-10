package leetcode

import java.lang.StringBuilder

/*
168. Excel表列名称
给定一个正整数，返回它在 Excel 表中相对应的列名称。
例如，
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
示例 1:
输入: 1
输出: "A"
示例 2:
输入: 28
输出: "AB"
示例 3:
输入: 701
输出: "ZY"
 */

fun main(args: Array<String>) {
    println(convertToTitle(1))
    println(convertToTitle(28))
    println(convertToTitle(701))
    println(convertToTitle(702))
    println(convertToTitle(703))
    println(convertToTitle(26))
    println(convertToTitle(52))
}

fun convertToTitle(n: Int): String {
    var cur = n
    var sb = StringBuilder()
    var b = cur % 26
    var a = (cur - b) / 26

    while (true) {
        if (a == 0 && b == 0) {
            break
        }
        if (b > 0) {
            sb.insert(0,'A' + b - 1)
        } else {
            a--
            sb.insert(0, 'Z')
        }

        b = a % 26
        a = (a - b) / 26
    }
    return sb.toString()
}