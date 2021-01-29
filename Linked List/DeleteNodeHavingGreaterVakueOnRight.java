Node compute(Node head)
    {
        // your code here
        
        //first we will reverse the linked list
        head = reverse(head);
        
        //we will track of Node with max value
        
        Node current = head.next;
        Node max = head;
        
        while(current != null){
            //if the value of current node is larger than max then make it max
            //else delete current node
            if(current.data >= max.data){
                max = current;
                current = current.next;
            }else{
                //delete the node
                Node temp = current;
                max.next = current.next;
                current = current.next;
                temp.next = null;
            }
            
        }
        
        //revrese the list again
        head = reverse(head);
        return head;
        
    }