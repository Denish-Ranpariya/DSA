//inorder traversal of bst gives sorted data
//if current node's data is smaller or equal to previous node's data then it is not a BST

//M-1
public class Solution
{
    static boolean flag;
    static int previous;
    boolean isBST(Node root)
    {
        flag = true;
        previous = Integer.MIN_VALUE;
        inorder(root);
        
        return flag;
    }
    
    //do inorder traversal
    public static void inorder(Node node){
        if(node == null){
            return;
        }
        
        inorder(node.left);
        
        //if node data is less or equal to previous node's data then it is not a BST
        if(node.data <= previous){
            flag = false;
        }
        
        previous = node.data; 
        
        inorder(node.right);
    }
}


//M-2
//range method

public class Solution
{
    static boolean flag;
    boolean isBST(Node root)
    {
        flag = true;
        solve(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        return flag;
    }
    
    public static void solve(Node node, int low, int high){
        if(node == null){
            return;
        }
        
        //if node's data is not in given range then it is not a BST
        if(node.data <= low || node.data >= high){
            flag = false;
        }
        
        //for left sub tree range will be (low - node's data)
        solve(node.left, low, node.data);

        //for right sub tree range will be (node's data - high)
        solve(node.right, node.data, high);
    }
}