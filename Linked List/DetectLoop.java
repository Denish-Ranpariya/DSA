//program to detect loop in linked list

//method 1
//using hashset or hashmap
//if hashset or hashmap does not including the node then insert the node in it
//insert whole node not just the value because the value can be repeated
//TC O(n)
//SC O(n)

//method 2
//using 2 pointer method
//one pointer which is slow pointer which increase by 1 every time
//second pointer which is fast pointer which increases by 2 every time
//if these two pointer meets at same location then linked list is cointaining a loop

public static boolean detectLoop(Node head){
        // Add code here
        if(head == null || head.next == null){
            return false;
        }
        
        Node slowPointer = head;
        Node fastPointer = head;
        
        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(fastPointer == slowPointer){
                return true;
            }
            
        }
        return false;
    }