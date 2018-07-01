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

	// ���� ������еĶ�����
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

	// ����
	public boolean insert(int value) {
		if (root == null) {
			root.value = value;
			root.leftChildNode = null;
			root.rightChildNode = null;
			return true;
		} else {
			Node currentNode = root;
			Node parentNode = null;
			while (true) {
				if (value < currentNode.value) {
					parentNode = currentNode;
					currentNode = currentNode.leftChildNode;
					if (currentNode == null) {
						parentNode.leftChildNode = new Node(value);
						return true;
					}
				} else if (value > currentNode.value) {
					parentNode = currentNode;
					currentNode = currentNode.rightChildNode;
					if (currentNode == null) {
						parentNode.rightChildNode = new Node(value);
						return true;
					}
				} else {
					// value�Ѿ����ڷ���false
					return false;
				}
			}
		}

	}

	// ��������ݹ����
	public void inOrderTraverse() {

	}

	// ��������ǵݹ����
	public void inOrderByStack() {

	}

	// ǰ�����
	public void preOrderTraverse() {

	}

	// ǰ������ǵݹ����
	public void preOrderByStack() {

	}

	// �������
	public void postOrderTraverse() {

	}

	// ��������ǵݹ����
	public void postOrderByStack() {

	}

	// �õ���С(��)ֵ
	public int getMinValue() {
		return 0;
	}

	// ɾ��
	public boolean delete(int value) {
		return false;
	}

}
