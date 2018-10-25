package algorithm.linklist;

/**
 * 实现反转单向链表和双向链表，若链表长度为N，要求时间复杂度为O(N),空间复杂度为O(1)
 */
public class Test04 {
    public static void main(String[] args) {
        Node h1 = new Node(0);
        Node h2 = h1;
        for (int i = 2; i < 20; i += 2) {
            h2.next = new Node(i);
            h2 = h2.next;
        }

        Node h3 = reverseList(h1);
        while (h3 != null) {
            System.out.print(h3.value + " ");
            h3 = h3.next;
        }
    }

    // 反转单向链表
    public static Node reverseList(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 反转双向链表
    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
