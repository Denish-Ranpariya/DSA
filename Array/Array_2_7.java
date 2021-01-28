//program to find the same elements in three sorted arrays

import java.util.*;

class Array_2_7{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array 1:");
		int n1 = sc.nextInt();
		int arr1[] = new int[n1];

		for(int i = 0; i < n1; i++){
			System.out.println("Enter the number at " + (i+1) + ":");
			arr1[i] = sc.nextInt();
		}

		System.out.println("Enter the length of array 2:");
		int n2 = sc.nextInt();
		int arr2[] = new int[n2];

		for(int i = 0; i < n2; i++){
			System.out.println("Enter the number at " + (i+1) + ":");
			arr2[i] = sc.nextInt();
		}

		System.out.println("Enter the length of array 3:");
		int n3 = sc.nextInt();
		int arr3[] = new int[n3];

		for(int i = 0; i < n3; i++){
			System.out.println("Enter the number at " + (i+1) + ":");
			arr3[i] = sc.nextInt();
		}
		

		int p1 = 0;//pointer for first array
		int p2 = 0;//pointer for second array
		int p3 = 0;//pointer for third array

		while(p1!=n1 && p2!=n2 && p3!=n3){
			if(arr1[p1] == arr2[p2] && arr2[p2]  == arr3[p3]){ //if all are same then print and increment all the pointers
				System.out.println(arr1[p1]);
				p1++;
				p2++;
				p3++;
			}else if(arr1[p1] < arr2[p2]  && arr1[p1] < arr3[p3]){ //find the smallest element and increment its pointer only
				p1++;
			}else if(arr2[p2] < arr3[p3] && arr2[p2] < arr1[p1]){
				p2++;
			}else{
				p3++;
			}
		}
	}
}