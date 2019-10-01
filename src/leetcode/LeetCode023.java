package leetcode;

import com.sun.imageio.plugins.common.I18N;

public class LeetCode023 {
    /**
     * 23. 合并K个排序链表
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * 示例:
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     */

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(4);
//        ListNode listNode3 = new ListNode(5);
//        ListNode listNode4 = new ListNode(1);
//        ListNode listNode5 = new ListNode(3);
//        ListNode listNode6 = new ListNode(4);
//        ListNode listNode7 = new ListNode(2);
//        ListNode listNode8 = new ListNode(6);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
//        listNode7.next = listNode8;

//        ListNode[] listNodes = {listNode1, listNode4, listNode7};
        ListNode[] listNodes = {listNode1};

        ListNode head = mergeKLists(listNodes);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode head = null, cur = null;
        int min = 0;
        int index = -1;
        int count = lists.length;
        boolean flag = false;
        boolean isInitHead = false;
        while (count > 0) {
            flag = false;
            count = lists.length;
            for (int i = 0, len = lists.length; i < len; i++) {
                if (lists[i] != null) {
                    if (!flag) {
                        min = lists[i].val;
                        index = i;
                        flag = true;
                    } else {
                        if (lists[i].val < min) {
                            min = lists[i].val;
                            index = i;
                        }
                    }

                } else {
                    count--;
                }
            }
            if (index >= 0) {
                if (!isInitHead) {
                    head = lists[index];
                    lists[index] = lists[index].next;
                    head.next = null;
                    cur = head;
                    isInitHead = true;
                } else {
                    cur.next = lists[index];
                    lists[index] = lists[index].next;
                    cur = cur.next;
                    cur.next = null;
                }
                index = -1;
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
