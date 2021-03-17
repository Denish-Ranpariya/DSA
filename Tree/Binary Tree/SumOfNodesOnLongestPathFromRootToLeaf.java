//sum of nodes of longest path from root to leaf 
//if more than one paths are possible then take max sum
class GfG
{
    static int maxSum = 0;
    static int maxNumberOfNodes = 0;
    public int sumOfLongRootToLeafPath(Node root)
    {
        //reset global statics
        maxSum = 0;
        maxNumberOfNodes = 0;
         
        //call recursive function
        solve(root, 0, 0);
        
        return maxSum;
        
    }
    
    public static void solve(Node node, int numberOfNodes, int sum){

        //base case     
        if(node == null){
            return;
        }
        
        //if leaf node
        if(node.left == null && node.right == null){
            //incease number of nodes by 1
            numberOfNodes++;
            //add it to sum
            sum += node.data;

            //if number of node is greater than maxnumber of nodes than make it max number of nodess
            if(numberOfNodes >= maxNumberOfNodes){
                maxNumberOfNodes = numberOfNodes;

                //for numberOfNodes = maxNumberOfNodes case
                maxSum = Math.max(maxSum, sum);
            }   
            return;
        }
        
        //incrase number of nodes by 1
        numberOfNodes++;

        //add node's data to sum
        sum += node.data;
        
        //recursive call for left sub tree
        solve(node.left, numberOfNodes, sum);

        //recursive call for right sub tree 
        solve(node.right, numberOfNodes, sum);
    }
}