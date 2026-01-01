import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

	private Map<K, Node> map;
	private int count, capacity;
	private Node head, tail;
	
	LRUCache(int capacity) {
		this.map = new HashMap<K, Node>(capacity);
		this.capacity = capacity;
		this.head = new Node(null, null);
		this.tail = new Node(null, null);
		
		head.next = tail;
		tail.prev = head;
	}
	
	class Node {
		private K key;
		private V value;
		private Node prev;
		private Node next;
		
		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public K getKey() {
			return key;
		}

		public Node getNext() {
			return next;
		}
	}

	private void addFirst(Node node) {
		node.prev = head;
		node.next = head.next;
		
		Node headNextNode = head.next;
		
		head.next = node;
		headNextNode.prev = node;
	}
	
	private void remove(Node node) {
		Node prev = node.prev;
		prev.next = node.next;
	}
	
	private Node removeFromTail() {
		Node node = tail.prev;
		remove(node);
		
		return node;
	}
	
	public void put(K key, V value) {
		Node node = map.get(key);
		
		if(node == null) {
			Node newNode = new Node(key, value);
			count++;
			
			if(count > capacity) {
				Node removedNode = removeFromTail();
				map.remove(removedNode.key);
			}
			
			map.put(key, newNode);
			addFirst(newNode);
		} else {
			Node newNode = new Node(key, value);
			map.put(key, newNode);
			remove(newNode);
			addFirst(newNode);
		}
	}
	
	public V get(K key) {
		Node node = map.get(key);
		
		if(node != null) {				
			remove(node);
			addFirst(node);
		} else {
			return null;
		}
		
		return node.getValue();
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache<Integer, Integer> ob = new LRUCache<Integer, Integer>(2);
		
		ob.put(1, 1);
		ob.put(2, 2);
		
		System.out.println(ob.get(2));

		ob.put(3, 3);
		
		System.out.println(ob.get(1));
	}
}
