//find Y shape intersection of two linked list

//m-1
//bruteforce
//O(n*m)

//m-2
//find the length of both linked list
//find the difference
//iterate in the longer list for the difference times
//now iterate in both linked list until current1 == current2
//don't compare values, compare pointers
//O(n+m)

int intersectPoint(Node head1, Node head2)
	{
	    Node current1 = head1;
        Node current2 = head2;
        int c1 = 0, c2 = 0;
        
        //count
        while( current1 != null ){
            c1++;
            current1 = current1.next;
        }
        
        while( current2 != null ){
            c2++;
            current2 = current2.next;
        }
        
        
        //count the difference and reach at the point where both meets with same length
        current1 = head1;
        current2 = head2;
        int difference = 0;
        if(c1 > c2){
            difference = c1 - c2;
            
            while(difference != 0){
                current1 = current1.next;
                difference--;
            }
        }else{
            difference = c2 - c1;
            
            while(difference != 0){
                current2 = current2.next;
                difference--;
            }
        }
        
        
        int intersection = -1;
        
        while(current1 == current2){
            if(current1.data == current2.data){
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        
        return -1;
        
	}