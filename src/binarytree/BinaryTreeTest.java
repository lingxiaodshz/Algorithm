package binarytree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Node{
	int value;
	Node leftChildNode;
	Node rightChildNode;
	public Node(int value) {
		super();
		this.value = value;
	}
}

class BinaryTree{
	private Node root = null;

	public BinaryTree(int value) {
		super();
		this.root = new Node(value);
		root.leftChildNode = null;
		root.rightChildNode = null;
	}
	
	//����
	public Node findKey(int value) {
		return null;
	}
	 //����
    public String insert(int value) {
    	return null;
    }
    //��������ݹ����
    public void inOrderTraverse() {
    	
    }
    //��������ǵݹ����    
    public void inOrderByStack() {
    	
    }
    //ǰ�����
    public void preOrderTraverse() {
    	
    }
    //ǰ������ǵݹ����
    public void preOrderByStack() {
    	
    }
    //�������
    public void postOrderTraverse() {
    	
    }
    //��������ǵݹ����
    public void postOrderByStack() {
    	
    }
    //�õ���С(��)ֵ
    public int getMinValue() {
    	return 0;
    } 
    //ɾ��
    public boolean delete(int value) {
    	return false;
    } 

	
}
