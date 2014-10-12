import java.util.LinkedList;

class EmptyQueueException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 716002927600871258L;

	public EmptyQueueException() {
		super();
	}
}

public class Queue<T> {
	private LinkedList<T> list = new LinkedList<T>();
	
	public Queue() {
		
	}
	
	public void enqueue(T item) {
		list.add(item);
	}
	
	public T dequeue() {
		if (list.size() <= 0) {
			throw new EmptyQueueException();
		}
		return list.removeFirst();
	}
	
	public int size() {
		return list.size();
	}
	
	public T peek() {
		if (list.size() <= 0) {
			throw new EmptyQueueException();
		}
		return list.peekFirst();
	}
	
	public boolean empty() {
		return list.size() <= 0;
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(10);
		while (!queue.empty()) {
			System.out.println(queue.dequeue());
		}
	}
}
