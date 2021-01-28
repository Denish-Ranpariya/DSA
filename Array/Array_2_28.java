//spiral matrix MMMIMP
//for explanation see photo

import java.util.*;

class Array_2_28{
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

		int top = 0;
		int down = n - 1;
		int left = 0;
		int right = m - 1;
		int dir = 0;

		while(top <= down && left <= right){
			if(dir == 0){
				for(int i = left; i <= right; i++){
					System.out.println(a[top][i]);
				}
				top++;
			}else if(dir == 1){
				for(int i = top; i <= down; i++){
					System.out.println(a[i][right]);
				}
				right--;
			}else if(dir == 2){
				for(int i = right; i >= left; i--){
					System.out.println(a[down][i]);
				}
				down--;
			}else if(dir == 3){
				for(int i = down; i >= top; i--){
					System.out.println(a[i][left]);
				}
				left++;
			}

			dir = (dir + 1) % 4;
		}

	}
}