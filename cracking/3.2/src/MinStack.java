/**
 * Find minimum in stack
 * @author hali3
 *
 */
import java.util.*;

public class MinStack {
	private Stack<Integer> numberStack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	
	public MinStack() {
		
	}
	
	public void push(Integer item) {
		if (numberStack.empty()) {
			minStack.push(item);
		} else {
			int curMin = minStack.peek();
			if (curMin >= item) {
				minStack.push(item);
			}
		}
		numberStack.push(item);
	}
	
	public Integer pop() {
		if (numberStack.empty()) {
			throw new java.util.EmptyStackException();
		}
		Integer num = numberStack.pop();
		if (num <= minStack.peek()) {
			minStack.pop();
		}
		return num;
	}
	
	public Integer min() {
		if (minStack.empty()) {
			throw new java.util.EmptyStackException();
		}
		return minStack.peek();
	}
	
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(10);
		System.out.println(stack.min());
		stack.push(20);
		System.out.println(stack.min());
		stack.push(10);
		System.out.println(stack.min());
		stack.push(1);
		System.out.println(stack.min());
		stack.push(100);
		System.out.println(stack.min());
		stack.push(2);
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		ArrayList<Integer>[] list = new ArrayList[4];
		list[0] = new ArrayList<Integer>();
		list[1] = new ArrayList<Integer>();
		list[0].add(100);
		
	}
}
