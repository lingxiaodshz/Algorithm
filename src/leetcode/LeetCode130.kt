package leetcode

/*
130. 被围绕的区域
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
示例:
X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：
X X X X
X X X X
X X X X
X O X X
解释:
被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */

fun main(args: Array<String>) {

}

fun solve(board: Array<CharArray>): Unit {
    if (board == null || board.isEmpty()) {
        return
    }
    var column = board[0].size
    var row = board.size
    if (row <= 2 || column <= 2) {
        return
    }
    for (i in 0 until row) {
        deepSearch(i, 0, board)
        deepSearch(i, column - 1, board)
    }
    for (j in 0 until column) {
        deepSearch(0, j, board)
        deepSearch(row-1, j, board)
    }
    for (i in 0 until row) {
        for (j in 0 until column) {
            if (board[i][j] == 'O') {
                board[i][j]='X'
            }
        }
    }
    for (i in 0 until row) {
        for (j in 0 until column) {
            if (board[i][j] == 'A') {
                board[i][j]='O'
            }
        }
    }
}

fun deepSearch(i: Int, j: Int, board: Array<CharArray>) {
    var row = board.size
    var column = board[0].size
    if (i in 0 until row && j in 0 until column && board[i][j] == 'O') {
        board[i][j] = 'A'
    } else {
        return
    }
    deepSearch(i - 1, j, board)
    deepSearch(i + 1, j, board)
    deepSearch(i, j - 1, board)
    deepSearch(i, j + 1, board)
}