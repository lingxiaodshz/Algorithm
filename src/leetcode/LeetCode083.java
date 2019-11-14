package leetcode;

public class LeetCode083 {
    /**
     * 83. 删除排序链表中的重复元素
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * 示例 1:
     * 输入: 1->1->2
     * 输出: 1->2
     * 示例 2:
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     */

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode head = deleteDuplicates(listNode1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, next = head.next;
        while (next != null) {
            if (cur.val != next.val) {
                cur.next = next;
                cur = cur.next;
            }
            next = next.next;
        }
        cur.next = null;
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
