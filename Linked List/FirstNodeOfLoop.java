//same code as remove loop but return slow.next at last

public static Node firstNodeOfLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        if(head == null || head.next == null){
            return;
        }
        Node slow = head;
        Node fast = head;
        
        //to detect the loop
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        
        //if loop exists
        if(slow == fast){
            //point slow to head
            //increment both by 1
            slow = head;
            while(slow.next != fast.next){
                slow = slow.next;
                fast = fast.next;
            }
            
            return slow.next;
            
        }
        
        
    }