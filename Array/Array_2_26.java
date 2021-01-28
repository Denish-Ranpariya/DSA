//Find the row with maximum number of 1’s

//method-1 bruteforce
//just iterate through every row and count the number of 1
//find the row with max 1's
//time comp. O(n*m)

//method-2
//here given that array is sorted VVIMP
//in sorted array we can use binary search to find the first occurance of 1 in each row
//after finding the first occurance of first 1 in a row we can calculate the number of 1's in a row because every row is sorted
//time comp. O(n*logm)

//method-3 
//because the array is sorted we can traverce through column instead of row
//we will search for first occurance of 1 
//that't it the row number of first occurance is the row with max number of 1's
//time comp. is O(n+m)
//but in worst case time comp. is still O(n*m)

import java.util.*;

class Array_2_26{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of rows:");
		int n = sc.nextInt();

		System.out.println("Enter the number of columns:");
		int m = sc.nextInt();

		int[][] a = new int[n][m];

		System.out.println(":::Enter the matrix:::");

		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				System.out.println("Enter the element:");
				a[i][j] = sc.nextInt();
			}
		}

		//method - 2
		int globalMax = Integer.MIN_VALUE;
		int indexOfMax = -1;
		for(int i = 0; i < n; i++){
			int index = firstOccurance(a[i],m); //index of first 1
			//System.out.println("index:" + index);
			int count = m - index;
			if(count > globalMax && index != -1){
				globalMax = count;
				indexOfMax = i;
			}

		}

		System.out.println("Index of row with max 1's:" + indexOfMax);
		

		//method - 3
		// we will go column wise
		// for(int i = 0; i < m; i++){
		// 	for(int j = 0; j < n; j++){
		// 		if(a[j][i] == 1){
		// 			System.out.println("Index of row with max 1's:" + j);
		// 			return;
		// 		}
		// 	}
		// }


	}

	public static int firstOccurance(int[] arr,int m){

		if(arr[0] == 1){
			return 0;
		}
		int l = 1;
		int h = m-1;
		int index = -1;

		while(l < h){
			int mid = (l + h)/2;
			if(arr[mid] == 1 && (mid == 0 || arr[mid-1] == 0 )){
				index = mid;
				break;
			}else if(arr[mid] == 0){
				l = mid + 1;
			}else{
				h = mid - 1;
			}
		}

		return index;
	}
}