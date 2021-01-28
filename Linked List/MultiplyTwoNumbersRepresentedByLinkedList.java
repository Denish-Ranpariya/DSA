//multiply two numbers represented by two linked list
//i.e. 1->0->0 * 2->1
//ans 2100 in int
//we have to modulo each time (given in question)

public long multiplyTwoLists(Node l1,Node l2){
          //add code here.
        long number1 = 0;
        long number2 = 0;
        
        Node current1 = l1;
        Node current2 = l2;
        
        while(current1 != null){
            number1 = (number1*10 + current1.data) % 1000000007;
            current1 = current1.next;
        }
        while(current2 != null){
            number2 = (number2*10 + current2.data) % 1000000007;
            current2 = current2.next;
        }
        
        return (number1 * number2) % 1000000007;
   }