//most unique type of problem

class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        
        
        MinMax minMax = solve(root);
        
        return minMax.size;
        
    }
    
    public static MinMax solve(Node root){
        if(root == null){
            return new MinMax();
        }
        
        MinMax left = solve(root.left);
        MinMax right = solve(root.right);
        
        
        MinMax minMax = new MinMax();
        
        if(left.isBST == false || right.isBST == false || left.max >= root.data || right.min <= root.data){
            minMax.isBST = false;
            minMax.size = Math.max(left.size, right.size);
            
            return minMax;
        }
        
        minMax.isBST  = true;
        minMax.size = left.size + right.size + 1;
        minMax.min = root.left != null ?  left.min : root.data;
        minMax.max = root.right != null ? right.max : root.data;
        
        return minMax;
        
    }
    
}


class MinMax{
    boolean isBST;
    int size;
    int min;
    int max;
    
    MinMax(){
        isBST = true;
        size = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }
}