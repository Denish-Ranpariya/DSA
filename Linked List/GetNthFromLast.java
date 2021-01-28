int getNthFromLast(Node head, int n)
    {
    	// Your code here
    	
    	//m-1
        //by finding length
        //length - n + 1
        
    	//m-2
    	//without finding length
    	//two poniter method
    	//like sliding window
    	
    	if(n <= 0){
    	    return -1;
    	}
    	Node first = head;
    	Node second = head;
    	
    	//move second pointer n times
    	
    	int afterNull = 0; //for count if overflow of second
    	for(int i = 0; i < n; i++){
    	    if(second == null){
    	       afterNull++;
    	    }else{
    	        second = second.next;
    	    }
    	}
    	
    // 	System.out.println("afterNull:" + afterNull);
    	if(afterNull != 0){
    	    return -1;
    	}
    
    	//move both pointer until second reach to null
    	while(second != null){
    	    first = first.next;
    	    second = second.next;
    	}
    	
    	return first.data;
    	
    	
    }