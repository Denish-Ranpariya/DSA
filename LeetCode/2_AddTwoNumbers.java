class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        
        
        ListNode newHead = null;
        ListNode newTail = null;
        
        int carry = 0;
        
        while(current1 != null || current2 != null){
            int data1 = (current1 == null) ? 0 : current1.val;
            int data2 = (current2 == null) ? 0 : current2.val;
            
            int sum = data1 + data2 + carry;
            carry = sum / 10;
            int data = sum % 10;
            
            ListNode newNode = new ListNode(data);
            
            if(newHead == null){
                newHead = newNode;
                newTail = newNode;
            }else{
                newTail.next = newNode;
                newTail = newNode;
            }
            
            current1 = (current1 == null ) ? current1 : current1.next;
            current2 = (current2 == null ) ? current2: current2.next;
        }
        
        if(carry != 0){
           ListNode newNode = new ListNode(carry);
            newTail.next = newNode;
            newTail = newNode;
        }
        return newHead;
    }
}