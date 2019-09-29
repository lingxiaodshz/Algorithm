package leetcode;

public class LeetCode019 {
    /**
     * 19. 删除链表的倒数第N个节点
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     * 给定的 n 保证是有效的。
     * 进阶：
     * 你能尝试使用一趟扫描实现吗？
     *
     * 注意：此题的主要考察思路应该是先一个指针往下走，走到第n步的时候另一个指针开始走
     * 注意：有可能是删除的是最末尾的，或者是第一个，如果是第一个，n>0，需要特殊处理，因为head指向下一个
     */

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head, nNode = head;
        while (cur.next != null) {
            if (n > 0) {
                n--;
            } else {
                nNode = nNode.next;
            }
            cur = cur.next;
        }
        if (n > 0) {
            nNode = nNode.next;
            head = nNode;
        } else {
            if (nNode.next != null) {
                nNode.next = nNode.next.next;
            }
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
