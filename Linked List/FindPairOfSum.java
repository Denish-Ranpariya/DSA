//given a doubly linked list
//linked list is sorted
//here Copied code from GFG
//only function is implimented
//two pointer method
class FindPairOfSum 
{ 

// structure of node of 
// doubly linked list 
static class Node 
{ 
	int data; 
	Node next, prev; 
}; 

// Function to find pair whose 
// sum equal to given value x. 
static void pairSum( Node head, int x) { 
	Node first = head;
	Node last = head;

	boolean flag = false;
	//setting last pointer at last node
	while(last.next != null){
		last = last.next;
	}

	//if they cross each other
	while( last.next != first && first != last){
		// System.out.println(first.data + "," + last.data);
		if((first.data + last.data) == x){
			flag = true; //found
			System.out.println(first.data + "," + last.data);
			first = first.next;
			last = last.prev;
		}else if(first.data + last.data < x){
			first = first.next;
		}else{
			last = last.prev;
		}
	}

	if(flag == false){
		System.out.println("No pairs found");
	}
} 

// A utility function to insert 
// a new node at the beginning 
// of doubly linked list 
static Node insert(Node head, int data) 
{ 
	Node temp = new Node(); 
	temp.data = data; 
	temp.next = temp.prev = null; 
	if (head == null) 
		(head) = temp; 
	else
	{ 
		temp.next = head; 
		(head).prev = temp; 
		(head) = temp; 
	} 
	return temp; 
} 

// Driver Code 
public static void main(String args[]) 
{ 
	Node head = null; 
	head = insert(head, 9); 
	head = insert(head, 8); 
	head = insert(head, 6); 
	head = insert(head, 5); 
	head = insert(head, 4); 
	head = insert(head, 2); 
	head = insert(head, 1); 
	int x = 7; 

	pairSum(head, x); 
} 
} 

// This code is contributed 
// by Arnab Kundu 
