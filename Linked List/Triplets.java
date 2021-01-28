// Java implementation to count triplets in a sorted doubly linked list
// whose sum is equal to a given value 'x'

//3-methods

//m-1
//bruteforce
//O(n^3)

//m-2
//using hash map 
//insert all the node in hash map (data,ptr)
//two nested loop for finding sum - ptr1.data - ptr2.data in hashmap
//if found count++
//return count/3 because their count thrise
//TC O(n^2)
//SC O(n) 

//m-3
//using two pointer method
//outer loop iterate from first to last
//inside two pointer find the sum - ptr1
//O(n^2)





//Copied Code from gfg
//only function is implemented


import java.util.*;

class Triplets{

// structure of node of doubly linked list
static class Node {
	int data;
	Node next, prev;
};

// function to count pairs whose sum equal to given 'value'


// function to count triplets in a sorted doubly linked list
// whose sum is equal to a given value 'x'
static int countTriplets(Node head, int x)
{
	if(head == null){
		return 0;
	}

	int count = 0;
	Node current = head;

	

	Node last = head;

	while(last.next != null){
		last = last.next;
	}

	while(current != null){
		//two poniter
		Node first = current.next;
		Node second = last;
		int sum = x - current.data;
		while(first != null && second != null && first != second && second.next != first){
			if( first.data + second.data == sum){
				count++;
				System.out.print(first.data);
				System.out.print(second.data);
				System.out.print(current.data);
				System.out.println();
				first = first.next;
				last = second.prev;

			}else if(first.data + second.data < sum){
				first = first.next;
			}else{
				second = second.prev;
			}
		}
		current = current.next;
	}

	return count;
	
}

// A utility function to insert a new node at the
// beginning of doubly linked list
static Node insert(Node head, int data)
{
	// allocate node
	Node temp = new Node();

	// put in the data
	temp.data = data;
	temp.next = temp.prev = null;

	if ((head) == null)
		(head) = temp;
	else {
		temp.next = head;
		(head).prev = temp;
		(head) = temp;
	}
	return head;
}

// Driver program to test above
public static void main(String[] args)
{
	// start with an empty doubly linked list
	Node head = null;

	// insert values in sorted order
	head = insert(head, 9);
	head = insert(head, 8);
	head = insert(head, 6);
	head = insert(head, 5);
	head = insert(head, 4);
	head = insert(head, 2);
	head = insert(head, 1);

	int x = 17;

	System.out.print("Count = "
		+ countTriplets(head, x));
}
}

// This code is contributed by 29AjayKumar
