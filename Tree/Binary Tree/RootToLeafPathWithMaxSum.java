//input-output method recursion

class Tree {
    
    //max sum
    static int maxSum = Integer.MIN_VALUE;
    boolean maxPathSum(Node root, int S) {
        
        //reset global statics
        maxSum = Integer.MIN_VALUE;
        
        //input - root
        //output - sum = 0
        maxPath(root, 0);

        System.out.println(maxSum);
        return true;
    }
    
    public static void  maxPath(Node node, int sum){
        
        //base case
        if(node == null){
            return;
        }
        
        // if leaf node then add its data to sum 
        // then check if it is greater than max sum or not
        if(node.left == null && node.right == null){
            sum += node.data;
            if(sum > maxSum){
                maxSum = sum;
                return;
            }
        }
        
        //copy sum to both sum1 and sum2
        int sum1 = sum;
        int sum2 = sum;
        
        //add current nodes data both sum1 and sum2
        sum1 += node.data;
        sum2 += node.data;
        
        //call recursive functions for left and right with sum1 and sum2
        maxPath(node.left, sum1);
        maxPath(node.right, sum2);
        
    }
}