//find middle node in linked list
//two pointer
//fast and slow
//fast iterate two times every time
//slow iterate one times evry time
//when fast pointer is null 

public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    
    if(head == null){
        return null;
    }
    
    if(head.next == null){
        return head;
    }
    
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    
    return slow;
}