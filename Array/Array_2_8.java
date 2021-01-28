//program to find the first repeating element in array
import java.util.*;

class Array_2_8{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array:");
		int n = sc.nextInt();
		int arr[] = new int[n];

		for(int i = 0; i < n; i++){
			System.out.println("Enter the number at " + (i+1) + ":");
			arr[i] = sc.nextInt();
		}

		// here we are using hash set 
		// its like the set in maths

		HashSet<Integer> hs = new HashSet<Integer>();

		int ans = -1; //variable to keep update of last repeated element from n-1 to 0 (first repeated element)
		for(int i = arr.length - 1; i >= 0; i--){
			if(hs.contains(arr[i])){  //if already exists then update the value of ans
				ans = arr[i];
			}else{
				hs.add(arr[i]);// if doesn't exists then add it to set
			}
		}

		System.out.println("first repeated element: " + ans); //print the last updated value of ans variable
		
	}
}