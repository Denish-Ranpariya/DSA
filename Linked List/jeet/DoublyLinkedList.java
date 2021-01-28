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

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.addNewNodeAtStart(1);
		dll.addNewNodeAtStart(2);
		dll.printLinkedList();
	}
}