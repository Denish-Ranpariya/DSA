//add one to the linked list which represent a number
//m-1
//reverce linkedlist
//add one to start
//reverce again

//m-2
//using recursion or stack

//m-3
//detect the last digit which is not 9 from left side 
//because we have to focus on 9
public static Node addOne(Node head) 
    { 
        Node current = head;
        Node last = null;
        while(current.next != null){
            //to find the last node which value is not 9
            if(current.data != 9){
                last = current;
            }
            current = current.next;
        }
        
        //if there is no 9 (current is the end of linked list)
        if(current.data != 9){
            current.data++;
            return head;
        }
        
        //if there all the 9 (like 9999...)
        if(last == null){
             
            last = new Node(0);
            last.next = head;
            head = last;
        }   
        
        
        //if last is in between ( like 124999)
        
            
        last.data++;
        last = last.next;
        while(last != null){
            last.data = 0;
            last = last.next;
        }
        return head;
        
        
    }