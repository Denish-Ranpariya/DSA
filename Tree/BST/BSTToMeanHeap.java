//BST to  mean heap

//all the values in the left subtree of a node should be less than all the values in the right subtree of the node

//inorder of BST is sorted
//store the values in a list
//now do preorder traversal of BST and replace the values from inorder list
//this will convert BST to mean heap

//for max heap do post order traversal

import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class BSTToMeanHeap{

    //list to store inorder traversal
    static ArrayList<Integer> inorderTree;
    
    //keep track of index
    static int index;

    public static void main(String[] args) {
    
        inorderTree = new ArrayList<>();

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        //do inorder traversal
        inorder(root);

        //set index as 0
        index = 0;

        //do preorder traversal and replace values of nodes
        convertToMeanHeap(root);

        //again do preorder traversal to verify
        preorder(root);
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        inorderTree.add(root.data);
        inorder(root.right);
    }

    public static void convertToMeanHeap(Node root){
        if(root == null){
            return;
        }

        root.data = inorderTree.get(index);
        index++;

        convertToMeanHeap(root.left);

        convertToMeanHeap(root.right);
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }


}