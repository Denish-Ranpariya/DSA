//same as Print Subsets | Print PowerSets | Print all Subsequences
//have to save all the element is a hashset so that they will be unique

//input-output method

//sub-string - continuous
//sub-sequence - not continuous but follow sequence
//sub-set - not continuous and doesn't follow sequence

//if asked to print in lexicographic order(dictionary order) then store in list and sort 
import java.util.*;
class PrintUniqueSubsets{

    static HashSet<String> hs = new HashSet<String>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();

        //initialize outpur with ""
        String output = "";

        printAllSubsets(input, output);

        for(String s : hs){
            System.out.println(s);
        }
    }

    public static void printAllSubsets(String input,String output){

        //when input will be "" then add it to hashmap
        //leaf node in recursive tree
        //base case
        if(input.equals("")){
            if(!hs.contains(output)){
                hs.add(output);
            }
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