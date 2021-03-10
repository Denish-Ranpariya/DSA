//program to create expression tree from prefix notation
//where leaf nodes are operands
//if you create expression tree
//then its preorder traversal will be prefix notation
//its inorder traversal will be inorder notation
//its postorder traversal will be postfix notation

import java.util.*;

//treenode
class TreeNode{
    char data;
    TreeNode left;
    TreeNode right;

    TreeNode(char data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class CreateExpressionTreeFromPrefixNotation{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string for prefix notation:");

        String prefix = sc.nextLine();

        //passing prefix string to construct expression tree
        TreeNode root = createExpressionTreeFromPrefix(prefix);

        //function to print preorder
        printPreorder(root);
    }

    //static to track indes of prefix notation string
    static int prefixIndex = 0;
    public static TreeNode createExpressionTreeFromPrefix(String prefix){

        //base case
        //if prefix index is equal to length of prefix string length then return null
        if(prefixIndex == prefix.length()){
            return null;
        }

        //create new node with current index from prefix notation
        TreeNode newNode = new TreeNode(prefix.charAt(prefixIndex));
        //increase prefix index by 1
        prefixIndex++;

        //if character is operator then call for left and right sub tree 
        //then return node 
        if(newNode.data == '*' || newNode.data == '+' || newNode.data == '-' || newNode.data == '/' || newNode.data == '^'){
            newNode.left = createExpressionTreeFromPrefix(prefix);
            newNode.right = createExpressionTreeFromPrefix(prefix);
            return newNode;
        }else{
            //if character is operand then it is leaf node so return node 
            return newNode;
        }
    }

    //function to print pre order
    public static void printPreorder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.data);
        printPreorder(root.left);
        printPreorder(root.right);
    }
}