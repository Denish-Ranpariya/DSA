//same as construct binary tree from inorder and preorder but
//only difference is in postorder start from last 
//and recursive call for right node will be before left subtree 
class GfG {
    //index for post order
    static int postorderIndex;
    Node buildTree(int inorder[], int postorder[], int n) {
        
        //reset it to n - 1
        postorderIndex = n - 1;
        
        if(n == 0){
            return null;
        }
        
        //function call
        return buildBinaryTreeFromPostorderInorder(inorder, postorder, 0, n - 1);
    }
    
    public static Node buildBinaryTreeFromPostorderInorder(int[] inorder, int[] postorder, int start, int end){
        
        //base case
        if(start > end){
            return null;
        }
        
        //create new node from preorder and decrease index of postorder by 1
        Node newNode = new Node(postorder[postorderIndex]);
        postorderIndex--;
        
        //if start and end are same then return node
        if(start == end){
            return newNode;
        }
        
        //search for node in inorder
        int inorderIndex = search(inorder, newNode.data, start, end);
        
        //for right index + 1 to end
        newNode.right = buildBinaryTreeFromPostorderInorder(inorder, postorder, inorderIndex + 1, end);
        //for left start to index - 1
        newNode.left = buildBinaryTreeFromPostorderInorder(inorder, postorder, start, inorderIndex - 1);
        
        //return node
        return newNode;
    }
    
    //function to find index in inorder
    public static int search(int[] inorder,int key, int start,int end){
        for(int i = start; i <= end; i++){
            if(inorder[i] == key){
                return i;
            } 
        }
        return -1;
    }
}
