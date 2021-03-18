//morris preorder traversal
//without stack 
//without recursion
//TC = O(n)
//SC = O(1)

//same as morris inorder
//only difference is when right child of predecesor is null then print current node
//and not null direclty go to right child

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

public class MorrisPreorderTraversal{
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

        morrisPreorder(root);
    }

    public static void morrisPreorder(TreeNode root){

        //set root as current
        TreeNode current = root;

        //while current is not null
        while(current != null){

            //check left child 
            //if it is null then directly visit current node
            //and change current to right child
            if(current.left == null){
                System.out.print(current.data + " ");
                current = current.right;
            }else{
                //if left child is not null then find in order predecesor of current node
                TreeNode  predecesor = findPredecesor(current);

                //if predecesor doesn't have right child 
                //then visit current node 
                //make link to current node from right child
                if(predecesor.right == null){
                    predecesor.right = current;
                    System.out.print(current.data + " ");
                    current = current.left;
                }else{
                    //if predecesor right child is not null 
                    //which means that current is predecesor of it self
                    //that means we have already visited left sub tree
                    //so cut the link from right of predecesor 
                    //go to current.right
                    predecesor.right = null;
                    current = current.right;
                }
            }
        }
    }

    //method to find inorder predecesor
    //to find predecesor of a node goto left child of that node
    //then go right until it becomes null or we find node it self
    //that node will be inorder predecesor
    public static TreeNode findPredecesor(TreeNode node){
        TreeNode current = node.left;

        while(current.right != node && current.right != null){
            current = current.right;
        }

        return current;
    }
}