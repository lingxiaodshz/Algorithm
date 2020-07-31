package leetcode

import java.util.*

/*
116. 填充每个节点的下一个右侧节点指针
给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。
示例：
输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
提示：
你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */

fun main(args: Array<String>) {
    var node1 = Node(1)
    var node2 = Node(2)
    var node3 = Node(3)
    var node4 = Node(4)
    var node5 = Node(5)
    var node6 = Node(6)
    var node7 = Node(7)

    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5
    node3.left = node6
    node3.right = node7

    connect(node1)
}

fun connect(root: Node?): Node? {
    if (root == null) {
        return root
    }
    var queue = LinkedList<Node>()
    queue.push(root)
    var size = 0
    var curNode = root
    var preNode = root
    var len = 0
    while (!queue.isEmpty()) {
        size = queue.size
        len = size
        if (size > 1) {
            while (len > 0) {
                curNode = queue.pop()
                if (curNode.left != null) {
                    queue.add(curNode.left!!)
                }
                if (curNode.right != null) {
                    queue.add(curNode.right!!)
                }
                if (len == size) {
                    preNode = curNode
                } else {
                    preNode?.next = curNode
                    preNode = preNode?.next
                }
                len--
            }
        } else {
            curNode = queue.pop()
            if (curNode.left != null) {
                queue.add(curNode.left!!)
            }
            if (curNode.right != null) {
                queue.add(curNode.right!!)
            }
        }
    }
    return root
}