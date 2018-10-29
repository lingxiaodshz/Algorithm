package algorithm.linklist;

import java.util.Stack;

/**
 * 判断是否为回文链表
 */
public class Test07 {
    public static void main(String[] args) {
        Node h1 = new Node(1);
        Node h2 = h1;
        for (int i = 2; i < 6; i += 1) {
            h2.next = new Node(i);
            h2 = h2.next;
        }
        h2.next = new Node(6);
        h2 = h2.next;
        for (int i = 5; i > 0; i -= 1) {
            h2.next = new Node(i);
            h2 = h2.next;
        }
//        System.out.println(isPalindromel(h1));
        System.out.println(isPalindromel2(h1));
    }

    public static boolean isPalindromel(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindromel2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node node1 = head;
        Node node2 = head;
        while (node2.next != null && node2.next.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        node2 = node1.next;
        node1.next = null;
        Node node3 = null;
        while (node2 != null) {
            node1 = node2.next;
            node2.next = node3;
            node3 = node2;
            node2 = node1;
        }
        node1 = node3;
        node2 = head;
        while (node1 != null && node2 != null) {
            if (node1.value != node2.value) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }
}
