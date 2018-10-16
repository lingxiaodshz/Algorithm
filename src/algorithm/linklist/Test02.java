package algorithm.linklist;

// 删除单链表和双链表中倒数第K个元素
public class Test02 {
    public static void main(String[] args) {
        Node h1 = new Node(0);
        Node h3 = h1;
        for (int i = 2; i < 20; i += 2) {
            h3.next = new Node(i);
            h3 = h3.next;
        }
        removeLastKNode(h1, 2);
        while (h1 != null) {
            System.out.println(h1.value);
            h1 = h1.next;
        }
    }

    // 单链表
    public static Node removeLastKNode(Node head,int k) {
        if (head == null || k < 1) {
            return head;
        }
        Node current = head;
        while (current != null) {
            k--;
            current = current.next;
        }
        if (k == 0) {
            head = head.next;
        }
        if (k < 0) {
            current = head;
            while (++k != 0) {
                current = current.next;
            }
            current.next = current.next.next;
        }

        return head;
    }

    // 双链表
    public static DoubleNode removeLastKDoubleNode(DoubleNode head, int k) {
        if (head == null || k < 1) {
            return head;
        }
        DoubleNode current = head;
        while (current != null) {
            k--;
            current = current.next;
        }
        if (k == 0) {
            head = head.next;
        }
        if (k < 0) {
            current = head;
            while (++k != 0) {
                current = current.next;
            }
            DoubleNode newNext = current.next.next;
            current.next = newNext;
            if (newNext != null) {
                newNext.last = current;
            }
        }
        return head;
    }

}
