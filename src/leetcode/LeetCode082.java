package leetcode;

import java.util.List;

public class LeetCode082 {
    /**
     * 82. 删除排序链表中的重复元素 II
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     * 示例 1:
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * 示例 2:
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     */

    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
//        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        ListNode head = deleteDuplicates(listNode0);
        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode first = null;
        ListNode next = cur.next;
        while (first == null && next != null) {
            if (next.val != cur.val) {
                first = cur;
            } else {
                while (next != null && next.val == cur.val) {
                    next = next.next;
                }
                cur = next;
                if (cur != null) {
                    next = cur.next;
                }
            }
        }
        if (first == null) {
            first = cur;
        }
        if (cur != null) {
            next = cur.next;
            int temp;
            while (next != null) {
                temp = next.val;
                if (next.next != null) {
                    if (next.next.val != temp) {
                        cur = next;
                        next = cur.next;
                    } else {
                        while (next.next != null && next.next.val == temp) {
                            next = next.next;
                        }
                        cur.next = next.next;
                        next = cur.next;
                    }
                } else {
                    next = next.next;
                }
            }
        }
        return first;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
