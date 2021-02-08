//watch pepcoding video for this
public static long[] nextLargerElement(long[] arr, int n) { 
    // Your code here
    Stack<Long> s = new Stack<Long>();
    long[] result = new long[n];
    
    //iterate from last
    for(int i = n - 1; i >= 0; i--){
        
        //if stack is empty then result will be -1
        if(s.isEmpty()){
            result[i] = -1;
            s.push(arr[i]);
        }else{
            //if stack is not empty then pop until lerger element found on the top of stack
            while(!s.isEmpty() && s.peek() <= arr[i]){
                s.pop();
            }
            
            //set result at i with top of stack
            if(s.isEmpty()){
                result[i] = -1;
            }else{
                result[i] = s.peek();
            }
            
            //push current element in stack
            s.push(arr[i]);
        }
    }
    return result;
} 