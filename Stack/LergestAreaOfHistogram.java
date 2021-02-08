public static long getMaxArea(long arr[], long size)  {
    // your code here
    
    int n = (int)size;
    //use concept of next greater element
    
    
    //right side first smaller element index
    long[] right = new long[(int)n];

    //we will use  stack to store the index
    Stack<Integer> s = new Stack<Integer>();
    
    for(int i = n - 1; i >= 0 ; i--){
        
        //if stack is empty
        if(s.isEmpty()){
            right[i] = n;
            s.push(i);
        }else{
            //pop unitl smaller element is found at the top of the stack
            while(!s.isEmpty() && arr[i] <= arr[s.peek()]){
                s.pop();
            }
            
            if(s.isEmpty()){
                right[i] = n;
            }else{
                right[i] = s.peek();
            }
            
            s.push(i);
        }
        
    }
        
    //left side first smaller element index
    long[] left = new long[(int)n];
    Stack<Integer> s1 = new Stack<Integer>();
    
    for(int i = 0; i < n ; i++){
        
        //if stack is empty
        if(s1.isEmpty()){
            left[i] = -1;
            s1.push(i);
        }else{
            //pop unitl smaller element is found at the top of the stack
            while(!s1.isEmpty() && arr[i] <= arr[s1.peek()]){
                s1.pop();
            }
            
            if(s1.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = s1.peek();
            }
            
            s1.push(i);
        }
        
    }
    
    
    long maxArea = 0;
    for(int i = 0; i < n; i++){
        long width = right[i] - left[i] - 1;
        long area =  width * arr[i];
        
        if(area > maxArea) {
            maxArea = area;
        }
        
    }
    
    return maxArea;
}