package leetcode;

public class LeetCode092 {
    /**
     * 92. 反转链表 II
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     * 示例:
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     */

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
//        ListNode listNode6 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
//        listNode5.next = listNode6;

        ListNode head = reverseBetween(listNode1, 1, 2);
        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        if (m == n) {
            return head;
        }
        ListNode cur = head, start = null, pre = null, temp = null, end = null;

        int count = 1;
        while (cur != null) {
            if (count == m - 1) {
                pre = cur;
            }
            if (count == m) {
                start = cur;
                end = start;
            }
            if (count == n + 1) {
                end.next = cur;
                break;
            }
            if (count > m && count <= n) {
                temp = cur;
                cur = cur.next;
                temp.next = start;
                start = temp;
                end.next = null;
            } else {
                cur = cur.next;
            }
            count++;
        }
        if (pre == null) {
            head = start;
        } else {
            pre.next = start;
        }
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
