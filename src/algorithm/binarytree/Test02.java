package algorithm.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
获取二叉树的层高
 */
public class Test02 {

    public static int getHeightRecur(Node root) {
        if (root == null) {
            return 0;
        }
        int left = getHeightRecur(root.left);
        int right = getHeightRecur(root.right);
        return Math.max(left, right) + 1;
    }

    public static int getHeightUnrecur(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node cur = null;
        int height = 0;
        int len = 0;
        while (!queue.isEmpty()) {
            len = queue.size();
            while (len-- > 0) {
                cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            height++;
        }
        return height;
    }
}
