// https://leetcode.com/problems/k-th-symbol-in-grammar/submissions/

// row 1: 0
// row 2: 01
// row 3: 0110
// row 4: 01101001
class Solution {
    
    public int kthGrammar(int N, int K) {

        //base condition already given
        if(N == 1 || K == 1){
            return 0;
        }
        
        //calculate mid 
        //length will be 2 to power n-1
        int mid = (int)(Math.pow(2,N-1) / 2);
        
        //if k is smaller than mid then return previous row's kth element
        if(K <= mid){
            return kthGrammar(N - 1, K);
        }else{
            //else return compiment of previous rows k - mid element
            return kthGrammar(N - 1, K - mid) == 0 ? 1 : 0;
        }
    }
    
    
}