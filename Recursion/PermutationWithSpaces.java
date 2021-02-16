class Solution{
    static ArrayList<String> result = new ArrayList<String>();
    
    ArrayList<String> permutation(String S){
        
        result.clear();
        // remove first character from input string and add it to output
        String output = Character.toString(S.charAt(0));
        String input = S.substring(1);
        
        solve(input,output);
        
        return result;
    }
    
    public static void solve(String input, String output){

        //base case
        //if input is empty then add output to result
        if(input.equals("")){
            result.add(output);
            return;
        }
        
        //copy same string to both outputs from output
        String output1 = output;
        String output2 = output;
        
        //remove first character from input
        char ch = input.charAt(0);
        input = input.substring(1);
        
        //include space before removed character
        output1 += " " + Character.toString(ch);

        //directly add removed chracter
        output2 += Character.toString(ch);
        
        //call recursive functions for both cases
        solve(input,output1);
        solve(input,output2);
    }
}