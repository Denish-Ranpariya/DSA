//Largest BST in binary tree
//most unique type of problem

//follow tushar roy video on youtube

// Given a binary tree, find size of largest binary search subtree in this
// binary tree.
//  
//  Traverse tree in post order fashion. Left and right nodes return 4 piece
//  of information to root which isBST, size of max BST, min and max in those
//  subtree. 
//  If both left and right subtree are BST and this node data is greater than max
//  of left and less than min of right then it returns to above level left size +
//  right size + 1 and new min will be min of left side and new max will be max of
//  right side.


// Object of this class holds information which child passes back
// to parent node.
class MinMax{
    boolean isBST;
    int size;
    int min;
    int max;
    
    MinMax(){
        isBST = true;
        size = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }
}

class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        
        
        MinMax minMax = solve(root);
        
        return minMax.size;
        
    }
    
    public static MinMax solve(Node root){


        //if root is null return min as Integer.MAX and max as Integer.MIN 
        if(root == null){
            return new MinMax();
        }
        
        //postorder traversal of tree. First visit left and right then
        //use information of left and right to calculate largest BST.
        MinMax left = solve(root.left);
        MinMax right = solve(root.right);
        
        MinMax minMax = new MinMax();

        //if either of left or right subtree says its not BST or the data
        //of this node is not greater/equal than max of left and less than min of right
        //then subtree with this node as root will not be BST. 
        //Return false and max size of left and right subtree to parent
        if(left.isBST == false || right.isBST == false || left.max >= root.data || right.min <= root.data){
            minMax.isBST = false;
            minMax.size = Math.max(left.size, right.size);
            
            return minMax;
        }
        
        //if we reach this point means subtree with this node as root is BST.
        //Set isBST as true. Then set size as size of left + size of right + 1.
        //Set min and max to be returned to parent.
        minMax.isBST  = true;
        minMax.size = left.size + right.size + 1;


        //if root.left is null then set root.data as min else
        //take min of left side as min
        minMax.min = root.left != null ?  left.min : root.data;


        //if root.right is null then set root.data as max else
        //take max of right side as max.
        minMax.max = root.right != null ? right.max : root.data;
        
        return minMax;
        
    }
    
}


