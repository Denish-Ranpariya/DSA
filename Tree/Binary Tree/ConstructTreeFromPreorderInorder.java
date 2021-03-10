class Solution
{
    //index for preorder 
    static int preorderIndex= 0;
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        //reset it to 0 
        preorderIndex = 0;
        
        if(n == 0){
            return null;
        }
        
        //function call
        return buildBinaryTreeFromPreorderInorder(inorder, preorder, 0, n - 1);
    }
    
    public static Node buildBinaryTreeFromPreorderInorder(int[] inorder, int[] preorder, int start, int end){
        
        //base case 
        if(start > end){
            return null;
        }
        
        //create new node from preorder and increase index of preorder by 1
        Node newNode = new Node(preorder[preorderIndex]);
        preorderIndex++;
        
        //if start and end are same then return node
        if(start == end){
            return newNode;
        }
        
        //search for node in inorder
        int inorderIndex = search(inorder,newNode.data, start, end);
        
        //for left start to index - 1
        newNode.left = buildBinaryTreeFromPreorderInorder(inorder, preorder, start, inorderIndex - 1);
        
        //for right index + 1 to end
        newNode.right = buildBinaryTreeFromPreorderInorder(inorder, preorder, inorderIndex + 1, end);
        
        //return the node
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
