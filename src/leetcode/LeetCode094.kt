package leetcode

import java.util.*

/*
94. 二叉树的中序遍历
给定一个二叉树，返回它的中序 遍历。
示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

fun inorderTraversal(root: TreeNode?): List<Int> {
    var list = mutableListOf<Int>()
    if (root == null) {
        return list
    }
    var stack = Stack<TreeNode>()
    var curNode: TreeNode? = root
    while (curNode != null || !stack.empty()) {
        while (curNode != null) {
            stack.push(curNode)
            curNode = curNode.left
        }
        curNode = stack.pop()
        list.add(curNode.`val`)
        curNode = curNode.right
    }
    return list
}