import java.util.*;

//we have to generate all possible balanced parenthesis
//n = 2
//open brackets = closed brackets = 2
//(())
//()()

class GenerateBalancedParenthesis {
    static List<String> result = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        result.clear();

        //open = close = n
        int open = n;
        int close = n;
        
        //initialize output with empty string
        String output = "";
        
        solve(open,close,output);
        return result;
    }
    
    public static void solve(int open, int close, String output){

        //base case
        //when count of open and closed brackets both are 0 then add output to the result
        if(open == 0 && close == 0){
            result.add(output);
            return;
        }
        
        //choice of choosing open bracket is always there while count of opened brackets are not zero
        if(open != 0){
            //concatinating ( to previous output
            String output1 = output + "(";
            solve(open - 1, close, output1);
        }
        
        //choice of choosing closing bracket is not always there 
        //because we can use closing brackets if and only if there is a opening bracket present which is not balanced
        if(close > open){
            //concatinating ) to previous output
            String output1 = output + ")";
            solve(open, close - 1, output1);
        }
    }
}