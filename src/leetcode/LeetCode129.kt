package leetcode

import java.util.*

/*
129. 求根到叶子节点数字之和
给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
例如，从根到叶子节点路径 1->2->3 代表数字 123。
计算从根到叶子节点生成的所有数字之和。
说明: 叶子节点是指没有子节点的节点。
示例 1:
输入: [1,2,3]
    1
   / \
  2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.
示例 2:
输入: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
输出: 1026
解释:
从根到叶子节点路径 4->9->5 代表数字 495.
从根到叶子节点路径 4->9->1 代表数字 491.
从根到叶子节点路径 4->0 代表数字 40.
因此，数字总和 = 495 + 491 + 40 = 1026.
*/

fun main() {
//    var node1 = TreeNode(4)
//    var node2 = TreeNode(9)
//    var node3 = TreeNode(0)
//    var node4 = TreeNode(5)
//    var node5 = TreeNode(1)
//
//    node1.left = node2
//    node1.right = node3
//    node2.left = node4
//    node2.right = node5

    var node1 = TreeNode(1)
    var node2 = TreeNode(2)
    var node3 = TreeNode(3)

    node1.left = node2
    node1.right = node3

    println(sumNumbers(node1))

}

fun sumNumbers(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    //非递归方式
    var sum = 0
    var queue = LinkedList<TreeNode>()
    var sumQueue = LinkedList<Int>()
    queue.push(root)
    var count = 0;
    while (!queue.isEmpty()) {
        count = queue.size
        while (count > 0) {
            var node = queue.pop()
            var curValue: Int?=null
            if (sumQueue.size > 0) {
                curValue = sumQueue.pop()
            }
            if (node.left != null || node.right != null) {
                if (node.left != null) {
                    if (curValue != null) {
                        sumQueue.push(curValue * 10 + node.`val`)
                    } else {
                        sumQueue.push(node.`val`)
                    }
                    queue.push(node.left)
                }
                if (node.right != null) {
                    if (curValue != null) {
                        sumQueue.push(curValue * 10 + node.`val`)
                    } else {
                        sumQueue.push(node.`val`)
                    }
                    queue.push(node.right)
                }
            } else {
                if (curValue != null) {
                    sum += curValue * 10 + node.`val`
                } else {
                    sum += node.`val`
                }
            }
            count--
        }
    }

    //递归方式
//    sum(0,root)
    return sum

}

var sum :Int = 0
fun sum(a: Int, root: TreeNode) {
    if (root == null) {
        return
    }
    var temp = 10 * a + root.`val`
    if (root.left == null && root.right == null) {
        sum += temp
    }
    if (root.left != null) {
        sum(temp, root.left!!)
    }
    if (root.right != null) {
        sum(temp, root.right!!)
    }
}
