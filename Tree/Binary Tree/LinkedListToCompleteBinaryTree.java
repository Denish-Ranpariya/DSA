// Given a Linked List Representation of Complete Binary Tree. 
// The task is to construct the Binary tree.
// Note : The complete binary tree is represented as a linked list in a way where 
// if root node is stored at position i, its left, and right children are stored 
// at position 2*i+1, 2*i+2 respectively.

class GfG {
    public static Tree convert(Node head, Tree root) {
        
        //pointer to linkedlist
        Node current = head;
        
        //make root node with data as head pointer of linked list
        root = new Tree(current.data);
        
        //increment pointer
        current = current.next;
        
        //queue
        Queue<Tree> q = new LinkedList<Tree>();
        
        //add root node of tree
        q.add(root);
        
        //while current is not null
        //remove a node from it
        //it will be current tree node
        //traverse two steps in linked list
        //they will be left and righ child of current tree node
        //also add them to queue
        while(current != null){
            
            //reomve a node from queue
            //current node
            Tree currentTreeNode = q.remove();
            
            //to prevent from null pointer exception
            if(current != null){

                //current tree node left child will be with data same as pointer in linked list
                currentTreeNode.left = new Tree(current.data);
                //increment current pointer
                current = current.next;
                //add it to queue
                q.add(currentTreeNode.left); 
            }

            //to prevent from null pointer exception
            if(current != null){

                //current tree node right child will be with data same as pointer in linked list
                currentTreeNode.right = new Tree(current.data);
                //increment current pointer
                current = current.next;
                //add it to queue
                q.add(currentTreeNode.right);
            }
            
            
        }
        
        return root;
    }
}  