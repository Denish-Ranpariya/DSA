// Given a Binary Tree, find diameter of it.
// The diameter of a tree is the number of nodes on the longest path between two end nodes in the tree.

class Tree {
    
    //max diameter
    static int max = 0;
    int diameter(Node root) {
        // reset global statics
        max = 0;

        //call height function
        height(root);
        return max;
    }
    
    public static int height(Node node){
        //base case
        if(node == null){
            return 0;
        }
        
        //height of left subtree
        int left = height(node.left);

        //height of right subtree
        int right = height(node.right);
        
        //diameter according to current node which is (height of left subtree + height of right subtree + 1(node itself))
        //if this diameter is greater than max then set max with it
        if(left + right + 1 > max){
            max = left + right + 1;
        }
        
        return 1 + Math.max(left, right);
    }
}
