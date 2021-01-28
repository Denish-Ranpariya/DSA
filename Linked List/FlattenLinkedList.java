//flatten linked list
//one by one sort two linked list

Node flatten(Node root)
    {
	// Your code here
	    Node current_outer = root;
	    Node head = null;
	    while(current_outer != null){
	        
	        head = merge(head,current_outer);
	        
	        current_outer = current_outer.next;
	    }
	    return head;
    }
    
    //merge two sorted linked list
    public static Node merge(Node head1,Node head2){
        Node current1 = head1;
        Node current2 = head2;
        
        Node dummyNode = new Node(0);
        Node tail = dummyNode;
        while(current1 != null && current2 != null){
            if(current1.data < current2.data){
                tail.bottom = current1;
                tail = tail.bottom;
                current1 = current1.bottom;
            }else{
                tail.bottom = current2;
                tail = tail.bottom;
                current2 = current2.bottom;
            }
        }
        if(current1 != null){
            tail.bottom = current1;
        }
        if(current2 != null){
            tail.bottom = current2;
        }
        return dummyNode.bottom;
    }