//same as input-output method in recursion

class Solution {
    static ArrayList<String> result = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        result.clear();

        //input - root
        //output - empty string
        printPath(root,"");
        return result;
    }
    
    public static void printPath(TreeNode node,String output){

        //base case
        if(node == null){
            return;
        }
        
        //if node is leaf node
        if(node.left == null && node.right == null){

            //add leaf node to output
            output += Integer.toString(node.val);

            //add output to result
            result.add(output);
            return;
        }
        
        //copy output in output1 and output2
        String output1 = output;
        String output2 = output;
        
        //add current node data to both outputs
        output1 += Integer.toString(node.val) + "->";
        output2 += Integer.toString(node.val) + "->";
        
        //call recursive function for both outputs
        printPath(node.left, output1);
        printPath(node.right, output2);
    }
}
