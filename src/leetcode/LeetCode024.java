package leetcode;

public class LeetCode024 {
    /**
     * 24. 两两交换链表中的节点
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 示例:
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode head = swapPairs(listNode1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode cur = head, pre = cur;
        ListNode temp = null;
        boolean isInit = false;
        while (cur != null && cur.next != null) {
            cur = cur.next;
            pre.next = cur.next;
            cur.next = pre;
            if (!isInit) {
                head = cur;
                isInit = true;
            } else {
                temp.next = cur;
            }
            temp = pre;
            pre = pre.next;
            cur = pre;
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
