package algorithm.linklist;

/**
 * 反转部分单项链表。要求：长度问N，时间复杂度为O(N)，空间复杂度为O(1)
 */
public class Test05 {
    public static void main(String[] args) {
        Node h1 = new Node(0);
        Node h2 = h1;
        for (int i = 2; i < 20; i += 2) {
            h2.next = new Node(i);
            h2 = h2.next;
        }

        printList(h1);
        Node h3 = reversePartLinkedList(h1, 2, 5);
        printList(h3);
    }

    public static Node reversePartLinkedList(Node head, int from, int to) {
        int len = 0;
        Node node = head;
        Node fPre = null, tPos = null;
        while (node != null) {
            len++;
            fPre = (len == from - 1 ? node : fPre);
            tPos = (len == to + 1 ? node : tPos);
            node = node.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        node = (fPre == null ? head : fPre.next);
        Node node2 = node.next;
        node.next = tPos;
        Node tempNext = null; // 临时保存node2.next
        while (node2 != tPos) {
            // 保存node2.next
            tempNext = node2.next;
            // 将node2.next指向node
            node2.next = node;
            // 将node2赋给node
            node = node2;
            // node2指向之前保存的node2.next
            node2 = tempNext;
        }
        if (fPre != null) {
            fPre.next = node;
            return head;
        }
        return node;
    }

    public static void printList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        System.out.println("================================");
    }
}
