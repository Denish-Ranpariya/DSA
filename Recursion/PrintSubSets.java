// Print Subsets | Print PowerSets | Print all Subsequences

//input-output method

import java.util.*;
class PrintSubSets{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();

        //initialize outpur with ""
        String output = "";

        printAllSubsets(input, output);
    }

    public static void printAllSubsets(String input,String output){

        //when input will be "" then print output
        //leaf node in recursive tree
        //base case
        if(input.equals("")){
            System.out.println(output);
            return;
        }

        //copy output for both the branches
        String output1 = output;
        String output2 = output;

        //remove first character from input add add it to output 2
        //because we are not including that character in output 1 and including it in output 2

        output2 += input.charAt(0);
        input = input.substring(1);

        //call function for both branches
        printAllSubsets(input,output1);
        printAllSubsets(input,output2);
    }
}