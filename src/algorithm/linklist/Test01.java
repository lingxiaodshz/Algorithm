package algorithm.linklist;

// 输出两个有序链表中相同的项
public class Test01 {

    public static void main(String[] args) {
        Node h1 = new Node(0);
        Node h2 = new Node(0);
        Node h3 = h1;
        Node h4 = h2;
        for (int i = 1; i < 50; i += 2) {
            h3.next = new Node(i);
            h3 = h3.next;	
        }
        for (int i = 1; i < 50; i += 3) {
            h4.next = new Node(i);
            h4 = h4.next;
        }
        showSameValue(h1,h2);
    }

    public static void showSameValue(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
