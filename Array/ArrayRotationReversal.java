class ArrayRotationReversal{
// 	Let AB are the two parts of the input array where A = arr[0..d-1] and B = arr[d..n-1]. The idea of the algorithm is : 
 

// Reverse A to get ArB, where Ar is reverse of A.
// Reverse B to get ArBr, where Br is reverse of B.
// Reverse all to get (ArBr) r = BA.
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int d = 2;
		int n = arr.length;

		reverseArray(arr,0,d-1);
		reverseArray(arr,d,n-1);
		reverseArray(arr,0,n-1);

		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}

	


	static void reverseArray(int[] a,int start, int end){
		while(start < end){
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}

}