package leetcode

import java.util.*

/*
144. 二叉树的前序遍历
给定一个二叉树，返回它的 前序 遍历。
 示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [1,2,3]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

/*
--------------------递归方式-------------------
fun preorderTraversal(root: TreeNode?): List<Int> {
    var list = ArrayList<Int>()
    preOrder(root, list)
    return list
}

fun preOrder(root: TreeNode?, list: ArrayList<Int>) {
    if (root == null) {
        return
    }
    list.add(root.`val`)
    preOrder(root.left, list)
    preOrder(root.right, list)
}
*/

/*
--------------------非递归方式-------------------
*/
fun preorderTraversal(root: TreeNode?): List<Int> {
    var list = mutableListOf<Int>()
    if (root == null) {
        return list
    }
    var stack = Stack<TreeNode>()
    var curNode: TreeNode? = null
    stack.push(root)
    while (!stack.empty()) {
        curNode = stack.pop()
        list.add(curNode.`val`)
        if (curNode.right != null) {
            stack.push(curNode.right)
        }
        if (curNode.left != null) {
            stack.push(curNode.left)
        }
    }
    return list
}