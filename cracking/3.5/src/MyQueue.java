import java.util.*;

/**
 * Implement queue with two stacks
 * @author hali3
 *
 */
public class MyQueue<T> {
	private Stack<T> inStack;
	private Stack<T> outStack;
	
	public MyQueue() {
		inStack = new Stack<T>();
		outStack = new Stack<T>();
	}
	
	public T dequeue() {
		if (inStack.empty() && outStack.empty()) {
			throw new java.util.EmptyStackException();
		}
		if (!outStack.empty()) {
			return outStack.pop();
		}
		while (!inStack.empty()) {
			outStack.push(inStack.pop());
		}
		return outStack.pop();
	}
	
	public void enqueue(T item) {
		inStack.push(item);
	}
	
	public boolean empty() {
		return inStack.empty() && outStack.empty();
	}
	
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enqueue(10);
		queue.enqueue(20);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
