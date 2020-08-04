package leetcode

/*
118. 杨辉三角
在杨辉三角中，每个数是它左上方和右上方的数的和。
示例:
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

fun generate(numRows: Int): List<List<Int>> {
    var lists = mutableListOf<List<Int>>()
    if (numRows == 1) {
        var list = mutableListOf<Int>()
        list.add(1)
        lists.add(list)
    } else if (numRows >= 2) {
        var list1 = mutableListOf<Int>()
        list1.add(1)
        lists.add(list1)
        for (i in 2..numRows) {
            var list2 = mutableListOf<Int>()
            list2.add(1)
            list2.add(1)
            if (i > 2) {
                var preList = lists[lists.size - 1]
                for (j in 0 until preList.size - 1) {
                    list2.add(list2.size - 1, preList[j] + preList[j + 1])
                }
            }
            lists.add(list2)
        }
    }
    return lists
}