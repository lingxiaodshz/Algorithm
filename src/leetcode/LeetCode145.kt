package leetcode

import java.util.*

/*
145. 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。
示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

fun postorderTraversal(root: TreeNode?): List<Int> {
    //------------------第一种方法----------------
//    var list = mutableListOf<Int>()
//    if (root == null) {
//        return list
//    }
//    var stack1 = Stack<TreeNode>()
//    var stack2 = Stack<TreeNode>()
//    var curNode :TreeNode? = null
//    stack1.push(root)
//    while (!stack1.empty()) {
//        curNode = stack1.pop()
//        stack2.push(curNode)
//        if (curNode.left != null) {
//            stack1.push(curNode.left)
//        }
//        if (curNode.right != null) {
//            stack1.push(curNode.right)
//        }
//    }
//
//    while (!stack2.empty()) {
//        curNode = stack2.pop()
//        list.add(curNode.`val`)
//    }
//
//    return list

    //------------第二种方法--------------
    var list = mutableListOf<Int>()
    if (root == null) {
        return list
    }

    var stack = Stack<TreeNode>()
    var curNode: TreeNode? = root
    var rightNode:TreeNode? = root//用来标记右子树是否走过
    while (curNode != null || !stack.empty()) {
        while (curNode != null) {
            stack.push(curNode)
            curNode = curNode.left
        }

        if (!stack.empty()) {
            curNode = stack.peek().right
            if (curNode == null || curNode == rightNode) {
                curNode = stack.pop()
                list.add(curNode.`val`)
                rightNode = curNode
                curNode = null
            }
        }
    }
    return list
}