import java.util.Scanner;
import java.util.Stack;


//only one digit 
//no space
//only () brackets
class EvaluationInfix{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a expresion:");
        String str = sc.nextLine();

        //stack for operands
        Stack<Integer> operands = new Stack<Integer>();
        
        //stack for operators and brackets
        Stack<Character> operators = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {

            //if it is '('
            //just push it in the operator stack
            if(str.charAt(i) == '('){
                operators.push('(');
            }else if(Character.isDigit(str.charAt(i))){
                //if it is digit
                operands.push(str.charAt(i) - '0'); //convert char to int
            }else if(str.charAt(i) == ')'){
                //if it is closing bracket then pop until opening bracket in operator stack
                while(operators.peek() != '('){
                    char operator = operators.pop();

                    //very imp
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    int result = calculate(v1, v2, operator);

                    //push result in operand stack
                    operands.push(result);
                }

                //remove '('
                operators.pop();

            }else if(str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/'){
                //if it is operator then pop the operators with same or higher precedence 
                //3 conditions
                //i. operator stack should not be empty
                //ii. top shuld not '('
                //iii. top should be same precedence or higher
                while(operators.size() != 0 && operators.peek() != '(' && precedence(str.charAt(i)) <= precedence(operators.peek()) ){
                    char operator = operators.pop();

                    //very imp
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    int result = calculate(v1, v2, operator);

                    //push result in operand stack
                    operands.push(result);
                }

                //after popping all the operators having precedence higher or equal push itself to operator stack
                operators.push(str.charAt(i));
            }

        }

        //after for loop if is there operators present in stack then do same operation
        while(operators.size() != 0){

            char operator = operators.pop();

            //very imp
            int v2 = operands.pop();
            int v1 = operands.pop();
            int result = calculate(v1, v2, operator);

            //push result in operand stack
            operands.push(result);
        }

        //result will be the last element in oprand stack
        System.out.println("Answer:" + operands.pop());

    }

    //this function will give the precedence of operator
    public static int precedence(char operator){
        // + - have same precedence 
        if(operator == '+'){
            return 1;
        }else if(operator == '-'){
            
            return 1;
        }else if(operator == '*'){
            // * / have same precedence but higher
            return 2;
        }else{
            return 2;
        }
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