package leetcode;

public class LeetCode061 {
    /**
     * 旋转链表
     *
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     * 示例 1:
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     * 示例 2:
     * 输入: 0->1->2->NULL, k = 4
     * 输出: 2->0->1->NULL
     * 解释:
     * 向右旋转 1 步: 2->0->1->NULL
     * 向右旋转 2 步: 1->2->0->NULL
     * 向右旋转 3 步: 0->1->2->NULL
     * 向右旋转 4 步: 2->0->1->NULL
     */

    public static void main(String[] a) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        head.next = head2;

        ListNode temp = rotateRight(head, 0);

        while (temp.next != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curNode = head;
        ListNode preNode = null;
        int len = 1;
        while (curNode.next != null) {
            curNode = curNode.next;
            len++;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        preNode = curNode;
        curNode.next = head;
        curNode = head;
        int temp = len - k;
        while (temp-- > 0) {
            curNode = curNode.next;
            preNode = preNode.next;
        }
        head = curNode;
        preNode.next = null;
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
