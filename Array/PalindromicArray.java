//program to find the palindrom of array
// Given a Integer array A[] of n elements. Your task is to complete the function PalinArray. Which will return 1 if all the elements of the Array are palindrome otherwise it will return 0.
import java.util.*;

class PalindromicArray{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//take input of array here
	}

	public static int palinArray(int[] a, int l){
      //add code here.
      for(int i = 0; i < a.length; i++){
          int n = a[i];
          int result = 0;

		int m = n;

		while(m != 0){
			int modulo = m % 10;
			result = result * 10 + modulo;
			m = m / 10;
		}
		
		if(result != a[i]){
		    return 0;
		}
		
		
      }
      return 1;
    }
}