// Isomorphism is a very general concept that appears in several areas of mathematics. 
// The word derives from the Greek iso, meaning "equal," and morphosis, meaning "to form" or 
// "to shape." Informally, an isomorphism is a map that preserves sets and relations among elements.

//example of isomorphic is hands.
//123 and 123 are isomorphic
//123 and 321 are isomorphic
//123 and 132 are not isomorphic

//combine code of identical and mirror at kast step (in return statement)
class BinaryTree  
{ 
    // Return True if the given trees are isomotphic. Else return False.
    boolean isIsomorphic(Node root1, Node root2)  
    { 
        //if both are null 
         if(root1 == null && root2 == null){
             return true;
         }
         
         //if one of them is null
         if((root1 == null && root2 != null) || (root1 != null && root2 == null)){
             return false;
         }
         
         //if data is not same
         if(root1.data != root2.data){
             return false;
         }
         
         //check for identical root1.left, root2.left && root1.right, root2.right
         //check for mirror root1.left, root2.right && root1.right, root2.left
         //take or because any one of them true then it is isomorphic
         return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right)) 
             || (isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left));
    }
    
}    