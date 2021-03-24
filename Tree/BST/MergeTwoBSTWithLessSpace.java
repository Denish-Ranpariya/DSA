//merge two BST with O(h1 + h2) space

//iteartive inorder traversal in both trees simultaneously
//when pop compare both node's data them add smaller one to list


class Solution{
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        //if both trees are null
        if(root1 == null && root2 == null){
            return result;
        }
        
        //stack for both BSTs
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        

        Node current1 = root1;
        Node current2 = root2;
        
        //when both pointers are null and both stacks are empty then terminate loop
        while(current1 != null || !s1.isEmpty() || current2 != null || !s2.isEmpty()){
            
            //if one of the pointer is not null
            if(current1 != null || current2 != null){

                //add it to stack and go to left if not null
                if(current1 != null){
                    s1.push(current1);
                    current1 = current1.left;
                }
                
                //add it to stack and go to left if not null
                if(current2 != null){
                    s2.push(current2);
                    current2 = current2.left;
                }    
            }else{

                //if both pointers are null
                //time to pop element from stack
                if(!s1.isEmpty() && !s2.isEmpty()){
                    //if both stacks are non empty

                    //check top of both stack
                    Node top1 = s1.peek();
                    Node top2 = s2.peek();
                    
                    //add the smaller one to list
                    if(top1.data < top2.data){
                        current1 = s1.pop();
                        result.add(current1.data);
                        current1 = current1.right;
                    }else{
                        current2 = s2.pop();
                        result.add(current2.data);
                        current2 = current2.right;
                    }
                }else{

                    //if at least one them is empty

                    //check which is not empty
                    //add it to list
                        
                    if(!s1.isEmpty()){
                        current1 = s1.pop();
                        result.add(current1.data);
                        current1 = current1.right;
                    }
                    
                    if(!s2.isEmpty()){
                        current2 = s2.pop();
                        result.add(current2.data);
                        current2 = current2.right;
                    }
                }
            }
        }
        return result;
    }
}