package algorithm.stackandqueue;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作 要求：1.pop,push,getMin操作的时间复杂度都是O(1)
 * 2.设计的栈类型可以使用现成的栈结构
 */
public class Test01 {
	public static void main(String[] args) {
		MyStack1 stack1 = new MyStack1();
		stack1.push(5);
		stack1.push(3);
		stack1.push(3);
		stack1.push(6);
		stack1.push(8);

		System.out.println(stack1.getMin());

	}
}

class MyStack1 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;

	public MyStack1() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}

	public void push(int newNum) {
		if (stackMin.isEmpty()) {
			stackMin.push(newNum);
		} else if (newNum <= getMin()) {
			stackMin.pop();
			stackMin.push(newNum);
		}
		stackData.push(newNum);
	}

	public int pop() {
		if (stackData.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		int value = stackData.pop();
		if (value == getMin()) {
			stackMin.pop();
		}
		return value;
	}

	public int getMin() {
		if (stackMin.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		return stackMin.peek();
	}
}
