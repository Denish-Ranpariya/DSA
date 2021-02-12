class Solution{
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        // code here
        
        if(sizeOfStack == 0){
            return;
        }
        
        //calculate which element should be deleted i.e. if(1,2,3,4) then delete 3
        
        int k = sizeOfStack/2 + 1;
        
        solve(s,k);
    } 
    
    public static Stack<Integer> solve(Stack<Integer> s, int k){
        //base case
        if(k == 1){
            s.pop();
            return s;
        }
        
        //pop the top of stack and call function for k - 1
        int top = s.pop();
        
        solve(s,k - 1);
        
        //insert popped element
        s.push(top);
        
        return s;
    }
}