public class Trie {
	
	private Node root;
	
	Trie() {
		this.root = new Node();
	}
	
	class Node {
		private Node[] nodes = new Node[26];
		private boolean isEnd;
		
		public boolean containsKey(char c) {
			return nodes[c-'a'] != null;
		}
		
		public void add(char c, Node n) {
			nodes[c-'a'] = n;
		}
		
		public Node get(char c) {
			return nodes[c-'a'];
		}
		
		public void setIsEnd() {
			this.isEnd = true;
		}
		
		public boolean isEnd() {
			return this.isEnd;
		}
	}
	
	public void insert(String word) {
        char[] wordArray = word.toCharArray();
        Node currentNode = root;
        
        for(int i=0; i< wordArray.length; i++) {
        	if(!currentNode.containsKey(wordArray[i])) {
        		Node newNode = new Node();
        		
        		currentNode.add(wordArray[i], newNode);
        		currentNode = newNode;
        	} else {
        		currentNode = currentNode.get(wordArray[i]);
        	}
        }
        
        currentNode.setIsEnd();
    }
    
    public boolean search(String word) {
    	char[] wordArray = word.toCharArray();
        Node currentNode = root;
        
        for(int i=0; i< wordArray.length; i++) {
        	if(currentNode.containsKey(wordArray[i])) {
        		currentNode = currentNode.get(wordArray[i]);
        	} else {
        		return false;
        	}
        }
        return currentNode.isEnd();
    }
    
    public boolean startsWith(String prefix) {
    	char[] prefixArray = prefix.toCharArray();
        Node currentNode = root;
        
        for(int i=0; i< prefixArray.length; i++) {
        	if(currentNode.containsKey(prefixArray[i])) {
        		currentNode = currentNode.get(prefixArray[i]);
        	} else {
        		return false;
        	}
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // return True
		System.out.println(trie.search("app"));     // return False
		System.out.println(trie.startsWith("app")); // return True
		trie.insert("app");
		System.out.println(trie.search("app"));     // return True
	}

}
