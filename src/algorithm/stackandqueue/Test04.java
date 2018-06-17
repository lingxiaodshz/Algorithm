package algorithm.stackandqueue;

import java.util.Stack;

public class Test04 {

	/**
	 * 用一个栈实现另一个栈的排序 只允许申请一个栈，可以申请变量，但不允许申请额外的数据结构
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(3);
		stack.push(3);
		stack.push(6);
		stack.push(8);

		sortStack(stack);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

	public static void sortStack(Stack<Integer> stack) {
		if (stack == null || stack.isEmpty()) {
			return;
		}
		Stack<Integer> tempStack = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int top = stack.pop();
			while (!tempStack.isEmpty() && tempStack.peek() > top) {
				stack.push(tempStack.pop());
			}
			tempStack.push(top);
		}
		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
	}
}
