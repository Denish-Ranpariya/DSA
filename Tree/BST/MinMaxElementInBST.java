//min and max node in bst

//min element is left most node in bst
class Tree
{
    int minValue(Node node)
    {
        Node current = node;
        while(current.left != null){
            current = current.left;
        }
        
        return current.data;
    }
}

//max element is right most element in bst
class Tree
{
    int maxValue(Node node)
    {
        Node current = node;
        while(current.right != null){
            current = current.right;
        }
        
        return current.data;
    }
}