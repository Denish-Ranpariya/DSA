//Find the two repetitive elements in a given array.


// general problem is to find the duplicates element in given array

//here mainn observation is all the element is going to less than the lenght of given array MMMIMP

// we can do it by bruteforce O(n^2)

// we can do it by hash map space complexity O(n) and time complexity O(n)

// but we have to do it by time complexity of O(n) and space complexity O(1)



import java.util.*;

class Array_2_23{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array:");
		int n = sc.nextInt();
		int arr[] = new int[n];

		for(int i = 0; i < n; i++){
			System.out.println("Enter the number at " + (i+1) + ":");
			arr[i] = sc.nextInt();
		}
		

		//here all the elements are less than the lenght of array
		//we will iterate form 0 to n and calculate the arr[i] - 1 
		//then we will go to index arr[i] - 1 and make it negative
		//if the element at index arr[i] - 1 is already negative then we will print it because it is the duplicate element  

		for(int i = 0; i < n; i++){
			int index = Math.abs(arr[i]) - 1;
			if(arr[index] < 0){
				System.out.println(arr[i]);
			}else{ 
				arr[index] = -arr[index];
			}
		}

		
		
	}
}