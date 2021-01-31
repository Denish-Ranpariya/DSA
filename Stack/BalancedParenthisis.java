//check if string of parenthisis is balanced or not
// Input:
// {([])}

// Output: 
// true

// Input: 
// ([]

// Output: 
// false
static boolean ispar(String x)
{
    // add your code here
    Stack<Character> s = new Stack<Character>();
    for(int i = 0; i < x.length(); i++){
        
        char ch = x.charAt(i);
        //System.out.println(ch);

        //if any type of starting parenthesis just push to the stack
        if(ch == '(' || ch == '{' || ch == '['){
            s.push(ch);
            //System.out.println("Pushed element: "+ ch);

        //if it is closed parenthisis then check the top of stack
        //if top of the stack is opposite of the closed parenthesis then pop it
        }else if((!s.isEmpty() && s.peek() == '(' && ch == ')') || (!s.isEmpty() && s.peek() == '{' && ch == '}') || (!s.isEmpty() && s.peek() == '[' && ch == ']')){
            s.pop();
            // int temp = s.pop();
            //System.out.println("Popped element: "+ temp);
        }else{
            return false;
        }
    }
    
    //after travercing if stack is not empty then unbalanced else balanced
    if(s.isEmpty()){
        return true;
    }else{
        return false;
    }
}