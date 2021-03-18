//morris postorder traversal
//without stack 
//without recursion
//TC = O(n)
//SC = O(1)

//same as morris preorder
//only difference is change left to right and right to left
//and find inorder successor instead of inorder predecesor

import java.util.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
        left = right = null;
    }
}

public class MorrisPostorderTraversal{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(6);
        root.left.left.right = new TreeNode(2);
        root.left.left.right.left = new TreeNode(-1);
        root.left.right.right = new TreeNode(8);
        root.right.right = new TreeNode(40);

        morrisPostorder(root);
    }

    public static void morrisPostorder(TreeNode root){

        TreeNode current = root;

        while(current != null){

            if(current.right == null){
                System.out.print(current.data + " ");
                current = current.left;
            }else{
                TreeNode  successor = findSuccessor(current);

                if(successor.left == null){
                    successor.left = current;
                    System.out.print(current.data + " ");
                    current = current.right;
                }else{
                    successor.left = null;
                    current = current.left;
                }
            }
        }
    }

    public static TreeNode findSuccessor(TreeNode node){
        TreeNode current = node.right;

        while(current.left != node && current.left != null){
            current = current.left;
        }

        return current;
    }
}