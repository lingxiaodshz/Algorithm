/**
 * 跟谁学面试
 * 递归反转链表
 */

public class Interview {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.next = node2;
        node2.next = node3;
        //reverse(node1, null);
        reverse1(node1);
        System.out.println(node3.val);
    }

    public static void reverse(TreeNode node, TreeNode pre) {
        if (node == null) {
            return;
        }
        TreeNode next = node.next;
        node.next = pre;
        reverse(next, node);
    }

    public static TreeNode reverse1(TreeNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        TreeNode head = reverse1(node.next);
        node.next.next=node;
        node.next = null;

        return head;
    }
}

class TreeNode {
    public TreeNode(int val) {
        this.val = val;
    }

    int val;
    TreeNode next;
}