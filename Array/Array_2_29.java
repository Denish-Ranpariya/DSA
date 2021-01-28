//to check wether the set is subset of given set is or not


//method-1 
//bruteforce 
//O(n*m) time comp
//O(1) space comp

//method-2
//sorting + binary search
//sort the first array
//find every element form second array in first array using binary search
//time comp O(nlogn + nlogm)
//space comp O(1)

//method - 3
//sorting both array + two pointer method
//time comp O(nlogn + mlogm)
//space comp. O(1)
//handles duplicates

//method-4
//hashing
//either use hashset or hashmap(for frequency)
//time comp. O(n)
//space comp. O(n)
//hashmap handles suplicates

import java.util.*;

class Array_2_29{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the length of first set:");
		int n = sc.nextInt();

		int[] a1 = new int[n];
		System.out.println("Enter the first set");
		
		for(int i = 0; i < n; i++){
			System.out.println("Enter the element:");
			a1[i] = sc.nextInt();
		}

		System.out.println("Enter the length of second set:");
		int m = sc.nextInt();

		int[] a2 = new int[m];
		System.out.println("Enter the second set");
		
		for(int i = 0; i < m; i++){
			System.out.println("Enter the element:");
			a2[i] = sc.nextInt();
		}


		//method-1
		// int i = 0, j = 0;
		// for(i = 0; i < m; i++){ // a2
		// 	for(j = 0; j < n; j++){// a1
		// 		if(a2[i] == a1[j]){
		// 			break;
		// 		}
		// 	}

		// 	if(j == n){ //if inner loop is not broken at all
		// 		System.out.println("NO.");
		// 		return;
		// 	}
		// }

		

		// System.out.println("YES.");	

		//method-2

		//sort first array

		// Arrays.sort(a1);

		// //find the element form second array in first array using binary search
		// for(int i = 0; i < m; i++){//a2
		// 	if(!binarySearch(a1,a2[i])){
		// 		System.out.println("NO");
		// 		return;
		// 	}
		// }

		// System.out.println("YES");


		//method - 3
		//sorting both arrays
		Arrays.sort(a1);
		Arrays.sort(a2);

		//now use two pointer method
		int i = 0;
		int j = 0;
		while(i < n && j < m){
			if(a1[i] == a2[j]){
				i++;
				j++;
			}else if(a1[i] < a2[j]){
				i++;
			}else if(a1[i] > a2[j]){
				System.out.println("NO.");
				return;
			}
		}

		System.out.println("YES");

	}

	// public static boolean binarySearch(int[] a,int key){
	// 	int l = 0;
	// 	int h = a.length - 1;

	// 	while( l <= h ){
	// 		int mid = l + (h - l)/2;
	// 		if(a[mid] == key){
	// 			return true;
	// 		}else if(a[mid] < key){
	// 			l = mid + 1;
	// 		}else{
	// 			h = mid - 1;
	// 		}
	// 	}

	// 	return false;
	// }
}