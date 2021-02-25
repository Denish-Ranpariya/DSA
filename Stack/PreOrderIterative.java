//status 1/2/3
//1 -> print to preorder and push left child
//2 -> print to inorder and push right child
//3 -> print to post order and pop because both child were pushed to stack
class Pair{
    Node node;
    int state;
    
    Pair(Node node, int state){
        this.node = node;
        this.state = state;
    }
}

class Tree
{
    static ArrayList<Integer> result = new ArrayList<Integer>();
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> preOrder(Node root)
    {
        result.clear();
        
        //stack type of pair
        Stack<Pair> s = new Stack<Pair>();
        
        //push root node with state 1
        s.push(new Pair(root,1));
        
        //while stack is not empty
        //check top of the stack and work according to its status
        while(!s.isEmpty()){
            Pair top = s.peek();
            
            //if state is 1 then print it to preorder and add left child if exist to the stack
            //increase the state to 2
            if(top.state == 1){
                result.add(top.node.data);
                top.state++;
                
                if(top.node.left != null){
                    Pair pair = new Pair(top.node.left, 1);
                    s.push(pair);
                }
            }else if(top.state == 2){
                //if state is 2 then add right child if exist to the stack
                //increase the state to 3
                top.state++;
                if(top.node.right != null){
                    Pair pair = new Pair(top.node.right, 1);
                    s.push(pair);
                }
            }else{
                //if state is 3 then pop it from the stack because both children were pushed to the stack before
            
                s.pop();
            }
        }
        return result;
    }
    
    
}


