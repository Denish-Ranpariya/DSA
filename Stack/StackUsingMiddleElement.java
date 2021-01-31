// Design a stack with operations on middle element
// How to implement a stack which will support following operations in O(1) time complexity?
// 1) push() which adds an element to the top of stack.
// 2) pop() which removes an element from top of stack.
// 3) findMiddle() which will return middle element of the stack.
// 4) deleteMiddle() which will delete the middle element.
// Push and pop are standard stack operations. 

//here we have to implement above operations in O(1)
//we cannot use array because in delete opration we have to shift all the elements which will take O(n) time
//so we we have to use linked list
//if we use singly linked list we cannot go backward
//so we will use doubly linked list to implement stack

//here i have implemented first three methods
//deletion can be done according to the count on basis of even or odd

//if stack is
//5
//4
//3
//2
//1
//mid = 3

//if stack is 
//4
//3
//2
//1
//mid = 3

//mid = length/2 +1

//node for doubly linked list
class Node{
	int data;
	Node prev;
	Node next;
	Node(int data){
		this.data = data;
		prev = null;
		next = null;
	}
}

//we will add node from font in dll in push operation and delete node in dll from front in pop operation so that it will act as a stack
class Stack{
	Node head; //top in stack 
	Node mid;
	int count;
	Stack(){
		head = null;
		mid = null;
		count = 0;
	}

	void push(int data){
		Node newNode = new Node(data);

		if(head == null){
			head = newNode;
			mid = newNode;
			count++;
		}else{
			//add from front
			newNode.next = head;
			head.prev = newNode;
			head = newNode;

			//set mid

			//for odd count
			//if 
			//3
			//2
			//1
			//mid = 2
			//push(4)
			//4
			//3
			//2
			//1
			//mid = 3

			//for even count
			//if 
			//4
			//3
			//2
			//1
			//mid = 3
			//push(5)
			//5
			//4
			//3
			//2
			//1
			//mid = 3
			if(count % 2 == 0){
				//as it is
			}else{
				mid = mid.prev;
			}
			count++;
		}
	}

	void printStack(){
		Node current = head;
		while(current != null){
			System.out.println(current.data);
			current = current.next;
		}
	}

	int pop(){
		if(head == null){
			System.out.println("Stack is empty.");
			return -1;
		}else{
			//remove from front
			Node temp = head;
			head = head.next;
			temp.next = null;
			head.prev = null;

			//set mid
			//if odd
			//5
			//4
			//3
			//2
			//1 mid = 3
			//pop()
			//4
			//3
			//2
			//1
			//mid = 3

			//if even
			//4
			//3
			//2
			//1
			//mid = 3
			//pop()
			//3
			//2
			//1
			//mid = 2

			if(count % 2 == 0){
				mid = mid.next;
			}

			count--;
			return temp.data;
		}
	}

	int getMiddleElement(){
		return mid.data;
	}
}

class StackUsingMiddleElement{
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println("Popped element: " + s.pop());
		System.out.println("Popped element: " + s.pop());
		System.out.println("Mid: " + s.getMiddleElement());
	}
}