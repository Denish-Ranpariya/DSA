//postfix to infix conversion
//ab- to (a-b)

import java.util.Scanner;
import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter  a Postfix expression:");
        String str = sc.nextLine();

        //here we have to create a stack of type string because after concatination we have to push it agin to the stack
        Stack<String> s = new Stack<String>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            //if it is digit or letter then push it to the stack
            if(Character.isLetterOrDigit(ch)){
                s.push(Character.toString(ch));
            }else{
                //if it is operator
                //pop two times
                String v2 = s.pop();
                String v1 = s.pop();

                //imp
                //concate '(' + v1 + operator + v2 + ')'
                String tobePushed = "(" + v1 + Character.toString(ch) + v2 + ")";

                //push it back to the stack
                s.push(tobePushed);

            }
        }
        //after loop there will be one element will be left which is result
        System.out.println(s.pop());
    }    
}
