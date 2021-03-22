//range method
//if leaf node has range (low,high) and low == high then it is a dead end
//as in problem is is given that ony natural number are present in BST so there will be another condition for dead end
//if will be low == -infinity and high == 1

class GFG
{
    static boolean flag;
    public static boolean isDeadEnd(Node root)
    {
        flag = false;
        solve(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        return flag;
    }
    
    public static void solve(Node node, int low, int high){

        //base case
        if(node == null){
            return;
        }
        
        //low and high at node then it is a dead
        //there will be another condition foe dead end because in problem it is given that BST will contain only natural numbers
        if(low == high || (low == Integer.MIN_VALUE && high == 1)) {
            flag = true;
        }
        
        //for left sub tree range will be low to node's data-1
        solve(node.left, low, node.data - 1);

        //for right su tree range will be node's data + 1 to high
        solve(node.right, node.data + 1, high);
    }
}