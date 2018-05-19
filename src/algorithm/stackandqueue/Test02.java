package algorithm.stackandqueue;

import java.util.Stack;

/**
 * 用两个栈实现队列，支持队列的基本操作（add,poll,peek）
 */
public class Test02 {
	public static void main(String[] args) {
		Queue1 queue1 = new Queue1();
		queue1.add(1);
		queue1.add(2);
		queue1.add(3);
		queue1.add(4);
		queue1.add(5);
		
		for (int i = 0; i < 5; i++) {
			System.out.println(queue1.peek());
		}

		while (!queue1.isEmpty()) {
			System.out.println(queue1.poll());
		}

	}

}

class Queue1 {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public Queue1() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void add(int num) {
		stack1.push(num);
	}

	public int poll() {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			throw new RuntimeException("empty");
		} else if (!stack1.isEmpty() && stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			int temp = stack2.pop();
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			return temp;
		}
		return 0;
	}

	public int peek() {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			throw new RuntimeException("empty");
		} else if (!stack1.isEmpty() && stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			int temp = stack2.peek();
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			return temp;
		}
		return 0;
	}

	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
}