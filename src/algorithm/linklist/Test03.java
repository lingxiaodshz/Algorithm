package algorithm.linklist;

public class Test03 {
    public static void main(String[] args) {
        Node h1 = new Node(0);
        Node h2 = h1;
        for (int i = 2; i < 20; i += 2) {
            h2.next = new Node(i);
            h2 = h2.next;
        }
        removeMidNode(h1);
        while (h1 != null) {
            System.out.print(h1.value + " ");
            h1 = h1.next;
        }

        System.out.println();
        System.out.println("==========================================");

        Node h3 = new Node(0);
        Node h4 = h3;
        for (int i = 2; i < 14; i += 2) {
            h4.next = new Node(i);
            h4 = h4.next;
        }
//        removeByRadio(h3, 5, 7);
//        removeByRadio(h3, 5, 6);
//        removeByRadio(h3, 0, 5);
        removeByRadio(h3, 1, 6);
        while (h3 != null) {
            System.out.print(h3.value + " ");
            h3 = h3.next;
        }
    }

    // 删除链表的中间节点
    public static Node removeMidNode(Node head) {
        // 节点数小于2
        if (head == null || head.next == null) {
            return head;
        }
        // 节点数等于2
        if (head.next.next == null) {
            return head.next;
        }
        // 节点数大于2
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    // 删除链表a/b的位置节点
    public static Node removeByRadio(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        Node cur = head;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil(((double) a * n) / b);
        if (n == 1) {
            head = head.next;
        }
        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
