package leetcode;

public class LeetCode025 {
    /**
     * 25. K 个一组翻转链表
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * 示例 :
     * 给定这个链表：1->2->3->4->5
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     * 说明 :
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 注意：此题如果K大于链表长度了，则不旋转
     */

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
//        ListNode listNode7 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
//        listNode6.next = listNode7;

        ListNode head = reverseKGroup(listNode1,2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode node = head;
        int n = 0;
        while (node != null) {
            n++;
            node = node.next;
            if (n >= k) {
                break;
            }
        }
        if (k > n) {
            return head;
        }
        // flagNode用于标记剩下的是否还大于K
        ListNode cur = head.next, flagNode = head.next.next, temp1 = head, temp2 = null, temp3 = null, temp4 = null;
        boolean canNext = true;
        boolean isInit = false;
        boolean isFirst = true;
        int count = k;
        while (canNext) {
            while (count > 1 && cur != null) {
                if (cur != null) {
                    if (isFirst) {
                        temp3 = temp1;
                        isFirst = false;
                    }
                    temp2 = cur;
                    cur = cur.next;
                    temp2.next = temp1;
                    temp1 = temp2;
                    count--;
                }
                if (canNext) {
                    if (flagNode != null && flagNode.next != null) {
                        flagNode = flagNode.next.next;
                    } else {
                        canNext = false;
                    }
                }
            }

            if (!isFirst) {
                temp3.next = cur;
                isFirst = true;
                if (temp4 == null) {
                    temp4 = temp3;
                } else {
                    temp4.next = temp2;
                    temp4 = temp3;
                }
            }
            if (!isInit) {
                head = temp2;
                isInit = true;
            }
            if (count == 1 && canNext) {
                count = k;
                temp1=cur;
                cur = cur.next;
                flagNode = cur.next;
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
