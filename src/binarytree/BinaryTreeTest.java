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
						// 此处必须用parent，因为current已经为null了
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
					// value已经存在返回false
					return false;
				}
			}
		}

	}

	// 中序遍历递归操作
	public void inOrderTraverse(Node node) {
		if (node == null) {
			return;
		}
		inOrderTraverse(node.leftChildNode);
		System.out.println(node.value);
		inOrderTraverse(node.rightChildNode);
	}

	// 中序遍历非递归操作
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

	// 前序遍历
	public void preOrderTraverse(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.value);
		preOrderTraverse(node.leftChildNode);
		preOrderTraverse(node.rightChildNode);

	}

	// 前序遍历非递归操作
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

	// 后序遍历
	public void postOrderTraverse(Node node) {
		if (node != null) {
			return;
		}
		postOrderTraverse(node.leftChildNode);
		postOrderTraverse(node.rightChildNode);
		System.out.println(node.value);
	}

	// 后序遍历非递归操作
	public void postOrderByStack(Node node) {
		if (node != null) {
			return;
		}
		Node currentNode = node;
		Node rightChildNode = null; // 用来标记右子树是否已经走过
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

	// 得到最小(大)值
	public int getMinValue(Node node) {
		Node currentNode = node;
		while (true) {
			if (currentNode.leftChildNode == null) {
				return currentNode.value;
			}
			currentNode = currentNode.leftChildNode;
		}
	}

	// 删除
	public boolean delete(Node node, int value) {
		Node currentNode = node;
		Node parentNode = null;
		boolean isLeftChild = true;
		while (true) {
			if (currentNode == null) {
				return false;
			}
			if (value == currentNode.value) {
				break;
			} else if (value < currentNode.value) {
				isLeftChild = true;
				parentNode = currentNode;
				currentNode = currentNode.leftChildNode;
			} else {
				isLeftChild = false;
				parentNode = currentNode;
				currentNode = currentNode.rightChildNode;
			}
		}

		if (currentNode.leftChildNode == null
				&& currentNode.rightChildNode == null) {
			if (currentNode == node) {
				node = null;
			} else {
				if (isLeftChild) {
					parentNode.leftChildNode = null;
				} else {
					parentNode.rightChildNode = null;
				}
			}

		} else if (currentNode.leftChildNode == null) {
			if (currentNode == node) {
				node = node.rightChildNode;
			} else {
				if (isLeftChild) {
					parentNode.leftChildNode = currentNode.rightChildNode;
				} else {
					parentNode.rightChildNode = currentNode.rightChildNode;
				}
			}
		} else if (currentNode.rightChildNode == null) {
			if (currentNode == node) {
				node = node.leftChildNode;
			} else {
				if (isLeftChild) {
					parentNode.leftChildNode = currentNode.leftChildNode;
				} else {
					parentNode.rightChildNode = currentNode.leftChildNode;
				}
			}
		} else {
			Node successor = getSuccessor(currentNode);
			if (currentNode == node) {
				node = successor;
			} else {
				if (isLeftChild) {
					parentNode.leftChildNode = successor;
				} else {
					parentNode.rightChildNode = successor;
				}
			}
		}
		currentNode = null;
		return true;
	}

	private Node getSuccessor(Node delNode) {
		Node successorNode = delNode;
		Node successorParentNode = null;
		Node currentNode = delNode.rightChildNode;

		while (currentNode != null) {
			successorParentNode = successorNode;
			successorNode = currentNode;
			currentNode = currentNode.leftChildNode;
		}

		if (successorNode != delNode.rightChildNode) {
			successorParentNode.leftChildNode = successorNode.rightChildNode;
			successorNode.rightChildNode = delNode.rightChildNode;
		}
		successorNode.leftChildNode = delNode.leftChildNode;

		return successorNode;
	}

}
