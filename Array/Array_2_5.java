//Find duplicates in an array
import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

class Array_2_5{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array:");
		int n = sc.nextInt();
		int arr[] = new int[n];

		for(int i = 0; i < n; i++){
			System.out.println("Enter the number at " + (i+1) + ":");
			arr[i] = sc.nextInt();
		}


		//here we have used haspmap which has key value pairs 
		//as key we stored element
		//as value we stored the frequency of element
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();

		for(int i = 0; i < arr.length; i++){
			if(hm.containsKey(arr[i])){  //if already exists then increment the counter and save it to the value
				int count = hm.get(arr[i]);
				count++;
				hm.put(arr[i],count);
			}else{
				hm.put(arr[i],1);// if doesn't exists then put it in the hashmap with value/frequency as 1
			}
		}

		//traverse through hashmap and print the elements which have frequency greater than 1
		for (Map.Entry mapElement : hm.entrySet()) { 
            if((int)mapElement.getValue() > 1){
            	System.out.println(mapElement.getKey());
            }
        } 
		
	}
}