// geeksforgeeks
// forgeeksgeeks
// Output: 
// true

public static boolean areRotations(String s1, String s2 )
{
    // Your code here
    // we have to check wether string s2 is a rotation of string s1
    
    if(s1.length() != s2.length()){
        return false;
    }
    
    //concatinate s1 with s1
    String temp = s1 + s1;
    
    //now check if s2 is substring of temp or not
    
    if(temp.indexOf(s2) != -1){
        return true;
    }
    
    return false;
    
    
}