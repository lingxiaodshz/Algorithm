package algorithm.linklist;

public class Test01 {

    public static void main(String[] args) {
        LinkedNode h1 = new LinkedNode(0);
        LinkedNode h2 = new LinkedNode(0);
        LinkedNode h3 = h1;
        LinkedNode h4 = h2;
        for (int i = 1; i < 50; i += 2) {
            h3.next = new LinkedNode(i);
            h3 = h3.next;	
        }
        for (int i = 1; i < 50; i += 3) {
            h4.next = new LinkedNode(i);
            h4 = h4.next;
        }
        showSameValue(h1,h2);
    }

    public static void showSameValue(LinkedNode head1, LinkedNode head2) {
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
