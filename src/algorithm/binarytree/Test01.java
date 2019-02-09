package algorithm.binarytree;

import java.util.Stack;

/*
分别用递归和非递归方式实现二叉树前序，中序和后序遍历
 */
public class Test01 {

    /**
     * 递归前序遍历
     * @param root
     */
    public void preOrderRecur(Node root) {
        if (root != null) {
            System.out.println(root.value);
            preOrderRecur(root.left);
            preOrderRecur(root.right);
        }
    }

    /**
     * 递归中序遍历
     * @param root
     */
    public void midOrderRecur(Node root) {
        if (root != null) {
            preOrderRecur(root.left);
            System.out.println(root.value);
            preOrderRecur(root.right);
        }
    }

    /**
     * 递归后序遍历
     * @param root
     */
    public void posOrderRecur(Node root) {
        if (root != null) {
            preOrderRecur(root.left);
            preOrderRecur(root.right);
            System.out.println(root.value);
        }
    }

    /**
     * 非递归前序遍历
     * @param root
     */
    public void preOrderUnrecur(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            Node cur = null;
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                }
                if (cur != null) {
                    System.out.println(cur.value);
                    if (cur.right != null) {
                        stack.push(cur.right);
                    }
                }
            }
        }
    }

    /**
     * 非递归中序遍历
     *
     * @param root
     */
    public void midOrderUnrecur(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            Node cur = root;
            while (!stack.isEmpty() || cur != null) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                System.out.println(cur.value);
                cur = cur.right;
            }
        }
    }

    /**
     * 非递归后序遍历
     *
     * @param root
     */
    public void posOrderUnrecur(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            Node cur = root;
            Node rightCur = null;
            while (!stack.isEmpty() || cur != null) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                if (!stack.isEmpty()) {
                    cur = stack.peek().right;
                    if (cur == null || cur == rightCur) {
                        cur = stack.pop();
                        System.out.println(cur.value);
                        rightCur = cur;
                        cur = null;
                    }
                }
            }
        }
    }

}


