//minimum number of swaps required to convert binary tree into bst
//binary tree is given
//do inorder traversal of binary tree
//it will be an unsorted array
//but if we do inorder traversal of bst then it will be sorted array
//so our task is to covert unsorted array to sorted array with minimum number of swaps
//now it is the problem of array
//already done in array directory

import java.util.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class Pair{
    int data;
    int index;
    Pair(int data, int index){
        this.data = data;
        this.index = index;
    }
}

class MinimumNumberOfSwapsRequiredToConvertBinaryTreeIntoBst{

    static ArrayList<Integer> al = new ArrayList<Integer>();
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(11);

        inorder(root);
        
        int count = countMinimumSwaps(al);

        System.out.println("Minimum counts: " + count);

    }

    public static void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        al.add(root.data);
        inorder(root.right);
    }

    public static int countMinimumSwaps(ArrayList<Integer> al){
        ArrayList<Pair> pairs = new ArrayList<Pair>();
        
        for(int i = 0; i < al.size();i++){
            pairs.add(new Pair(al.get(i), i));
        }

        Collections.sort(pairs, (a,b) -> a.data - b.data);

        int count = 0;

        for(int i = 0; i < al.size(); i++){
            if( i != pairs.get(i).index){
                Collections.swap(pairs, i, pairs.get(i).index);
                count++;
                i--;
            }
        }
        return count;
    }

    
}