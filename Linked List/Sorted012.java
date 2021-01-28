//sort linked list contains only 0 1 and 2

static Node segregate(Node head)
    {
        //we will count number of 0s 1s and 2s
        
        int ones = 0,twos = 0,zeroes = 0;
        
        Node current = head;
        while(current != null){
            if(current.data == 0){
                zeroes++;
            }else if(current.data == 1){
                ones++;
            }else{
                twos++;
            }
            current = current.next;
        }
        
        //change data of current node according to counters
        current = head;
        while(current != null){
            if(zeroes != 0){
                current.data = 0;
                zeroes--;
            }else if(ones != 0){
                current.data = 1;
                ones--;
            }else{
                current.data = 2;
                twos--;
            }
            current = current.next;
        }
        return head;
    }