//Remove duplicates from an unsorted linked list
//TC O(n)
//SC O(n)
public Node removeDuplicates(Node head) 
    {
         // Your code here
         HashSet<Integer> hs = new HashSet<Integer>();
         
         Node current = head;
         Node previous = null;
         while(current != null){
            if(hs.contains(current.data)){
                previous.next = current.next;
            }else{
                hs.add(current.data);
                previous = current;
            }
            current = current.next;
             
         }
         return head;
    }