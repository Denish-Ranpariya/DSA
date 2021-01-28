//merge k sorted linked list
//we will take one by one and apply merge function

Node mergeKList(Node[]a,int N)
    {
        //Add your code here.
        Node head = null;
        
        for(int i = 0;i < N; i++){
            Node current = a[i];
            head = merge(head,current);
        }
        return head;
    }
    
    public static Node merge(Node head1,Node head2){
        Node current1 = head1;
        Node current2 = head2;
        
        Node dummyNode = new Node(0);
        Node tail = dummyNode;
        while(current1 != null && current2 != null){
            if(current1.data < current2.data){
                tail.next = current1;
                tail = tail.next;
                current1 = current1.next;
            }else{
                tail.next = current2;
                tail = tail.next;
                current2 = current2.next;
            }
        }
        if(current1 != null){
            tail.next = current1;
        }
        if(current2 != null){
            tail.next = current2;
        }
        return dummyNode.next;
    }