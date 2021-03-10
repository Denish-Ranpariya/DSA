//same as create from prefix
//only difference is in post order start from last index
//first create right sub tree then create left sub tree

class GfG
{
    //index for post fix notation
    static int postfixIndex;
    public static Node constructTree(char postfix[])
    {
        //set it at last index
        postfixIndex = postfix.length - 1;
        
        //pass post fix notation to function
        Node root = createExpressionTreeFromPostfix(postfix);
        
        return root;
    }
    

    public static Node createExpressionTreeFromPostfix(char[] postfix){

        //base case
        //if post fix index is -1 which means that we traversed through all the array from end to start
        if(postfixIndex == -1){
            return null;
        }
        
        //create node and decrease postfix index by -1
        Node newNode = new Node(postfix[postfixIndex]);
        postfixIndex--;
        
        //if node's data is operator then creater right sub tree and left subtree then return node
        if(newNode.val == '+' || newNode.val == '-' || newNode.val == '*' || newNode.val == '/' || newNode.val == '^'){
            newNode.right = createExpressionTreeFromPostfix(postfix);
            newNode.left = createExpressionTreeFromPostfix(postfix);
            return newNode;
        }else{
            //if it is operand then return node because it is leaf node
            return newNode;
        }
    }
    
}