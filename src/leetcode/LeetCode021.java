package leetcode;

public class LeetCode021 {
    /**
     * 21. 合并两个有序链表
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur1 = l1, cur2 = l2, head = null, temp = null;
        boolean isInit = false;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                if (!isInit) {
                    head = cur1;
                    temp = cur1;
                    isInit = true;
                } else {
                    temp.next = cur1;
                    temp = temp.next;
                }
                cur1 = cur1.next;
            } else {
                if (!isInit) {
                    head = cur2;
                    temp = cur2;
                    isInit = true;
                } else {
                    temp.next = cur2;
                    temp = temp.next;
                }
                cur2 = cur2.next;
            }
        }
        if (cur1 == null && cur2 != null) {
            temp.next = cur2;
        }
        if (cur1 != null && cur2 == null) {
            temp.next = cur1;
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
