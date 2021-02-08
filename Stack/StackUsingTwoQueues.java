//using two queues we can implement stack
//m-1 : by making push operation costly
//m-2 : by making pop operation costly

//Method-1

class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    //we will do it by making push operation costly
    
    /*The method pop which return the element poped out of the stack*/
    int pop()
    {
	    // Your code here 
	    if(q1.isEmpty()){
	        return -1;
	    }
	    return q1.remove();
    }
	
    /* The method push to push element into the stack */
    void push(int a)
    {
	    // Your code here
	    
	    //push operation is costly
	    //if there are elements present in q1 then move all to the q2
	    //then add a to q1
	    //after that move all elements from q2 to q1
	    
	    
        int size = q1.size();
        for(int i = 0; i < size; i++){
            int temp = q1.remove();
            q2.add(temp);
        }
        
        q1.add(a);
        
	    size = q2.size();
	    
	    for(int i = 0; i < size; i++){
	        int temp = q2.remove();
	        q1.add(temp);
	    }
	    
	    
    }
}

//Method - 2
class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    //now we will do it by making pop operation costly
    
    /*The method pop which return the element poped out of the stack*/
    int pop()
    {
        if(q1.isEmpty()){
            return -1;
        }
	    //dequeue all the elememts from q1 except last one and put it to q2
	    int size = q1.size();
	    
	    for(int i = 0; i < size - 1; i++){
	        int temp = q1.remove();
	        q2.add(temp);
	    }
	    
	    int poppedElement = q1.remove();
	    
	    //again put all the elements in q1
	    
	    size = q2.size();
	    
	    for(int i = 0; i < size; i++){
	        int temp = q2.remove();
	        q1.add(temp);
	    }
	    return poppedElement;
    }
	
    /* The method push to push element into the stack */
    void push(int a)
    {
	    // Your code here
	    q1.add(a);
    }
}