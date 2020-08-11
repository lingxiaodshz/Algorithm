package leetcode

import kotlin.math.pow

/*
171. Excel表列序号
给定一个Excel表格中的列名称，返回其相应的列序号。
例如，
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
示例 1:
输入: "A"
输出: 1
示例 2:
输入: "AB"
输出: 28
 */

fun main(args: Array<String>) {
    println(titleToNumber("A"))
    println(titleToNumber("AB"))
    println(titleToNumber("ZY"))
    println(titleToNumber("AZ"))
}

fun titleToNumber(s: String): Int {
    var cArr = s.toCharArray()
    var sum = 0
    if (s.isNotEmpty()) {
        for (i in cArr.size - 1 downTo 0) {
            sum = (sum + (cArr[i] - 'A' + 1) * Math.pow(26.0, cArr.size - 1.0 - i)).toInt()
        }
    }
    return sum
}