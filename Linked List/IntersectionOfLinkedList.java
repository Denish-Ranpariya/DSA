//intersection of sorted linked list

public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
        
        Node current1 = head1;
        Node current2 = head2;
        
        Node head3 = null;
        Node last = null;
        
        
        while(current1 != null && current2 != null){
            if(current1.data == current2.data){
                Node temp = new Node(current1.data);
                
                //add new Node at last
                if(head3 == null){
                    head3 = temp;
                    last = head3;
                }else{
                    last.next = temp;
                    last = temp;
                }
                
                current1 = current1.next;
                current2 = current2.next;
            }else if(current1.data > current2.data){
                current2 = current2.next;
            }else{
                current1 = current1.next;
            }
        }
        
        return head3;
    }