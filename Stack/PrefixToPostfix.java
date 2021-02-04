//prefix to postfix conversion
//no space
//only one digit or letter

//-ab to ab-
import java.util.Scanner;
import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter  a Postfix expression:");
        String str = sc.nextLine();

        //here we have to create a stack of type string because after concatination we have to push it agin to the stack
        Stack<String> s = new Stack<String>();

        //traverce from last
        for(int i = str.length() - 1; i >= 0; i--){
            char ch = str.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                //if its letter or digit then push it to the stack
                s.push(Character.toString(ch));
            }else{
                //if it is operator then pop two time from the stack
                String v1 = s.pop();
                String v2 = s.pop();

                //imp
                //now push v1 + v2 + operator  
                String tobePushed = v1 + v2 + Character.toString(ch);
                s.push(tobePushed);
            }
        }

        //after the loop only one element will remain in stack which will be final result

        System.out.println(s.pop());

        

    }
}
