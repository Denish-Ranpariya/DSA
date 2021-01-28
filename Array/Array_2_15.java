//program to find Maximum Product Subarray.
// this program is same as kadane's algorithm 
// only difference is we have to take care of negative numbers as product of two negative number is positive
// we will take one extra var for minimum


//during loop if negative number appears then we have to SWAP min and max
//after every iteration we have to check wether globalMax or localMax is greater

import java.util.*;

class Array_2_15{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array:");
		int n = sc.nextInt();
		int arr[] = new int[n];

		for(int i = 0; i < n; i++){
			System.out.println("Enter the number at " + (i+1) + ":");
			arr[i] = sc.nextInt();
		}
		
		int globalMax = arr[0];
		int localMax = arr[0];
		int localMin = arr[0];

		for(int i = 1; i < n; i++){
			if(arr[i] < 0){ // negative then swap min and max
				int temp = localMax;
				localMax = localMin;
				localMin = temp;
			}

			localMax = Math.max(arr[i], localMax * arr[i]);
			localMin = Math.min(arr[i], localMin * arr[i]);

			globalMax = Math.max(localMax,globalMax);
		}

		System.out.println(globalMax);
	}
}