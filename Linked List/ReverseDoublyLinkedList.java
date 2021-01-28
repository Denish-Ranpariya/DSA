//same as singly linked list
//little change because there are two pointers

public static Node reverseDLL(Node  head)
{
    //Your code here
    
    Node current = head;
    Node next = null;
    Node prev = null;
    
    while(current != null){
        next = current.next;
        
        current.next = prev;
        current.prev = next;
        
        prev = current;
        current = next;
        
    }
    
    return prev;
}