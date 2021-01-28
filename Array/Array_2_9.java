//program to find the first non - repeating element in array
import java.util.*;


// this program can be solved by 2 methods
// method - 1:
// in this method the time complexity is O(n^2)


class Array_2_9{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array:");
		int n = sc.nextInt();
		int arr[] = new int[n];

		for(int i = 0; i < n; i++){
			System.out.println("Enter the number at " + (i+1) + ":");
			arr[i] = sc.nextInt();
		}

		//method 1
		// int firstNonRepeatingElement = -1;
		// for(int i = 0; i < n; i++){
		// 	int j;
		// 	for(j = 0; j < n; j++){
		// 		if(arr[i] == arr[j] && i != j){
		// 			break; //if the same element is found then break the loop 
		// 		}

		// 	}
		// 	if(j == n){
		// 		firstNonRepeatingElement = arr[i]; //if the j reach to the last element and doesn't find the same element then the arr[i] will be the first non repeating element
		// 	}
		// }

		// System.out.println("First non repeating element is:" + firstNonRepeatingElement);

		//method - 2

		// here we are going to use the LinkedHashMap because we want to count the frequency and also worried about the sequence
		// HashMap provides frequency but doesn't provide the sequence so we are using the LinkedHashMap
		// I have tried using HashSet on paper but it's not possible using it so we are going for LinkedHashMap
		// this method have time compexity of around O(n) but space complexity is around O(n) unlike method-1
		LinkedHashMap<Integer,Integer> lhm = new LinkedHashMap<Integer,Integer>();

		for(int i = 0; i < n; i++){
			if(lhm.containsKey(arr[i])){ //if already exists in the hashmap then increase the frequency
				int count = lhm.get(arr[i]);
				count++;
				lhm.put(arr[i],count);
			}else{
				lhm.put(arr[i],1); //if doesn't exists then put it as frequency as 1
			}
		} 

		for(int i = 0; i < n; i++){
			if(lhm.get(arr[i]) == 1){
				System.out.println("First non repeating element is:" + arr[i]);
				break;
			}
		}
		
	}
}//