//reverse inorder traversal 
//change node's value to sum
//add node's data to sum

class Solution
{   
    
    static int sum = 0;
    public static void transformTree (Node root)
    {
        sum = 0;
        reverseInorder(root);
    }
    
    public static void reverseInorder(Node root){
        if(root == null){
            return;
        }
        
        reverseInorder(root.right);
        
        int temp = root.data;
        root.data = sum;
        sum += temp;
    
        reverseInorder(root.left);
    }
}