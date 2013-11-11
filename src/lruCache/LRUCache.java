package lruCache;

import java.util.*;

public class LRUCache {
	private class CacheNode {
		CacheNode 	prev; // previous item
		CacheNode 	next; // next item
		int			key;	// key
		int			value;  // value
		
		public CacheNode(int key, int value) {
			this.value = value;
			this.key = key;
		}
	}
	
	// Sentinel nodes
	private CacheNode head;
	private CacheNode tail;
	
	private int	capacity;
	private Map<Integer, CacheNode> map;
    
    public LRUCache(int capacity) {
    	map = new HashMap<Integer, CacheNode>(capacity);
    	head = new CacheNode(-1, -1);
    	tail = new CacheNode(-1, -1);
    	this.capacity = capacity;
    	
    	// initialize the sentinels
    	head.prev = null;
    	head.next = tail;
    	
    	tail.prev = head;
    	tail.next = null;
    }
    
    public int get(int key) {
    	CacheNode node = map.get(key);
    	
    	// non-existent node
    	if (node == null)
    		return -1;
    	
    	// move the node to the head if it's not the head
    	moveToHead(node);
    	
        return node.value;
    }
    
    public void set(int key, int value) {
        CacheNode node = map.get(key);
        
        if (node == null) { // new key
        	node = new CacheNode(key, value);
        	node.prev = head;
        	node.next = head.next;
        	
        	head.next.prev = node;
        	head.next = node;
        	
        	// need to purge old data
        	if (map.size() >= capacity)  
        		removeOld();
  
       		// store to the map
        	map.put(key, node);
        } else {
        	node.value = value;
        	moveToHead(node);
        }
    }

    /**
     * Removes the last item in the list
     */
    private void removeOld() {
    	// empty list
    	if (tail.prev == head)
    		return;
    	
    	CacheNode oldNode = tail.prev;
    	oldNode.prev.next = tail;
    	tail.prev = oldNode.prev;
    
    	// then remove from the map
    	map.remove(oldNode.key);
    }

    /**
     * Move a node to the head of the list
     * @param node a node in the list
     */
    private void moveToHead(CacheNode node) {
    	if (node.prev == head) // already the first item?
    		return;
    	
    	// connects prev and next
    	node.prev.next = node.next;
    	node.next.prev = node.prev;
    	
    	// connect to head.next
    	head.next.prev = node; 
		node.next = head.next;
		
		// connect to head
    	node.prev = head; 
		head.next = node;
    }    
}
