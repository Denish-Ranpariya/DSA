//count the nodes in given range l to h

class Tree{
    //count
    static int count = 0;
    int getCount(Node root,int l, int h){
        //reset global statics
        count = 0;
        countNodes(root, l , h);
        return count;
    }
    
    public static void countNodes(Node root, int l, int h){

        //base case
        if(root == null){
            return;
        }
        
        //if node's data is in the range than increment count by 1
        if(root.data >= l && root.data <= h){
            count++;
        }
        
        //check if possible to go to left and right sub tree

        //if node's data is greater than l 
        //that means that there are elements which are in range are in left sub tree
        //so go to left sub tree
        if(l < root.data){
            countNodes(root.left, l , h);
        }
        
        //if node's data is smaller than h 
        //that means that there are elements which are in range are in right sub tree
        //so go to right sub tree
        if(h > root.data){
            countNodes(root.right, l, h);
        }
    }
    
}