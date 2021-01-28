import java.util.*;

class CircularLinkedList{

	Node head;
	Node last;
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			next = null;
		}
	}

	public Node createNewNode(int data){
		Node newNode = new Node(data);
		return newNode;
	}

	public void addNewNodeAtStart(int data){
		Node newNode = createNewNode(data);
		if(head == null){ //empty
			head = newNode;
			last = newNode;
		}else{
			newNode.next = head;
			head = newNode;
			last.next = newNode;
		}
	}

	public void addNewNodeAtEnd(int data){
		Node newNode = createNewNode(data);
		if(head == null){ //empty
			head = newNode;
			last = newNode;
		}else{
			newNode.next = head;
			last.next = newNode;
			last = newNode;
		}
	}

	public void insertAfterGivenNode(int previousData,int data){
		Node newNode = createNewNode(data);

		if(head == null){
			System.out.println("Linked List is empty.");
			return;
		}

		Node n = head; //first node

		while(n != last){
			if(n.data == previousData){
				newNode.next = n.next;
				n.next = newNode;
				return;
			}
			n = n.next;
		}

		if(n == last){ //add at last
			newNode.next = head;
			last.next = newNode;
			last = newNode;
		}
	}


	public int lengthOfLinkedList(){

		if(head == null){
			return 0;
		}
		int count = 0;

		Node n = head; //first node

		do{
			count++;
			n = n.next;
		}while(n != head);
		return count;
	}

	public boolean searchElement(int key){

		if(head == null) {
			System.out.println("Linked list is empty.");
			return false;
		}
		Node n = head; //first node

		do{
			if(n.data == key){
				return true;
			}
			n = n.next;
		}while( n != head);
		return false;
	}

	public void deleteFirstNode(){
		if(head == null){
			System.out.println("Linked list is empty.");
			return;
		}
		if(head == last){
			head = null;
			last = null;
			return;
		}

		Node temp = head;
		head = temp.next;
		last.next = head;
		temp.next = null;
		return;
	}

	public void deleteLastNode(){
		if(head == null){
			System.out.println("Linked list is empty.");
			return;
		}
		if(head == last){
			head = null;
			last = null;
			return;
		}

		Node n = head;
		Node previous = null;

		while(n.next != head){
			previous = n;
			n = n.next;
		}

		previous.next = last.next;
		last = previous;
		n.next = null;
	}

	//delete node with first ocuurance of key
	public void deleteMiddleNode(int key){
		if(head == null){
			System.out.println("Linked list is empty");
			return;
		}

		if(head.data == key){ //first node
			if(head == last){ //only one node
				head = null;
				last = null;
				return;
			}else{ //first but not only node
				Node temp = head;
				last.next = head.next;
				head = temp.next;
				temp.next = null;
				return;
			}
		}

		Node n = head;
		Node previous = null;

		while(n != last){

			if(n.data == key){
				previous.next = n.next;
				n.next = null;
				return;
			}

			previous = n;
			n = n.next;
		}

		if(n.data == key){ //last node
			previous.next = last.next;
			last = previous;
			n.next = null;
			return;
		}

		System.out.println("Can not find the node.");
		return;

		

		
		

	}

	public void giveNthElement(int index){
		if(head == null){
			System.out.println("linked list is empty.");
			return;
		}

		if(index < 0 || index > lengthOfLinkedList() - 1){
			System.out.println("Index is invalid");
			return;
		}

		int count = 0;

		Node n = head;

		do{
			if(count == index){
				System.out.println("Data at index " + index + " is: " + n.data);
				return;
			}
			n = n.next;
			count++;
		}while(n != head);
	}

	public void getCount(int key){
		if(head == null){
			System.out.println("linked list is empty.");
			return;
		}

		int count = 0;

		Node n = head;

		do{
			if(key == n.data){
				count++;
			}
			n = n.next;
		}while(n != head);

		System.out.println("Frequency of given number is: " + count);
	}

	public void minMax(){
		if(head == null){
			System.out.println("linked list is empty.");
			return;
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		Node n = head;

		do{
			if(n.data < min){
				min = n.data;
			}
			if(n.data > max){
				max = n.data;
			}
			n = n.next;
		}while(n != head);

		System.out.println("min is: " + min);
		System.out.println("max is: " + max);


	}


	public void printCircularLinkedList(){
		if(head == null){
			System.out.println("linked list is empty.");
			return;
		}

		if(head.next == head){
			System.out.println(head.data);
			return;
		}
		Node n = head; //first node
		do{
			System.out.println(n.data);
			n = n.next;
		}while( n != head );
	}

	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		// cll.addNewNodeAtStart(1);
		// cll.addNewNodeAtStart(2);
		// cll.addNewNodeAtStart(3);

		cll.addNewNodeAtEnd(1);

		cll.addNewNodeAtEnd(2);

		cll.addNewNodeAtEnd(3);

		// cll.insertAfterGivenNode(3,1);

		//cll.deleteFirstNode();

		//cll.deleteMiddleNode(4);

		// cll.deleteMiddleNode(1);

		cll.printCircularLinkedList();

		// System.out.println("Length of linked list is:" + cll.lengthOfLinkedList());

		// cll.giveNthElement(0); //1
		// cll.giveNthElement(1); //2
		// cll.giveNthElement(2); //3
		// cll.giveNthElement(3); //1

		// cll.minMax();

		// cll.getCount(1);
		// if(cll.searchElement(4)){
		// 	System.out.println("The node with data 4 is present.");
		// }else{
		// 	System.out.println("The node with data 4 is not present.");
		// }
	}
}