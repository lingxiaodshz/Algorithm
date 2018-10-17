package algorithm.linklist;

// 删除链表的中间节点
public class Test03 {
    public static void main(String[] args) {
        Node h1 = new Node(0);
        Node h3 = h1;
        for (int i = 2; i < 20; i += 2) {
            h3.next = new Node(i);
            h3 = h3.next;
        }
        removeMidNode(h1);
        while (h1 != null) {
            System.out.print(h1.value+" ");
            h1 = h1.next;
        }
    }

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
}
