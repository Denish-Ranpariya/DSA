class Solution {
    public int longestValidParentheses(String s) {
        
        //character stack (store the ())
        Stack<Character> cs = new Stack<Character>();
        
        //index stack (store last invalid index)
        Stack<Integer> is = new Stack<Integer>();
        
        is.push(-1);
        
        int maxLength = 0;
        
        for(int i = 0; i < s.length(); i++){
            int length = 0;
            if(s.charAt(i) == '('){
                //if it is opening bracket just push it to char stack and index to index stack
                cs.push('(');
                is.push(i);
            }else{
                //if it is closing bracket

                if(cs.isEmpty() || cs.peek() == ')'){
                    //if top of stack is closing bracket  then push index
                    is.push(i);
                }else{
                    //the top of the stack is opening bracket so pop it and find lenght
                    cs.pop();
                    is.pop();
                    length = i - is.peek(); //length = current index - last index with problem
                }
                
            }
            
            if(length > maxLength){
                maxLength = length;
            }
        }
        return maxLength;
    }
}