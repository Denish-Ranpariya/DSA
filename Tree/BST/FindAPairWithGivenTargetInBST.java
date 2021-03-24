//IMP
//return 1 if BST contains pair with given target as sum

//M-1
//inorder traverasl 
//store in list
//2 pointer
//TC - O(n)
//SC - O(n)

//M-2
//iterative inorder traversal and iterative reverse inorder traversal
//basically we are doing two pointers in BST itself
//TC - O(n) visiting all the nodes
//SC - O(h) using stack

class Solution
{
    
    public int isPairPresent(Node root, int target)
    {
        //if tree doesn't exists return 0
        if(root == null){
            return 0;
        }
        
        //stack1 for inorder
        //stack2 for reverse inorder    
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        

        Node current1 = root;
        Node current2 = root;
        
        //while both pointers are not null and both stacks are not empty
        while(current1 != null || !s1.isEmpty() || current2 != null || !s2.isEmpty()){
            
            //if one of the poiter is not null
            if(current1 != null || current2 != null){

                //if current1 is not null then push it to stack 1 and go to left
                if(current1 != null){
                    s1.push(current1);
                    current1 = current1.left;
                }
                
                //if current 2 is not null then push it to stacj and go to right(reverse inorder)
                if(current2 != null){
                    s2.push(current2);
                    current2 = current2.right;
                }    
            }else{
                //if both pointers are null 

                //its time to pop from stacks

                //if bboth stacks are not empty
                if(!s1.isEmpty() && !s2.isEmpty()){

                    //check top of both
                    Node top1 = s1.peek();
                    Node top2 = s2.peek();
                    
                    //if their total is equal to given target then return 1
                    if(top1.data + top2.data == target){
                        return 1;
                    }else if(top1.data + top2.data < target){
                        //if sum is less than target then pop from stack 1 and go to right
                        current1 = s1.pop();
                        current1 = current1.right;
                    }else{

                        //if sum is greater than target then pop from stack 2 and go to left
                        current2 = s2.pop();
                        current2 = current2.left;
                    }
                }else{
                    //if one of the stack is empty then break the loop
                    break;
                }
            }
        }
        
        return 0;
    }
}