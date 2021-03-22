//Given a BST and an integer. 
//Find the least absolute difference between any node value of the BST and the given integer.

//do biinarysearch in BST at every node take difference and update minimum
//TC O(height of tree) because we are using binary search
//SC O(height of sub tree) because we are visiting only one node at one level
class Solution
{
    static int minDifference;
    static int maxDiff(Node  root, int K) 
    { 
        //minimum
        minDifference = Integer.MAX_VALUE;
        
        solve(root, K);
        
        return minDifference;
    } 
    
    public static void solve(Node node, int k){
        
        //base condition
        if(node == null){
            return;
        }
        
        //calculate difference and update minimum
        minDifference = Math.min(minDifference, Math.abs(k - node.data));
        
        //if key is greater than node's data then go to right sub tree
        if(node.data < k){
            solve(node.right, k);
        }else{
            //if key is smaller than node's data then go to left sub tree
            solve(node.left, k);
        }
    }
}