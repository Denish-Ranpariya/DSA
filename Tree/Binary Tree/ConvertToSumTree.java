//convert binary tree to sum tree
//leaf will be zero

class Tree{
    public void toSumTree(Node root){
        //add code here.
        
        solve(root);
        
    }
    
    public static int solve(Node node){
        
        //if node is null then return zero
        if(node == null){
            return 0;
        }
        
        //calculate the sum of left sum tree
        int left = solve(node.left);

        //calculate the sum of right sub tree
        int right = solve(node.right);
        
        //save current node' s data
        int current = node.data;
        
        //change current nodes data to sum of left and right sub tree
        node.data = left + right;
        
        //return left + current + right
        return left + right + current;
    }
}