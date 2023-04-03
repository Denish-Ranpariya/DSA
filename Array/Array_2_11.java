// program to rearrange the array in alternating positive and negative items with O(1) extra space.

import java.util.*;

class Array_2_11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array:");
		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Enter the number at " + (i + 1) + ":");
			arr[i] = sc.nextInt();
		}

		// first we will arrange all negative numbers at left side of the array
		// if we arrange the negative numbers at left side then positive numbers will
		// automatically arrange at right side

		int start = 0; // for negative numbers

		for (int i = 0; i < n; i++) {
			if (arr[i] < 0) {
				if (i == start) {
					start++; // no need to swap
				} else {
					// swap arr[start] and arr[i]
					int temp = arr[i];
					arr[i] = arr[start];
					arr[start] = temp;
					start++;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
		// System.out.println(start);

		// at start variable positive number starts

		int startCopy = start;
		for (int i = 1; i <= startCopy; i += 2) {
			// swap arr[start] and arr[i]
			int temp = arr[start];
			arr[start] = arr[i];
			arr[i] = temp;
			start++;
		}

		System.out.println(Arrays.toString(arr));

	}
}