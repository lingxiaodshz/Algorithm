package leetcode

/*
109. 有序链表转换二叉搜索树
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
示例:
给定的有序链表： [-10, -3, 0, 5, 9],
一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
      0
     / \
   -3   9
   /   /
 -10  5
 */
fun main(args: Array<String>) {
    var node1 = ListNode(-10)
    var node2 = ListNode(-3)
    var node3 = ListNode(0)
    var node4 = ListNode(5)
    var node5 = ListNode(9)

    node1.next = node2
    node2.next=node3
    node3.next=node4
    node4.next=node5

    sortedListToBST(node1)

}


fun sortedListToBST(head: ListNode?): TreeNode? {
    if (head == null) {
        return null
    }
    var midListNode = getMidNode(head)
    var nextListNode = midListNode?.next
    var treeNode: TreeNode? = null
    if (midListNode != null) {
        treeNode = TreeNode(midListNode.`val`)
        midListNode?.next = null
        treeNode.left = sortedListToBST(head)
        treeNode.right = sortedListToBST(nextListNode)
    } else {
        treeNode = TreeNode(head.`val`)
        treeNode.left = sortedListToBST(null)
        treeNode.right = sortedListToBST(null)
    }
    return treeNode
}

fun getMidNode(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return null
    }
    var slow = head
    var fast = head
    var pre:ListNode? = null
    while (fast?.next != null) {
        pre = slow
        slow = slow?.next
        fast = fast.next?.next
    }
    pre?.next = null
    return slow
}