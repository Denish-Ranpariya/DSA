import java.util.Scanner;


// this is the program to find the missing element in sorted array of 0 to n-1
// there are 3 methods are possible

// first method: using hash map
// in this method we flag the particular element as true if it is present in given array
// at last we iterate the loop form 1 to n in hash map if the flag is false then the particular element is missing form the array
// but the time complexity and space complexity are both O(N)

// second methos: using the sum of first n natural numbers n*(n+1)/2
// we will find the sum of first n natural numbers where n = largest(last) element in array
// then we will find the sum of given array using a loop
// then we will calculate the difference between these two sums and the output will be the missing element
// the time complexity is O(n) and space complexity is O(1) but there is a problem of integer overflow in the case of large array

// third method: XOR operation
// we know that the xor of two same number is zero.
// we will find the xor of all elements in array from 0 to n-1
// we will find the xor of first n numbers 
// we will find the xor of above two results
// the output will be the missing integer
class Array_2_3{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int n = sc.nextInt();

		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			System.out.println("Enter the element:");
			arr[i] = sc.nextInt();
		}

		int lastElement = arr[n-1];

		int xorResult1 = 1;
		for(int i = 2; i <= lastElement;i++){
			xorResult1 ^= i;
		}

		int xorResult2 = arr[0];

		for(int i = 1;i < arr.length; i++){
			xorResult2 ^=arr[i];
		}

		System.out.println("missing element is:"+ (xorResult1^xorResult2));
	}
}