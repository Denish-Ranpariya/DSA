// find next permutation problem

//method-1 
//bruteforce
//in this we have to find evry possible permutation


//method-2
// in this method the greatest possible permutation in in reverce order i.e. 321 is largest possible solution
//from three numbers 1 2 3 which is in reverce order

//if the given number is already in descending order then return the reverce of it i.e. ascending order
//else start from last
//go until the a[i] < a[i-1]
//give the index = i
//run loop from index to n to find greater neartest to  a[index-1]
//swap greater nearest  with a[index - 1]
//reverce the array from index to n
//TC O(n)
//SC O(1)

import java.util.*;

class NextPermutation{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of digits:");
		int n = sc.nextInt();

		int[] digit = new int[n];

		for(int i = 0; i < n; i++){
			System.out.println("Enter the digit");
			digit[i] = sc.nextInt();
		}

		if( n == 0 || n == 1 ){
			for(int i = 0; i < n; i++){
				System.out.println(digit[i]);
			}
			return;
		}

		int index = -1;

		for(int i = n - 1; i > 0; i--){
			if(digit[i] > digit[i - 1]){
				index = i;
				break;
			}
		}

		System.out.println("index is:" + index);
		if(index == -1){
			for(int i = n - 1; i >= 0; i--){
				System.out.println(digit[i]);
			}
		}else{
			int temp = digit[index - 1];
			int nearestGreaterIndex = index;

			for(int i = index; i < n; i++){
				if(digit[i] > temp && digit[i] <= digit[nearestGreaterIndex]){
					nearestGreaterIndex = i;
				}
			}

			int temp1 = digit[index-1];
			digit[index-1] = digit[nearestGreaterIndex];
			digit[nearestGreaterIndex] = temp1;

			int i = index;
			int j = n - 1;

			while(i < j) {
				int temp3 = digit[i];
				digit[i] = digit[j];
				digit[j] = temp3;

				i++;
				j--;
			}

			for(i = 0; i < n; i++){
				System.out.println(digit[i]);
			}
		}
	}
}