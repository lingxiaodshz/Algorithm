package binarytree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Node {
	int value;
	Node leftChildNode;
	Node rightChildNode;

	public Node(int value) {
		super();
		this.value = value;
	}
}

class BinaryTree {
	private Node root = null;

	public BinaryTree(int value) {
		super();
		this.root = new Node(value);
		root.leftChildNode = null;
		root.rightChildNode = null;
	}

	// 查找 针对排列的二叉树
	public Node findKey(int value) {
		Node currentNode = root;
		while (true) {
			if (currentNode.value == value) {
				return currentNode;
			} else if (value < currentNode.value) {
				currentNode = currentNode.leftChildNode;
			} else if (value > currentNode.value) {
				currentNode = currentNode.rightChildNode;
			}
			
			if (currentNode == null) {
				return null;
			}
		}
	}

	// 插入
	public String insert(int value) {
		return null;
	}

	// 中序遍历递归操作
	public void inOrderTraverse() {

	}

	// 中序遍历非递归操作
	public void inOrderByStack() {

	}

	// 前序遍历
	public void preOrderTraverse() {

	}

	// 前序遍历非递归操作
	public void preOrderByStack() {

	}

	// 后序遍历
	public void postOrderTraverse() {

	}

	// 后序遍历非递归操作
	public void postOrderByStack() {

	}

	// 得到最小(大)值
	public int getMinValue() {
		return 0;
	}

	// 删除
	public boolean delete(int value) {
		return false;
	}

}
