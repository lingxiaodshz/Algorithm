package algorithm.linklist;

import java.util.Stack;

/**
 * 两个单链表生成相加链表。
 * 假设鏈表中每一個节点的值都是0-9，那么链表整体就可以代表一个整数
 */
class Test08 {
    public static void main(String[] args) {

    }

    public static Node addList(Node head1, Node head2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (head1.next != null) {
            stack1.push(head1.value);
            head1 = head1.next;
        }
        while (head2.next != null) {
            stack1.push(head2.value);
            head2 = head2.next;
        }
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node node = null;
        Node pre = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            n1 = stack1.isEmpty() ? 0 : stack1.pop();
            n2 = stack2.isEmpty() ? 0 : stack2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
        }
        if (ca > 0) {
            pre = node;
            node = new Node(ca);
            node.next = pre;
        }
        return node;
    }
}
