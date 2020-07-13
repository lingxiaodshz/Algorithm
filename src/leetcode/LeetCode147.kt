package leetcode

/*
147. 对链表进行插入排序
插入排序算法：
插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。
示例 1：
输入: 4->2->1->3
输出: 1->2->3->4
示例 2：
输入: -1->5->3->4->0
输出: -1->0->3->4->5
 */

fun main(args: Array<String>) {
    var node1 = ListNode(4)
    var node2 = ListNode(2)
    var node3 = ListNode(1)
    var node4 = ListNode(3)

    node1.next = node2
    node2.next = node3
    node3.next = node4

    var cur = insertionSortList(node1)

    while (cur != null) {
        println(cur.`val`)
        cur = cur.next
    }
}

fun insertionSortList(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    var pre :ListNode? = null
    var cur :ListNode? = head
    var next :ListNode? = head
    while (cur != null) {
        next = next?.next
        pre = doInsert(pre, cur)
        cur = next
    }

    cur = pre
    next = pre
    pre = null
    while (cur != null) {
        next = next?.next
        cur.next = pre
        pre = cur
        cur = next
    }

    return pre
}

fun doInsert(pre: ListNode?, cur: ListNode?): ListNode? {
    var tempPre = pre;
    if (pre == null || cur?.`val`!! > pre.`val`) {
        cur?.next = pre
        tempPre = cur
        return tempPre
    }
    var head = pre
    var next = head.next
    while (next != null) {
        if (cur.`val` < next.`val`) {
            head = next
            next = head.next
        } else {
            head?.next = cur
            cur.next = next
            break
        }
    }
    if (next == null) {
        head?.next = cur
        cur.next = null
    }
    return pre
}
