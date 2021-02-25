//status 1/2/3
//1 -> print to preorder and push left child
//2 -> print to inorder and push right child
//3 -> print to post order and pop because both child were pushed to stack
public class Pair{
    TreeNode node;
    int state;
    Pair(TreeNode node, int state){
        this.node = node;
        this.state = state;
    }
}


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(root == null){
            return result;
        }
        
        //stack type of pair
        Stack<Pair> s = new Stack<Pair>();
        
        s.push(new Pair(root, 1));
        
        //while stack is not empty
        //check top of the stack and work according to its status
        while(!s.isEmpty()){
            Pair top = s.peek();

            //if state is 1 then add left child if exist to the stack
            //increase the state to 2
            if(top.state == 1){
                top.state++;
                if(top.node.left != null){
                    s.push(new Pair(top.node.left,1));
                }
            }else if(top.state == 2){
                //if state is 2  add right child if exist to the stack
                //increase the state to 3
                
                top.state++;
                if(top.node.right != null){
                    s.push(new Pair(top.node.right,1));
                }
            }else{
                //if state is 3 then print it to post order and pop it from the stack because both children were pushed to the stack before
                result.add(top.node.val);
                s.pop();
            }
        }
        return result;
    }
}

