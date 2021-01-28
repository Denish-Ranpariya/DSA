//tapping rain water problem
//very famous for interviews

//sol. is sa,e for all three methods
//find max from left side 
//find max from right side
//take min of those maximums
//subtract that min from ith element
//sum += min(maxFromLeft,maxFromRight) - a[i]

//M-1
//bruteforce
//TC O(n^2)
//SC O(1)

//M-2
//TC O(n)
//SC O(n)
//we will take 2 arrays 
//in one array we will store largest element form left till i at ith place
//in one array we will store largest element from right till i at ith place



import java.util.*;

class TappingWater{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of blocks:");
		int n = sc.nextInt();

		int a[] = new int[n];

		for(int i = 0; i < n; i++){
			System.out.println("Enter the element:");
			a[i] = sc.nextInt();
		}

		//method - 1

		int maxFromLeft;
		int maxFromRight;

		int sum = 0;

		// for(int i = 0; i < n; i++){
		// 	maxFromLeft = Integer.MIN_VALUE;
		// 	maxFromRight = Integer.MIN_VALUE;
		// 	for(int j = i; j >= 0; j--){
		// 		if(a[j] > maxFromLeft){
		// 			maxFromLeft = a[j];
		// 		}
		// 	}

		// 	for(int k = i; k < n; k++){
		// 		if(a[k] > maxFromRight){
		// 			maxFromRight = a[k];
		// 		}
		// 	}

		// 	sum += Math.min(maxFromLeft, maxFromRight) - a[i];
		// }

		//method-2

		maxFromLeft = Integer.MIN_VALUE;
		maxFromRight = Integer.MIN_VALUE;

		int left[] = new int[n];
		int right[] = new int[n];

		for(int i = 0; i < n; i++){
			if(a[i] > maxFromLeft){
				maxFromLeft = a[i];
			}
			left[i] = maxFromLeft;
		}

		for(int j = n - 1; j >= 0; j--){
			if(a[j] > maxFromRight){
				maxFromRight = a[j];
			}	
			right[j] = maxFromRight;
		}

		for(int i = 0; i < n; i++){
			sum += Math.min(left[i], right[i]) - a[i];
		}


		System.out.println("Water reserved: " + sum);

	}
}