// Input : "4(2(3)(1))(6(5))"
// Output : 4 2 3 1 6 5  (prorder)


import java.util.*;

class TreeNode{
    char data;
    TreeNode left;
    TreeNode right;
    TreeNode(char data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class ConstructBInaryTreeWithStringWithBracketRepresentation{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string of bracket representation:");
        String str = sc.nextLine();

        TreeNode root = constructBinaryTreeFromString(str);

        //call recursive function
        preorderTraversal(root);
    }

    public static TreeNode constructBinaryTreeFromString(String str){

        //base case
        //if string is empty then return null
        if(str.length() == 0){
            return null;
        }

        //create a new node with first character of string
        TreeNode newNode = new TreeNode(str.charAt(0));

        //now we will find which sub string will be usful for left sub tree nd right subtree
        //first we will extract sting for left sub tree
        //ex. 4(2(3)(1))(6(5)) -> 2(3)(1)

        int count = 1;

        int i = -1;
          
        
        for(i = 2; i < str.length(); i++){
            if(count == 0){
                break;
            }else if(str.charAt(i) == '('){
                count++;
            }else if(str.charAt(i) == ')'){
                count--;
            }
        }

        int start = -1, end = -1;

        //if left part is not present
        if(i == 2){
            //because substing function will return empty string whn indexes are same
            start = 0;
            end = 0;
        }else{
            start = 2;
            end = i - 1;
        }

        //string for left subtree
        String str1 = str.substring(start, end);

        start = -1;
        end = -1;

        //if left part is not present
        if(i == 2 || i == str.length()){
            start = 0;
            end = 0;
        }else{
            start = i + 1;
            end = str.length() - 1;
        }

        //string for left subtree
        String str2 = str.substring(start, end);

        //recursive call for left subtree
        newNode.left = constructBinaryTreeFromString(str1);

        //recursive call for right subtree
        newNode.right = constructBinaryTreeFromString(str2);

        //return node
        return newNode;
    }

    //function to print preorder
    public static void preorderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}