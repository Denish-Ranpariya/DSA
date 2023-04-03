//Find Largest sum contiguous Sub array.[Very Important]
//Kadane's algorithm

//in this program we are going to find contiguous sub array which sum is largest in given array

//Two methods

//method-1
//brute force
//find sum of every possible sub array and find the largest one

//method-2
//in this we can do it by O(n) time complexity and O(1) space complexity

//for every element we will check that which sum is larger
//i. it's own  //arr[i]
//ii.sum with previous local sum //arr[i] + localSum

//at every iteration we will check whether localSum is larger than globalSum or not

import java.util.*;

class Array_2_13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array:");
		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Enter the number at " + (i + 1) + ":");
			arr[i] = sc.nextInt();
		}

		int localSum = arr[0];
		int globalSum = arr[0];

		for (int i = 1; i < n; i++) {

			// or localSum = Math.max(arr[i], localSum + arr[i]);
			if (arr[i] <= arr[i] + localSum) { // join with previous subarray
				localSum += arr[i];
			} else { // start new subarray
				localSum = arr[i];
			}

			if (localSum > globalSum) {
				globalSum = localSum;
			}
		}

		System.out.println("Answer is:" + globalSum);

	}
}