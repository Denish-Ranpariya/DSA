//refer image for this algorithm
class GfG{
    int min = 0;
	public void push(int data,Stack<Integer> s)
	{
	    if(s.isEmpty()){
	        s.push(data);
	        min = data;
	        return;
	    }
	    
	    if(data < min){
	        s.push(2*data - min);
	        min = data;
	    }else{
	        s.push(data);
	    }
	    //add code here.
	}
	public int pop(Stack<Integer> s)
    {
        if(s.isEmpty()){
            return -1;
        }
        if(s.peek() < min){
            min = 2*min - s.peek();
            return s.pop();
            
        }else{
            return s.pop();
        }  //add code here.
	}
	public int min(Stack<Integer> s){
           //add code here.
           return min;
	}
	public boolean isFull(Stack<Integer>s, int n){
           //add code here.
           if(s.size() == n ){
               return true;
           }else{
               return false;
           }
	}
	public boolean isEmpty(Stack<Integer>s){
           //add code here.
           return s.isEmpty();
	}
}