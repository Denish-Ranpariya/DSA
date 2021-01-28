//program to reverse a linked list



//iterative method
Node reverseList(Node head){
    Node previous = null;
    Node current = head;
    Node next = null;
    while(current != null){
        next = current.next;
        //actual revercing
        current.next = previous;
       
        //update variables
        previous = current;
        current = next;
    }// code here
   
    head = previous;
    return head;
}

//recursive method
static Node reverse(Node head) 
    { 
        if (head == null || head.next == null) 
            return head; 
 
        /* reverse the rest list and put 
        the first element at the end */
        Node rest = reverse(head.next); 
        head.next.next = head; 
 
        /* tricky step -- see the diagram */
        head.next = null; 
 
        /* fix the head pointer */
        return rest; 
    } 