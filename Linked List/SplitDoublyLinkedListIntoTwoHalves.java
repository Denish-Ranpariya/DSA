void splitList(circular_LinkedList list)
        {
             // Your code here
             Node head = list.head;
             
             if(head == null){
                 return;
             }
             
             //to find middle node
             Node fast = head;
             Node slow = head;
             
             while(fast.next != head && fast.next.next != head){
                 fast = fast.next.next;
                 slow = slow.next;
             }
             
             Node midNode = slow;
             
             list.head2 = midNode.next;//head of second linked list
             
             //make first half circular
             midNode.next = head;
             list.head1 = head;
             
             //make second half circular
             Node current = list.head2;
             
             while(current.next != head){
                 current = current.next;
             }
             
             current.next = list.head2;
	 }