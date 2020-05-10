package leetcode;

import java.util.Stack;

public class LeetCode100 {
    /**
     * 100. 相同的树
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * 示例 1:
     * 输入:       1         1
     * / \       / \
     * 2   3     2   3
     * [1,2,3],   [1,2,3]
     * 输出: true
     * 示例 2:
     * 输入:      1          1
     * /           \
     * 2             2
     * [1,2],     [1,null,2]
     * 输出: false
     * 示例 3:
     * 输入:       1         1
     * / \       / \
     * 2   1     1   2
     * [1,2,1],   [1,1,2]
     * 输出: false
     */

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        // 第一种方法深度遍历
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        pStack.push(p);
        qStack.push(q);
        TreeNode pCur, qCur;
        while (!pStack.isEmpty() && !qStack.isEmpty()) {
            pCur = pStack.pop();
            qCur = qStack.pop();
            if (isSameNode(pCur.right, qCur.right)) {
                if (pCur.right != null) {
                    pStack.push(pCur.right);
                    qStack.push(qCur.right);
                }
            } else {
                return false;
            }
            if (isSameNode(pCur.left, qCur.left)) {
                if (pCur.left != null) {
                    pStack.push(pCur.left);
                    qStack.push(qCur.left);
                }
            } else {
                return false;
            }
        }
        return pStack.isEmpty() && qStack.isEmpty();
    }

    public static boolean isSameNode(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        return p.val == q.val;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(3);
        node4.left = node5;
        node4.right = node6;

        System.out.println(isSameTree(node1, node4));
    }
}
