package binarytree;

import java.util.Stack;

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
						// �˴�������parent����Ϊcurrent�Ѿ�Ϊnull��
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
	public void inOrderTraverse(Node node) {
		if (node == null) {
			return;
		}
		inOrderTraverse(node.leftChildNode);
		System.out.println(node.value);
		inOrderTraverse(node.rightChildNode);
	}

	// ��������ǵݹ����
	public void inOrderByStack(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		Node currentNode = node;
		while (currentNode != null || !stack.isEmpty()) {
			while (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.leftChildNode;
			}
			if (!stack.isEmpty()) {
				currentNode = stack.pop();
				System.out.println(currentNode.value);
				currentNode = currentNode.rightChildNode;
			}
		}
	}

	// ǰ�����
	public void preOrderTraverse(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.value);
		preOrderTraverse(node.leftChildNode);
		preOrderTraverse(node.rightChildNode);

	}

	// ǰ������ǵݹ����
	public void preOrderByStack(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		Node currentNode = node;
		while (currentNode != null || !stack.isEmpty()) {
			while (currentNode != null) {
				stack.push(currentNode);
				System.out.println(currentNode.value);
				currentNode = currentNode.leftChildNode;
			}
			if (!stack.isEmpty()) {
				currentNode = stack.pop();
				currentNode = currentNode.rightChildNode;
			}
		}
	}

	// �������
	public void postOrderTraverse(Node node) {
		if (node != null) {
			return;
		}
		postOrderTraverse(node.leftChildNode);
		postOrderTraverse(node.rightChildNode);
		System.out.println(node.value);
	}

	// ��������ǵݹ����
	public void postOrderByStack(Node node) {
		if (node != null) {
			return;
		}
		Node currentNode = node;
		Node rightChildNode = null; //��������������Ƿ��Ѿ��߹�
		Stack<Node> stack = new Stack<Node>();
		while (currentNode != null || !stack.isEmpty()) {
			while (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.leftChildNode;
			}
			if (!stack.isEmpty()) {
				currentNode = stack.peek().rightChildNode;
				if (currentNode == null || currentNode == rightChildNode) {
					currentNode = stack.pop();
					System.out.println(currentNode.value);
					rightChildNode = currentNode;
					currentNode = null;
				}
			}
		}
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
