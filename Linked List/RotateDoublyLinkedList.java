// Java program to rotate a Doubly linked 
// list counter clock wise by N times 
//Code copied from GFG
//only function is changed
class RotateDoublyLinkedList { 

/* Link list node */
static class Node 
{ 
	char data; 
	Node prev; 
	Node next; 
} 
static Node head = null; 

// This function rotates a doubly linked 
// list counter-clockwise and updates the 
// head. The function assumes that N is 
// smallerthan size of linked list. It 
// doesn't modify the list if N is greater 
// than or equal to size 
static void rotate(int n){ 
	//reach to the nth node
	int count = 1;

	Node current = head;
	while(count != n && current != null){
		current = current.next;
		count++;
	}

	Node nthNode = current;

	//reach at last node
	while(current.next != null){
		current = current.next;
	}

	head.prev = current;
	current.next = head;


	//change head;
	head = nthNode.next;
	head.prev = null;

	nthNode.next = null;
	

} 

// Function to insert a node at the 
// beginning of the Doubly Linked List 
static void push(char new_data) 
{ 
	Node new_node = new Node(); 
	new_node.data = new_data; 
	new_node.prev = null; 
	new_node.next = (head); 
	if ((head) != null) 
		(head).prev = new_node; 
head = new_node; 
} 

/* Function to print linked list */
static void printList(Node node) 
{ 
	while (node != null && node.next != null) 
	{ 
		System.out.print(node.data + " "); 
		node = node.next; 
	} 
	if(node != null) 
	System.out.print(node.data); 
} 

// Driver's Code 
public static void main(String[] args) 
{ 
	/* Start with the empty list */
	// Node head = null; 

	/* Let us create the doubly 
	linked list a<->b<->c<->d<->e */
	push( 'e'); 
	push( 'd'); 
	push('c'); 
	push('b'); 
	push( 'a'); 

	int N = 2; 

	System.out.println("Given linked list "); 
	printList(head); 
	rotate( N); 
	System.out.println(); 
	System.out.println("Rotated Linked list "); 
	printList(head); 
} 
} 

// This code is contributed by Prerna Saini 
