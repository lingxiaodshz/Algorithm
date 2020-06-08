package leetcode

/*
* 125. 验证回文串
* 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。
示例 1:
输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:
输入: "race a car"
输出: false
* */

fun main(args: Array<String>) {
//    var str = "A man, a plan, a canal: Panama"
    var str = "race a car"
    println(isPalindrome(str))
}


fun isPalindrome(s: String): Boolean {
    var left = 0
    var right = s.length - 1
    var starC: Char? = null
    var endC: Char? = null
    while (left < right) {
        starC = s[left]
        if (!isValid(starC)) {
            left++
            continue
        }
        endC = s[right]
        if (!isValid(endC)) {
            right--
            continue
        }
        if (starC.toLowerCase() != endC.toLowerCase()) {
            return false
        } else {
            left++
            right--
        }
    }

    return true
}

// 是否为字母或者数字
fun isValid(c: Char): Boolean {
    if (c.isDigit() || c.isLetter()) {
        return true
    }
    return false
}