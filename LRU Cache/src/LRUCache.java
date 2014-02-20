import java.util.Hashtable;
import java.util.LinkedList;

/**
 *  Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. 
 * @author hali3
 *
 */

public class LRUCache {
	private LinkedList<Integer> lruList = new LinkedList<Integer>();
	private Hashtable<Integer, Integer> keyValueMap = new Hashtable<Integer, Integer>();
	private int capacity;
	private int currentSize;
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
        currentSize = 0;
    }
    
    public int get(int key) {
        Integer value = keyValueMap.get(key);
        if (value == null) {
        	return -1;
        }
        lruList.remove(new Integer(key));
        lruList.add(0, new Integer(key));
        return value;
    }
    
    public void set(int key, int value) {
        Integer retVal = keyValueMap.get(key);
    	Integer keyObj = new Integer(key);
    	Integer valueObj = new Integer(value);
        if (retVal != null) {
        	keyValueMap.put(keyObj, valueObj);
        	lruList.remove(retVal);
        	lruList.add(0, keyObj);
        } else {
        	if (currentSize == capacity) {
        		Integer lastKey = lruList.getLast();
        		lruList.removeLast();
        		keyValueMap.remove(lastKey);
        		keyValueMap.put(keyObj, valueObj);
        		lruList.add(0, keyObj);
        	} else {
        		keyValueMap.put(key, value);
        		lruList.add(0, new Integer(key));
        		currentSize++;
        	}
        }
    }
}
