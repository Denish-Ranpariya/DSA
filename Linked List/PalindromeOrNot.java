//program to check wether given singly linked list is palindrom or not
public boolean isPalindrome(ListNode head) {
        
        if(head == null){
            return true;
        }
        
        if(head.next == null){
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        //find mid
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow;
        
        //now reverse the half of linked list from mid to end
        ListNode current = mid;
        ListNode next = null;
        ListNode previous = null;
        
        while(current != null) {
            next = current.next;
            
            current.next = previous;
            
            previous = current;
            current = next;
        }
        
        prev.next = previous;
        
        //now one pointer from start and other from middle
        
        ListNode first_pointer = head;
        ListNode second_pointer = previous;
        
        while(first_pointer != previous && second_pointer != null){
            if(first_pointer.val != second_pointer.val){
                return false;
            }
            first_pointer = first_pointer.next;
            second_pointer = second_pointer.next;
        }
        
        return true;
        
    }