//check leetcode 38
class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        
        
        String prev = countAndSay(n-1) + "$";
        
        int count = 1;
        
        String result = "";
        
        for(int i = 1; i < prev.length(); i++){
            if(prev.charAt(i) == prev.charAt(i-1)){
                count++;
            }else{
                result += Integer.toString(count) + Character.toString(prev.charAt(i - 1));
                count = 1;
            }
        }
        
        return result;
    }
}