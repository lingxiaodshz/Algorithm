package leetcode

import java.util.*

/*
114. 二叉树展开为链表
给定一个二叉树，原地将它展开为一个单链表。
例如，给定二叉树
    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */

fun main(args: Array<String>) {
    var node1 = TreeNode(1)
    var node2 = TreeNode(2)
    var node3 = TreeNode(3)
    var node4 = TreeNode(4)
    var node5 = TreeNode(5)
    var node6 = TreeNode(6)

    node1.left = node2
    node1.right = node5
    node2.left = node3
    node2.right = node4
    node5.right = node6

    flatten(node1)
}

fun flatten(root: TreeNode?): Unit {
    if (root == null) {
        return
    }
    var stack = Stack<TreeNode>()
    stack.push(root)
    var node = root
    var curNode: TreeNode? = null
    while (!stack.isEmpty()) {
        node = stack.pop()
        if (node.right != null) {
            stack.push(node.right)
        }
        if (node.left != null) {
            stack.push(node.left)
        }
        if (curNode == null) {
            curNode = node
            curNode.left = null
            curNode.right = null
        } else {
            curNode.left = null
            curNode.right = node
            curNode = curNode.right
        }
    }
}


