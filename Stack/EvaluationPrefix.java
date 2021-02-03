import java.util.Scanner;
import java.util.Stack;

//evaluation of prefix
//ex.: +9*26
//only digit
//no brackets
//same as postfix but reverce 
//either reverse the string or reverse the for loop
//also difference into popping the values of operands
public class EvaluationPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a expresion:");
        String str = sc.nextLine();

        Stack<Integer> s = new Stack<Integer>();

        for(int i = str.length() - 1; i >= 0; i--){
            char ch = str.charAt(i);

            //if it is digit then push it
            if(Character.isDigit(ch)){
                s.push(ch - '0'); //important
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                char operator = ch;
                //pop two integers
                int v1 = s.pop();
                int v2 = s.pop();

                int result = calculate(v1, v2, operator);
                
                //push result to stack 
                s.push(result);

            }
        }

        //after for loop there will only one element in stack which is result

        System.out.println(s.pop());
    }


    //this function will give result of operation
    public static int calculate(int v1, int v2, char operator){
        if(operator == '+'){
            return v1 + v2;
        }else if(operator == '-'){
            return v1 - v2;
        }else if(operator == '*'){
            return v1 * v2;
        }else{
            return v1 / v2;
        }
    }
}

