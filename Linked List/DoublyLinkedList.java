import java.util.*;

class DoublyLinkedList{
	Node head;

	static class Node{
		int data;
		Node next;
		Node previous;

		Node(int data){
			this.data = data;
			next = null;
			previous = null;
		}
	} 

	public Node createNode(int data){
		Node newNode = new Node(data);
		return newNode;
	}

	public void addNewNodeAtStart(int data){

		Node newNode = createNode(data);
		if(head == null){
			head = newNode;
			return;
		}

		newNode.next = head;
		head.previous = newNode;
		head = newNode;
	}

	public void addNodeAtLast(int data){
		Node newNode = createNode(data);

		if(head == null){
			head = newNode;
			return;
		}

		Node n = head;

		while(n.next != null){
			n = n.next;
		}

		newNode.previous = n;
		n.next = newNode;
	}


	public void printLinkedList(){
		
		if(head == null){
			System.out.println("Linked list is empty.");
			return;
		}

		Node n = head;
		while(n != null){
			System.out.println(n.data);
			n = n.next;
		}
	}

	public void insertAfterGivenNode(int prevoiusData,int data){
		if(head == null){
			System.out.println("Linked list is empty.");
			return;
		}

		Node newNode = createNode(data);
		Node n = head;


		while(n.next != null){
			if(n.data == prevoiusData){
				newNode.previous = n.next;
				newNode.next = n.next;
				n.next.previous = newNode;
				n.next = newNode;
				return;
			}
			n = n.next;
		}

		if(n.data == prevoiusData){ //last node
			n.next = newNode;
			newNode.previous = n;
			return;
		}

		//if reached this line then node is not found

		System.out.println("node is not found.");
		return;


	}

	public int lengthOfLinkedList(){

		if(head == null){
			return 0; 
		}
		int count = 0;

		Node n = head;

		while(n != null){
			count++;
			n = n.next;
		}
		return count;
	}

	public boolean searchElement(int key){

		if(head == null){
			return false;
		}

		Node n = head;

		while(n != null){
			
			if(n.data == key){
				return true;
			}

			n = n.next;

		}

		return false;
	}

	//delete the node at first occurance of key
	public void deleteNode(int key){
		if(head == null){
			System.out.println("Linked list is empty.");
			return;
		}


		if(head.data == key){
			Node temp = head;
			head = head.next;
			temp.next = null;
			head.previous = null;
			return;
		}
		Node n = head;
		Node previousNode = null;

		while(n.next != null){
			if(n.data == key){
				
			}
			previousNode = n;
			n = n.next;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		// dll.addNewNodeAtStart(1);
		// dll.addNewNodeAtStart(2);

		dll.addNodeAtLast(1);
		dll.addNodeAtLast(2);
		dll.addNodeAtLast(3);
		dll.addNodeAtLast(4);

		dll.insertAfterGivenNode(4,0);
		dll.printLinkedList();
		System.out.println("length of linked list is : " + dll.lengthOfLinkedList());

		if(dll.searchElement(-1)){
			System.out.println("element is present in linked list.");
		}else{
			System.out.println("element is not present in linked list.");
		}


	}
}