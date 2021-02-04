//postfix to infix conversion
//-ab to (a-b)

import java.util.Scanner;
import java.util.Stack;
public class PrefixToInfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter  a Postfix expression:");
        String str = sc.nextLine();

        //here we have to create a stack of type string because after concatination we have to push it agin to the stack
        Stack<String> s = new Stack<String>();

        //traverse from last
        for(int i = str.length() - 1; i >= 0; i--){
            char ch = str.charAt(i);

            //if it is letter or digit then push it to the stack
            if(Character.isLetterOrDigit(ch)){
                s.push(Character.toString(ch));
            }else{
                //if it is operator then pop two times

                String v1 = s.pop();
                String v2 = s.pop();

                //concate "(" + v1 + operator + v2 + ")"
                String tobePushed = "(" + v1 + Character.toString(ch) + v2 + ")";

                //push it back to stack
                s.push(tobePushed);

            }
        }

        //after loop there will be only one element 
        System.out.println(s.pop());

    }
}
