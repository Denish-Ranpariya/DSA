class Solution {
    //result list
    static ArrayList<String> result = new ArrayList<String>();
    ArrayList<String> NBitBinary(int N) {
        
        //reset global static
        result.clear();
        
        //number of ones and zeroes are same as N
        int zeroes = N;
        int ones = N;
        
        //initial output string will be empty
        String output = "";
        
        //call recursive functions 
        solve(zeroes,ones,output,N);
        return result;
    }
    
    public static void solve(int zeroes, int ones,String output,int n){
        
        //if length of the string is equal to n then add it to the list
        //base case
        if(output.length() == n){
            result.add(output);
            return;
        }
        
        //we can take 1 any time when its balance is greater than 0
        if(ones > 0){
            //concat 1 after output and call recursive function
            String output1 = output + "1";
            
            //decrement balance of 1 by 1
            solve(zeroes, ones - 1, output1, n);
        }
        
        //we can't take 0 every time
        //when balance of zero is greater than one then take 0
        if(zeroes > ones){
            //concat 0 after output and call recursive function
            String output2 = output + "0";
            
            //decrement balance of 0 by 1
            solve(zeroes - 1, ones, output2, n);
        }
    }
}