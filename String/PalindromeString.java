class Solution {
    int isPlaindrome(String s) {
        // code here
        int n = s.length();
        
        int l = 0;
        int h = n - 1;
        
        while(l < h){
            if(s.charAt(l) != s.charAt(h)){
                return 0;
            }
            l++;
            h--;
        }
        
        return 1;
    }
};