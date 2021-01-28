import java.util.*;

class LinkedList_1_1{

	Node head;

	static class Node{ //static because main can access it
		int data;
		Node next;

		Node(int data){
			this.data = data;
			next = null;
		}
	}

	public void printLinkedList(){
		Node n = head;

		while(n != null){
			System.out.println(n.data);
			n = n.next;
		}
	}

	public Node createNewNode(int data){
		Node newNode = new Node(data);
		newNode.next = null;
		return newNode;
	}

	public void addNewNodeAtBegin(int data){
		Node newNode = createNewNode(data);
		if( head == null ){
			head = newNode;
		}else{
			newNode.next = head;
			head = newNode;
		}
	}

	public void addNewNodeAtEnd(int data){
		Node newNode = createNewNode(data);
		Node n = head;

		if(head == null){
			head = newNode;
		}else{
			while(n.next != null){
				n = n.next;
			}

			n.next = newNode;
		}
	}

	public void insertAfterGivenNode(int prevoiusData, int data){
		Node newNode = createNewNode(data);

		Node n = head;

		while(n.next != null){
			if(n.data == prevoiusData){
				newNode.next = n.next;
				n.next = newNode;
			}
			n = n.next;
		}
	}

	public int lengthOfLinkedList(){
		Node n = head;
		int len = 0;
		while(n != null){
			n = n.next;
			len++;
		}
		return len;
	}

	public boolean searchElement(int key){
		Node n = head;

		while(n != null){
			if(n.data == key) {
				return true;
			}
			n = n.next;
		}

		return false;
	}


	//delete the node of first occurance of data
	public void deleteNode(int key){

		if(head.data == key){
			Node temp = head;
			head = temp.next;
			temp.next = null;
			return;
		}

		Node n = head;

		while(n.next != null){

			if(n.next.data == key){
				Node temp = n.next;
				n.next = temp.next;
				temp.next = null;
				return;
			}
			n = n.next;
		}

		if(n.next == null){
			System.out.println("Key not found");
			return;
		}
	}

	//delete the Node at given index

	//do it with tracing

	public void deleteNodeAtGivenIndex(int position){

		if(position == 0){
			Node temp = head;
			head = temp.next;
			temp.next = null;
			return;
		}

		int count = 1;
		Node n = head;
		Node temp;

		while(n != null){

			if(position == count){
				temp = n.next;
				n.next = temp.next;
				temp.next = null;
				return;
			}
			n = n.next;
			count++;
		}
	}

	public void giveNthElement(int index){
		int count = 0;

		Node n = head;

		while(n != null){

			if(count == index){
				System.out.println("Data at index " + index + " is: " + n.data);
				return;
			}
			n = n.next;
			count++;
		}
	}

	public int getCount(int key){
		Node n = head;
		int count = 0;

		while(n != null){
			if(n.data == key){
				count++;
			}
			n = n.next;
		}

		return count;
	}

	public void maxMin(){
		Node n = head;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		while(n != null){
			if(n.data > max){
				max = n.data;
			}

			if(n.data < min){
				min = n.data;
			}
			n = n.next;
		}

		System.out.println("Max is:" + max);
		System.out.println("Min is:" + min);
	}

	public void moveLastNodeAtFirst(){
		Node last = head;
		Node secondLast = null;
		while(last.next != null){
			secondLast = last;
			last = last.next;
		}

		secondLast.next = null;

		last.next = head;

		head = last;
	}

	public static void main(String[] args) {
		LinkedList_1_1 ll = new LinkedList_1_1(); //new empty linked list

		// ll.head = new Node(1);
		// Node second = new Node(2);
		// Node third = new Node(3);

		// ll.head.next = second;
		// second.next = third;

		ll.addNewNodeAtEnd(1);

		ll.addNewNodeAtEnd(2);

		ll.addNewNodeAtEnd(3);

		// ll.addNewNodeAtEnd(1);

		// ll.insertAfterGivenNode(2,4);

		// //ll.deleteNode(3);

		// ll.deleteNodeAtGivenIndex(3);

		// ll.printLinkedList();

		// ll.giveNthElement(1);

		// ll.maxMin();

		// System.out.println("frequency of given number is:" + ll.getCount(1));

		// System.out.println("lenght of linked list:" + ll.lengthOfLinkedList());

		// if(ll.searchElement(1)){
		// 	System.out.println("1 is present");
		// }else{
		// 	System.out.println("1 is not present");
		// }

		// if(ll.searchElement(0)){
		// 	System.out.println("0 is present");
		// }else{
		// 	System.out.println("0 is not present");
		// }

		ll.moveLastNodeAtFirst();

		ll.printLinkedList();


	}
}