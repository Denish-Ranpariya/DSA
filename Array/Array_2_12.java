
//program to find if there is any sub array with sum equal to zero
import java.util.*;

//There are 2 methods are possible

//method 1
//in this method we will find all the sub arrays possible in array and find the sum is equal to zero or not
//in this method the time complexity is O(n^2) and space complexity is O(1)

//method 2
//in this method we are going to use the prefix sum 
//in prefix sum if the one element is repeating then there is a sub array which has sum of zero (VVIMP)
//in prefix sum if the one element is zero then the sub array from starting (index 0) having sum of zero (VVIMP)
//we will use the hash set to check for above conditions

class Array_2_12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array:");
		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Enter the number at " + (i + 1) + ":");
			arr[i] = sc.nextInt();
		}

		// method 1

		// boolean flag = false;
		// for(int i = 0; i < n; i++){
		// int sum = 0;
		// for(int j = i; j < n; j++){
		// sum += arr[j];
		// if(sum == 0){
		// flag = true;
		// break;
		// }
		// }
		// if(flag){
		// break;
		// }
		// }

		// if(flag){
		// System.out.println("YES");
		// }else{
		// System.out.println("NO");
		// }

		// method 2

		int sum = arr[0];
		boolean flag = false;

		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(arr[0]);// insert first element of array

		for (int i = 1; i < n; i++) {
			sum += arr[i];
			if (sum == 0 || hs.contains(arr[i]) || arr[i] == 0) {
				flag = true;
				break;
			} else {
				hs.add(arr[i]);
			}
		}

		if (flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}
}