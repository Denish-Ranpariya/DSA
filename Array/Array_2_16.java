// program to find the length of longest sub sequence


// there are to methods possible

// method-1
// in this method we will short the array 
// then remove the duplicates by using one more loop
// then simply check whether the element at i-1 is arr[i]-1 or not
// we will keep track of max length during this
// this will take O(nlogn) time complexity 

//method-2
// in this method we will try to do it in O(n) time complexity with O(n) space complexity
// first we will create a hash set and add all the elements into it
// then we will check the wether the element is the starting of sub sequence or not
// if it is then we will find the next elements by just incrementing the value by 1
// we will keep track of max length during this process
import java.util.*;

class Array_2_16{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array:");
		int n = sc.nextInt();
		int arr[] = new int[n];

		int localCount = 0;
		int finalCount = 0;

		HashSet<Integer> hs = new HashSet<Integer>();

		for(int i = 0; i < n; i++){
			System.out.println("Enter the number at " + (i+1) + ":");
			arr[i] = sc.nextInt();
			hs.add(arr[i]); // add all the elements to hashset
		}

		for(int i = 0; i < n; i++){
			if(!hs.contains(arr[i] - 1)){ // check if the element is starting of sub sequence or not
				int temp = arr[i];
				while(hs.contains(temp)){
					temp++;
					localCount++;
				}
			}
		}	
	}
}