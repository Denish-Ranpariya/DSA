//method - 1
//hashing
//there are 256 numbers of characters 
//so we will create an array of size 256
//maintain count of each character at particular position in array
//TC O(n)
//SC O(256)

//method - 2
//using hashset or hashmap

import java.util.*;

class PrintAllDuplicates{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String s = sc.nextLine();

        //hashmap 
        //key - character
        //value - frequency
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(hm.containsKey(ch)){
                //if it is already present in hashmap then increase its frequency by 1
                hm.put(ch,hm.get(ch) + 1);
            }else{
                //if it is not present in hashmap then push its frequency as 1
                hm.put(ch,1);
            }
        }

        //traversing through hashmap
        for(Map.Entry<Character,Integer> mapEntry : hm.entrySet()){
            char ch = (char)mapEntry.getKey();
            int frequency = (int)mapEntry.getValue();

            //if frequency is grater than 1 then print it
            if(frequency > 1){
                System.out.println(ch);
            }
        }
    }
}