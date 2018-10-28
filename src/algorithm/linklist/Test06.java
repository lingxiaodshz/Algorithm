package algorithm.linklist;

/**
 * 约瑟夫环
 */
public class Test06 {
    public static void main(String[] args) {
        Node h1 = new Node(1);
        Node h2 = h1;
        for (int i = 2; i < 6; i += 1) {
            h2.next = new Node(i);
            h2 = h2.next;
        }
        h2.next = h1;

        printList(h1);
        Node h3 = josephCircle(h1, 1);
        printList(h3);
    }

    public static Node josephCircle(Node head,int num) {
        if (head == null || head.next == head || num < 1) {
            return head;
        }
        Node pre = head;
        while (pre.next != head) {
            pre = pre.next;
        }
        int temp = num;
        Node cur = head;
        while (pre.next != pre) {
            temp--;
            if (temp == 0) {
                pre.next = cur.next;
                temp = num;
            } else {
                pre = pre.next;
            }
            cur = pre.next;
        }
        return pre;
    }

    public static void printList(Node head) {
        Node cur = head;
        System.out.print(cur.value + " ");
        cur = cur.next;
        while (cur != head) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        System.out.println("================================");
    }
}
