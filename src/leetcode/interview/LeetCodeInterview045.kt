package leetcode.interview

/**
 * 面试题45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * 提示:
 * 0 < nums.length <= 100
 * 说明:
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 */

fun main(args: Array<String>) {
    var nums = intArrayOf(10,2)
    println(minNumber(nums))
}

fun minNumber(nums: IntArray): String {
    heapSort(nums)
    var sb = StringBuilder()
    for (i in nums) {
        sb.append(i)
    }
    return sb.toString()
}

fun heapSort(nums: IntArray) {
    var len = nums.size / 2 - 1
    while (len >= 0) {
        buildSort(nums, nums.size, len)
        len--
    }
    len = nums.size - 1
    while (len > 0) {
        swap(nums, len, 0)
        buildSort(nums, len, 0)
        len--
    }
}

fun buildSort(nums: IntArray, len: Int, i: Int) {
    var j = i;
    var k = 2 * j + 1
    while (k < len) {
        if (k + 1 < len && judge(nums[k], nums[k + 1])) {
            k++
        }
        if (judge(nums[j], nums[k])) {
            swap(nums, k, j)
            j = k
            k = 2 * j + 1
        } else {
            break
        }

    }
}

fun swap(nums: IntArray, k: Int, j: Int) {
    var temp = nums[k]
    nums[k] = nums[j]
    nums[j] = temp
}

fun judge(a: Int, b: Int): Boolean {
    var i: String = "" + a + b
    var j = "" + b + a
    return i.compareTo(j) < 0
}
