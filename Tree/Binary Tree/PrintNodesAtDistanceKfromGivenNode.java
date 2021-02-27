/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    //list to store path from given node to root
    static ArrayList<TreeNode> pathToRootNode = new ArrayList<TreeNode>();

    //list for result
    static ArrayList<Integer> result = new ArrayList<Integer>();
    
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        
        //reset global statics
        pathToRootNode.clear();
        result.clear();
        
        //find all the nodes from target node to root node
        pathToRoot(root, target);
        
        //traverse through pathToRootNode 
        //function printKthDown will print all the nodes at k level from given node 
        //but we don't need to print all of them so we will pass blocker node 
        //blocker node will be previous node in pathToRootNode list
        //level will be k - i
        for(int i = 0; i < pathToRootNode.size(); i++){
            TreeNode blocker = (i == 0) ? null : pathToRootNode.get(i - 1);
            printKthDown(pathToRootNode.get(i), K - i, blocker);
        }
        
        return result;
    }
    

    //function to find path from target to root node
    //path will be stored in list
    public static boolean pathToRoot(TreeNode root, TreeNode target){
        if(root == null){
            return false;
        }
        
        if(root.val == target.val){
            pathToRootNode.add(root);
            return true;
        }
        
        boolean left = pathToRoot(root.left, target);
        if(left){
            pathToRootNode.add(root);
            return true;
        }
        
        boolean right = pathToRoot(root.right, target);
        if(right){
            pathToRootNode.add(root);
            return true;
        }
        
        return false;
    }
    
    //print all nodes at kth level down from given node 
    public static void printKthDown(TreeNode node, int level, TreeNode blocker){

        //if node is null or blocker then break recursion
        if(node == null || level < 0 || node == blocker){
            return;
        }
        
        //if level is 0 then add it to result
        if(level == 0){
            result.add(node.val);
            return;
        }
        
        //call recursive function for left and right subtree with level - 1
        printKthDown(node.left, level - 1, blocker);
        printKthDown(node.right, level - 1, blocker);
    }
}