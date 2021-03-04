//input-output method in recursion

class Tree {
    //is path is there or not
    static boolean isPresent = false;
    boolean hasPathSum(Node root, int S) {
        
        //reset global statics
        isPresent = false;
        
        //input - root
        //output - sum = 0
        searchPath(root, 0, S);
        return isPresent;
    }
    
    public static void  searchPath(Node node,int sum, int S){

        //base case
        if(node == null){
            return;
        }
        
        //if leaf node
        if(node.left == null && node.right == null){

            //add data of leaf node to sum
            sum += node.data;

            //check if sum is equals to required sum or not
            if(sum == S){
                isPresent = true;
                return;
            }
        }
        
        //copy sum in both sums
        int sum1 = sum;
        int sum2 = sum;
        
        //add current node's data in both sums
        sum1 += node.data;
        sum2 += node.data;
        
        //call recursive functions for left and right with sum1 and sum2
        searchPath(node.left, sum1, S);
        searchPath(node.right, sum2, S);
        
    }
}