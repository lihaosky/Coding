import java.util.Hashtable;
import java.util.LinkedList;

/**
 *  Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. 
 * @author hali3
 *
 */

class Node {
	int key;
	int val;
	Node prev;
	Node next;
	
	public Node(int key, int val) {
		this.key = key;
		this.val = val;
		this.prev = null;
		this.next = null;
	}
}

class LRUList {
	Node head, tail;
	int size;
	
	public LRUList() {
		head = tail = null;
		size = 0;
	}
	
	public Node remove(Node node) {
		if (size == 0) {
			return null;
		}
		if (size == 1) {
			size--;
			head = tail = null;
			return node;
		}
		if (node == head) {
			node.next.prev = node.prev;
			head = node.next;
			node.next = node.prev = null;
			size--;
			return node;
		}
		if (node == tail) {
			node.prev.next = node.next;
			tail = node.prev;
			node.prev = node.next = null;
			size--;
			return node;
		}
		node.next.prev = node.prev;
		node.prev.next = node.next;
		node.next = node.prev = null;
		size--;
		return node;
	}
	
	public Node removeTail() {
		if (size == 0) {
			return null;
		}
		if (head == tail) {
			Node tmp = head;
			head = tail = null;
			size--;
			return tmp;
		}
		Node tmp = tail;
		tail.prev.next = null;
		tail = tail.prev;
		tmp.next = tmp.prev = null;
		size--;
		return tmp;
	}
	
	public void add(Node node) {
		if (head == null && tail == null) {
			head = tail = node;
			size++;
			return;
		}
		node.next = head;
		head.prev = node;
		head = node;
		size++;
	}
	
	public void print() {
		Node node = head;
		while (node != null) {
			System.out.println(node.key + " " + node.val);
			node = node.next;
		}
		if (head != null) {
			System.out.println("head is " + head.key);
		} else {
			System.out.println("head is null");
		}
		if (tail != null) {
			System.out.println("Tail is " + tail.key);
		} else {
			System.out.println("Tail is null");
		}
	}
}

public class LRUCache {
	public LRUList list = new LRUList();
	private Hashtable<Integer, Node> keyValueMap = new Hashtable<Integer, Node>();
	private int capacity;
	private int currentSize;
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
        currentSize = 0;
    }
    
    public int get(int key) {
        Node value = keyValueMap.get(key);
        if (value == null) {
        	return -1;
        }
        list.remove(value);
        list.add(value);
        return value.val;
    }
    
    public void set(int key, int value) {
        Node retVal = keyValueMap.get(key);
    	Integer keyObj = new Integer(key);
    	Node valueObj = new Node(key, value);
        if (retVal != null) {
        	keyValueMap.put(keyObj, valueObj);
        	list.remove(retVal);
        	list.add(valueObj);
        } else {
        	if (currentSize == capacity) {
        		Node target = list.removeTail();
        		keyValueMap.remove(target.key);
        		Node node = new Node(key, value);
        		keyValueMap.put(key, node);
        		list.add(node);
        	} else {
        		Node node = new Node(key, value);
        		keyValueMap.put(key, node);
        		list.add(node);
        		currentSize++;
        	}
        }
    }
    
    public static void main(String[] args) {
    	LRUCache lc = new LRUCache(2);
    	lc.set(2, 1);
    	lc.list.print();
    	lc.set(2, 2);
    	lc.list.print();
    	System.out.println(lc.get(2));
    	lc.set(1, 1);
    	lc.list.print();
    	lc.set(4,  1);
    	lc.list.print();
    	System.out.println(lc.get(2));
    }
}
