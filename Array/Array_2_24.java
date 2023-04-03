//Find a triplet that sum to a given value

//method-1 bruteforce 
//3 loops and check all possible triplets
//time comp. O(n^3)
//space comp. O(1)

//method-2
//using hashset
//time comp. O(n^2)
//space comp. O(n)

//method-3
//first sorting then two pointers
//time comp. O(n^2)
//sapce comp.O(1)

//method
import java.util.*;

class Array_2_24 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array:");
		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Enter the number at " + (i + 1) + ":");
			arr[i] = sc.nextInt();
		}

		System.out.println("Enter the sum:");
		int sum = sc.nextInt();

		// method - 2

		// HashSet<Integer> hs = new HashSet<Integer>();

		// for(int i = 0; i < n - 2; i++){ // we have to skip last two elements
		// //select i as first element
		// int currentSum = sum - arr[i];
		// for(int j = i + 1; j < n; j++){
		// //select j as second element
		// //check wether the third element is in set or not
		// if(hs.contains(currentSum - arr[j])){
		// System.out.println("found");
		// return;
		// }else{
		// //add it to set
		// hs.add(arr[j]);
		// }
		// }
		// }

		// System.out.println("not found");

		// method - 3

		// first short the array
		Arrays.sort(arr);

		// now use two pointer method

		for (int i = 0; i < n - 2; i++) {
			// select i as first element
			int l = 0;
			int h = n - 1;

			while (l < h) {
				if (arr[i] + arr[l] + arr[h] == sum) {
					System.out.println("found");
					System.out.println(arr[i]);
					System.out.println(arr[l]);
					System.out.println(arr[h]);
					return;
				} else if (arr[l] + arr[h] < sum) {
					l++;
				} else {
					h--;
				}
			}
		}

	}
}