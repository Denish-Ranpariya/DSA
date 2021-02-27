// Java Program to Check if a string is a valid shuffle of two distinct strings

//shuffled string should use all the characters from both the strings 
//the characters should be in the same order as input
import java.util.*;
class ValidShuffleOfTwoString{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string 1:");
        String s1 = sc.nextLine();

        System.out.println("Enter the string 2:");
        String s2 = sc.nextLine();

        System.out.println("Enter the shuffled string:");
        String result = sc.nextLine();

        //if length of shuffled string is not equal to addition of lenghts of s1 and s2 then its invalid shuffle
        if(s1.length() + s2.length()  != result.length()){
            System.out.println("not a valid shuffle.");
            return;
        }
        int p1 = 0; //pointer for s1
        int p2 = 0;//pointer for s2
        int p3 = 0;//pointer for shuffled string

        //while p3 is less than length of result string 
        while(p3 < result.length()){

            //we will check wether character at p3 index in result string would match with
            //character at p1 index in s1 string 
            //or character at p2 index  in s2 string

            //increment p3 pointer for both cases
            //increment p1 when s1 got a match and p2 when s2 got a match
            
            if(p1 < s1.length() && s1.charAt(p1) == result.charAt(p3)){
                p1++;
                p3++;
            }else if(p2 < s2.length() && s2.charAt(p2) == result.charAt(p3)){
                p2++;
                p3++;
            }else{
                //if it doesn't get a match with both of then break;
                break;
            }
        }

        //after loop if p1,p2 and p3 are at size + 1 of s1,s2 and result respectively then its valid shuffle
        if(p1 == s1.length() && p2 == s2.length() && p3 == result.length()){
            System.out.println("Valid shuffle.");
        }else{
            //otherwise invalid shuffle
            System.out.println("Invalid shuffle");
        }
        
    }
}
