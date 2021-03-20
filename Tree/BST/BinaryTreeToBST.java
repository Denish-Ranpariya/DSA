//given a binary tree
//convert it to BST

//inorder traversal of binary tree
//save it to list
//sort it
//again do inorder traversal and replace node's value from sorted list

class GfG
{
    //list to save inorder traversal of binary tree
    static ArrayList<Integer> list = new ArrayList<Integer>();

    //keep track of list index
    static int index = 0;
    
    Node binaryTreeToBST(Node root)
    {
        //reset global statics
        list.clear();
        index = 0;
        
        //inorder traversal of binary tree
        inorder(root);
        
        //sort inorder of binary tree
        Collections.sort(list);
        
        //again inorder traversal of binary tree and replace nodes data with sorted data
        replaceNodesData(root);
        
        return root;
    }
    

    //inorder traversal 
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        list.add(root.data); //add to list
        inorder(root.right);
    }
    
    public static void replaceNodesData(Node root){
        if(root == null){
            return;
        }
        replaceNodesData(root.left);

        //replace nodes data with sorted data and increment index by 1
        root.data = list.get(index);
        index++;
        replaceNodesData(root.right);
    }
}
 