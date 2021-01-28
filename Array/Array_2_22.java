//Minimum number of Jumps to reach end.
//follow tushar roy video form youtube
//we will follow DP for this program
//time complexity O(n^2)
//space complexity O(n)

import java.util.*;

class Array_2_22{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array:");
		int n = sc.nextInt();
		int arr[] = new int[n];

		int jump[] = new int[n]; //number of jumps

		for(int i = 0; i < n; i++){
			System.out.println("Enter the number at " + (i+1) + ":");
			arr[i] = sc.nextInt();
			jump[i] = Integer.MAX_VALUE;
		}

		jump[0] = 0;

		for(int i = 1; i < n;i++){
			for(int j = 0; j < i; j++){
				if(i-j <= arr[j]){ //can directly reach from j to i or not
					jump[i] = Math.min(jump[i], jump[j] + 1);
				}
			}
		}

		System.out.println("answer:" + jump[n-1]); //min. number of jumps at last index

		


		
		
	}
}