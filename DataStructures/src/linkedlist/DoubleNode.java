package linkedlist;

public class DoubleNode {
	Node head;
	
	class Node {
		int data;
		Node prev;
		Node next;
		
		//constructor for a new Node
		Node(int d) {
			data = d;
		}
	}
	
	//1. Insert at the beginning
	public void insertAtStart(int d) {
		Node new_node = new Node(d);
		new_node.next = head;
		new_node.prev = null;
		if(head != null) {
			head.prev = new_node;
		}
		head = new_node;
	}
	
	//2. Insert at the end
	public void insertAtEnd(int d) {
		Node new_node = new Node(d);
		Node last_node = head;
		
		new_node.next = null;
		//navigate to last node
		while( last_node.next != null) {
			last_node = last_node.next;
		}
		new_node.prev = last_node;
		last_node.next = new_node;
	}
	
	//3. Remove at the beginning
	void removeAtStart() {
		 head = head.next;
		 head.prev = null;
	}
	
	//4. Remove at the end
	void removeAtEnd() {
		//navigate to last node
		Node last_node = head;
		
		while(last_node.next != null) {
			last_node = last_node.next;
		}
		last_node = last_node.prev;
		last_node.next = null;
	}

	//5. Insert after a given node
	void insertAfter(int d, Node node) {
		Node new_node = new Node(d);
		Node following_node = node.next; 
		
		node.next = new_node;
		following_node.prev = new_node;
		new_node.prev = node;
		new_node.next = following_node;
	}
	
	//5. Insert before a given node
	void insertBefore(int d, Node node) {
		Node new_node = new Node(d);
		Node front_node = node.prev;
		
		node.prev = new_node;
		front_node.next = new_node;
		new_node.prev = front_node;
		new_node.next = node;
	}
	
	//6. Move to front
	void moveToFront(Node node) {
		Node front_node = node.prev;
		Node following_node = node.next;
			
		node.prev = null;
		node.next = head;
		front_node.next = following_node;
		following_node.prev = front_node;
		head = node;
		}
	
	//6. Move to end
		void moveToEnd(Node node) {
			Node front_node = node.prev;
			Node following_node = node.next;
			
			node.next = null;
			node.prev = following_node;
			front_node.next = following_node;
			following_node.prev = front_node;
			following_node.next = node;
		}
		
	//remove a given node
		void removeAt(Node node) {
			Node front_node = node.prev;
			Node following_node = node.next;
			
			node.prev = following_node;
			front_node.next = following_node;
		}
		
	//print list
	    public void printList(Node node) {
			while(node != null) {
				System.out.print(node.data + " -> "  );
				node = node.next;
			}
			System.out.print("NULL" );
		}
		public static void main(String[] args) 
	    {
	        /* Start with the empty list */
	        DoubleNode dll = new DoubleNode();
	         
	        //operations & visualisation
	        dll.insertAtStart(3);                      // 3 -> NULL 
	        dll.insertAtStart(2);                      // 2 -> 3 -> NULL
	        dll.insertAtStart(1);                      // 1 -> 2 -> 3 -> NULL
	        
	        dll.insertAtEnd(4);                        // 1 -> 2 -> 3 -> 4 -> NULL
	         
	        dll.removeAtStart();                       // 2 -> 3 -> 4 -> NULL
	        
	        dll.removeAtEnd();                         // 2 -> 3 -> NULL
	        
	        dll.insertAtStart(1);                      // 1 -> 2 -> 3 -> NULL
	        
	        dll.insertAfter(5, dll.head.next);         // 1 -> 2 -> 5 -> 3 -> NULL
	        
	        dll.insertBefore(4, dll.head.next.next);   // 1 -> 2 -> 4 -> 5 -> 3 -> NULL
	        
	        dll.moveToFront(dll.head.next.next);       // 4 -> 1 -> 2 -> 5 -> 3 -> NULL
	        
	        dll.moveToEnd(dll.head.next.next.next);    // 4 -> 1 -> 2 -> 3 -> 5 -> NULL
	        
	        dll.removeAt(dll.head.next.next);          // 4 -> 1 -> 3 -> 5 -> NULL
	        System.out.println("Created DLL is: ");
	        dll.printList(dll.head);
	    }
}