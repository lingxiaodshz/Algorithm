package leetcode

/*
143. 重排链表
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
示例 1:
给定链表 1->2->3->4, 重新排列为 1->4->2->3.
示例 2:
给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */

fun main(agrs: Array<String>) {
    var node1: ListNode? = ListNode(1)
    var node2: ListNode? = ListNode(2)
    var node3: ListNode? = ListNode(3)
    var node4: ListNode? = ListNode(4)
//    var node5: ListNode? = ListNode(5)

    node1?.next = node2
    node2?.next = node3
    node3?.next = node4
    node4?.next = null
//    node4?.next = node5
//    node5?.next = null

    reorderList(node1)

    while (node1 != null) {
        println(node1.`val`)
        node1 = node1.next
    }
}


fun reorderList(head: ListNode?): Unit {
    var fast = head
    var slow = head

    while (fast?.next != null && fast.next?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    var node = slow?.next
    slow?.next = null

    if (node != null) {
        var head2 = reverseListNode(node)
        var temp = head
        var next: ListNode? = null
        var next2: ListNode? = null
        while (head2 != null) {
            next = temp?.next
            next2 = head2?.next
            temp?.next = head2
            head2.next = next
            temp = next
            head2 = next2
        }
    }


}

fun reverseListNode(head: ListNode?): ListNode? {
    var preNode: ListNode? = null
    var nextNode: ListNode? = null
    var curNode: ListNode? = null

    curNode = head
    nextNode = head
    while (nextNode != null) {
        curNode = nextNode
        nextNode = nextNode.next
        curNode?.next = preNode
        preNode = curNode
    }
    return curNode
}