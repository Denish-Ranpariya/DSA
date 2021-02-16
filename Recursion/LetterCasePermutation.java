class Solution {
    
    static List<String> result = new ArrayList<String>();
    public List<String> letterCasePermutation(String S) {
        result.clear();
        
        //input is given string
        String input = S;
        
        //initialize output as empty
        String output = "";
        
        //call function
        solve(input,output);
        return result;
    }
    
    public static void solve(String input,String output){
        
        //base case 
        //when input becomes empty add it to result
        if(input.equals("")){
            result.add(output);
            return;
        }
        
        //remove first character from input
        char ch = input.charAt(0);
        input = input.substring(1);
        
        //initialize both outputs with output
        String output1 = output;
        String output2 = output;
        
        //if character is letter
        if(Character.isLetter(ch)){
            //if it is uppercase 
            //then add ad it is to the output 1 
            //and for output 2 convert it to lowercase
            if(Character.isUpperCase(ch)){
                output1 += Character.toString(ch);
                output2 += Character.toString(Character.toLowerCase(ch));
            }else{
                //if it is lowercase 
                //then add ad it is to the output 1 
                //and for output 2 convert it to uppercase
                output1 += Character.toString(ch);
                output2 += Character.toString(Character.toUpperCase(ch));
            }
            
            //call recursive function for both cases
            solve(input,output1);
            solve(input,output2);
        }else{
            //if it is digit
            //then add it to output and call recursive function for only one time
            output1 += Character.toString(ch);
            solve(input,output1);
        }
    }
}