package leetcode;

public class LeetCode086 {
    /**
     * 86. 分隔链表
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     * 你应当保留两个分区中每个节点的初始相对位置。
     * 示例:
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     */

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode head = partition(listNode1, 3);
        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    private static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode smallNode = null, largeNode = null, firstNode = null, secNode = null;
        while (head != null) {
            if (head.val < x) {
                if (smallNode == null) {
                    smallNode = head;
                    firstNode = smallNode;
                } else {
                    smallNode.next = head;
                    smallNode = smallNode.next;
                }
            } else {
                if (largeNode == null) {
                    largeNode = head;
                    secNode = largeNode;
                } else {
                    largeNode.next = head;
                    largeNode = largeNode.next;
                }
            }
            head = head.next;
            if (smallNode != null) {
                smallNode.next = null;
            }
            if (largeNode != null) {
                largeNode.next = null;
            }
        }
        if (smallNode != null) {
            smallNode.next = secNode;
            return firstNode;
        } else {
            return secNode;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
