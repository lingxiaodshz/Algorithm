package leetcode;

public class LeetCode234 {
    /**
     * 234. 回文链表
     * 请判断一个链表是否为回文链表。
     * 示例 1:
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
//        listNode5.next = listNode6;

        System.out.println(isPalindrome(listNode1));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head, pre = null, cur = null;
        while (fast.next != null && fast.next.next != null) {
            if (cur != null) {
                pre = cur;
            }
            cur = slow;
            slow = slow.next;
            fast = fast.next.next;
            cur.next = pre;
        }

        if (fast.next == null) {
            slow = slow.next;
        }
        if (fast.next != null && fast.next.next == null) {
            pre = cur;
            cur = slow;
            slow = slow.next;
            cur.next = pre;
        }

        while (cur != null && slow != null) {
            if (cur.val != slow.val) {
                return false;
            }
            cur = cur.next;
            slow = slow.next;
        }

        return true;

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
