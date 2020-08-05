package leetcode

/*
119. 杨辉三角 II
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。
示例:
输入: 3
输出: [1,3,3,1]
进阶：
你可以优化你的算法到 O(k) 空间复杂度吗？
 */

fun getRow(rowIndex: Int): List<Int> {
    var list = mutableListOf<Int>()
    var tempList = mutableListOf<Int>()
    var curList = list
    var preList = tempList
    if (rowIndex == 0) {
        curList.add(1)
    } else if (rowIndex >= 1) {
        for (i in 2..rowIndex + 1) {
            if (i % 2 == 0) {
                curList = tempList
                preList = list
            } else {
                curList = list
                preList = tempList
            }
            curList.clear()
            curList.add(1)
            curList.add(1)
            if (i > 2) {
                for (j in 0 until preList.size - 1) {
                    curList.add(curList.size - 1, preList[j] + preList[j + 1])
                }
            }
        }
    }
    return curList
}