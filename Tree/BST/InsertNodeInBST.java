class Solution{
    
    // The function returns the root of the BST (currently rooted at 'root') 
    // after inserting a new Node with value 'Key' into it. 
    Node insert(Node root, int Key)
    {
        // your code here
        
        Node current = root;
        
        //to track the previous node
        Node prev = null;
        

        while(current != null){
            //if we find Key in the bst then no need to insert it to bst
            //so directly return root 
            if(current.data == Key){
                return root;
            }else if(current.data < Key){
                //if key is greater than current node data then go to right
                prev = current;
                current = current.right;
            }else{
                //else go to left
                prev = current;
                current = current.left;
            }
        }
        
        //create new node with key as data
        Node newNode = new Node(Key);
        
        //decide wether to attach new node to left side or right side of prev node
        if(Key > prev.data){
            prev.right = newNode;
        }else{
            prev.left = newNode;
        }
        
        return root;
    }
}

//recursive
class Solution{
    Node insert(Node root, int key)
    {
        // your code here
        if(root == null){
            Node newNode = new Node(key);
            return newNode;
        }
        
        if(root.data == key){
            return root;
        }
        
        if(root.data > key){
            root.left = insert(root.left, key);
        }
        
        if(root.data < key){
            root.right = insert(root.right, key);
        }
        
        return root;
    }
}