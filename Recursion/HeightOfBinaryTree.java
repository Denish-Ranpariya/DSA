class Solution {
    int height(Node node) {
        // code here 
        if(node == null){
            return 0;
        }
        int leftSubtreeHeight = height(node.left);
        int rightSubtreeHeight = height(node.right);
        
        return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }
}