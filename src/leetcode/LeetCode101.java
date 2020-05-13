package leetcode;

import java.util.Stack;

public class LeetCode101 {
    /**
     * 101. 对称二叉树
     * 给定一个二叉树，检查它是否是镜像对称的。
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     * 1
     * / \
     * 2   2
     * \   \
     * 3    3
     * 进阶：
     * 你可以运用递归和迭代两种方法解决这个问题吗？
     */

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricTree(root.left, root.right);
    }

    public static boolean isSymmetricTree(TreeNode p, TreeNode q) {
//        if (p == null && q == null) {
//            return true;
//        }
//        if (p == null) {
//            return false;
//        }
//        if (q == null) {
//            return false;
//        }
//        if (p.val == q.val) {
//            return isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
//        }
//        return false;
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
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


    }
}
