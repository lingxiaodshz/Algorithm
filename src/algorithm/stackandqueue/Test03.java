package algorithm.stackandqueue;

import java.util.Stack;

/**
 * 仅用递归函数和栈操作逆序一个栈
 */

public class Test03 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		// print(stack);

		reverse(stack);
		print(stack);

	}

	public static int removeLast(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = removeLast(stack);
			stack.push(result);
			return last;
		}
	}

	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int i = removeLast(stack);
		reverse(stack);
		stack.push(i);
	}

	public static void print(Stack<Integer> stack) {
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());

		}
	}
}
