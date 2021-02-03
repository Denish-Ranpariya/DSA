import java.util.Scanner;
import java.util.Stack;

//evaluation of postfix
//ex.: 231*+9-
//only digit
//no brackets
//postfix is understandable by computer

public class EvaluationPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a expresion:");
        String str = sc.nextLine();

        Stack<Integer> s = new Stack<Integer>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            //if it is digit then push it
            if(Character.isDigit(ch)){
                s.push(ch - '0'); //important
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                char operator = ch;
                //pop two integers
                int v2 = s.pop();
                int v1 = s.pop();

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
