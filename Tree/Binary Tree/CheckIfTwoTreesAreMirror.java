//same as identical tree
//just compare left with right and right with left
class Tree {
    boolean areMirror(Node root1, Node root2) {
        
        //if both are null then return true
        if(root1 == null && root2 == null){
            return true;
        }
        
        //if one of them is null and another is not then return false
        if((root1 == null && root2 != null) || (root1 != null && root2 == null)){
            return false;
        }
        
        //if both node's data is not same then return false
        if(root1.data != root2.data){
            return false;
        }
        
        //call for root1's left subtree and root2's right subtree 
        //call for root1's right subtree and root2's left subtree
        boolean left = areMirror(root1.left, root2.right);
        boolean right = areMirror(root1.right, root2.left);
        
        //if they are identical then resturn true else return false
        if(left && right){
            return true;
        }else{
            return false;
        }
    }
}