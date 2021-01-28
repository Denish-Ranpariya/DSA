import java.util.Scanner;
class DoubleStack{

	static final int max=6;
	int top1=-1;
	int top2=max;
	int a[]=new int[max];


	public static void main(String[] args) {
		DoubleStack s=new DoubleStack();
		Scanner sc=new Scanner(System.in);
		int choice=0,choice1=0;
		
		
		do{
			System.out.println("Enter your choice(1.for stack1,2.for stack2):");
			choice1=sc.nextInt();
				switch(choice1){

					case 1:{
						do{
						System.out.println("Enter your choice(1. for push,2. for pop,3. for display,4.for exit):");
							choice=sc.nextInt();
							switch(choice){
								case 1:{
									System.out.println("Enter the Value to push:");
									int x=sc.nextInt();
									s.pushA(x);
									
								}
								break;


								case 2:{
									s.popA();
								}
								break;

								case 3:{
									s.displayA();
								}
								break;

								case 4:{
									System.out.println("loop terminated.");

								}
								break;


							}
						}while(choice!=4);
					}
					break;

					case 2:{
						do{
						System.out.println("Enter your choice(1. for push,2. for pop,3. for display,4.for exit):");
							choice=sc.nextInt();
							switch(choice){
								case 1:{
									System.out.println("Enter the Value to push:");
									int x=sc.nextInt();
									s.pushB(x);
									
								}
								break;


								case 2:{
									s.popB();
								}
								break;

								case 3:{
									s.displayB();
								}
								break;

								case 4:{
									System.out.println("loop terminated.");

								}
								break;


							}
						}while(choice!=4);
					}

				}
		}while(choice1!=3);
	}

		void pushA(int x){
			if((top1+1)==top2){
				System.out.println("Stack Overflow.");
			}
			else{
				top1=top1+1;
				a[top1]=x;
			}
		}
	

		void popA(){
			if(top1==-1){
				System.out.println("Stack Underflow.");
				
			}
			else{
				int temp=a[top1];
				top1=top1-1;
				System.out.println("poped element:"+temp);
			}
		}


		void displayA(){
			for(int i=top1;i>=0;i--){
				System.out.println("\n"+a[i]);
			}
		}


		void pushB(int x){
			if(top2==(top1+1)){
				System.out.println("Stack Overflow.");
			}
			else{
				top2=top2-1;
				a[top2]=x;
			}
		}
	

		void popB(){
			if(top2==(max)){
				System.out.println("Stack Underflow.");
				
			}
			else{
				int temp=a[top2];
				top2=top2+1;
				System.out.println("poped element:"+temp);
			}
		}


		void displayB(){
			for(int i=top2;i<max;i++){
				System.out.println("\n"+a[i]);
			}
		}
}
