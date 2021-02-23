class BinaryTree
{
    static ArrayList<Integer> result = new ArrayList<Integer>();
    /* Computes the number of nodes in a tree. */
    static ArrayList<Integer> preorder(Node root)
    {
        result.clear();
        traverse(root);
        
        return result;
    }
    
    public static void traverse(Node root){
        if(root == null){
            return;
        }
        
        //visit node
        //left subtree
        //right subtree
        result.add(root.data);
        traverse(root.left);
        traverse(root.right);
    }

}