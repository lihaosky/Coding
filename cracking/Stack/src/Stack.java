import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class StackException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6180913648998314001L;

	public StackException() {
		super();
	}
}

public class Stack<T> {
	private LinkedList<T> list = new LinkedList<T>();
	public void push(T e) {
		list.add(e);
	}
	
	public boolean empty() {
		return list.size() == 0;
	}
	
	public T peek() {
		if (list.size() <= 0) {
			throw new StackException();
		}
		return list.getLast();
	}
	
	public T pop() {
		if (list.size() <= 0) {
			throw new StackException();
		}
		return list.removeLast();
	}
	
	public int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(100);
		stack.push(200);
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}
	}
}
