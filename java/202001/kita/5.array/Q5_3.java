import java.util.Scanner;
public class Q5_3{
	public static void main(String[] args){
		int[] numBox=new int[10];

		for(int i=0;i<numBox.length;i++){
			System.out.print(i+1+" input num>");
			numBox[i]=new Scanner(System.in).nextInt();
		}
		System.out.println();

		printNumber("odd",numBox);
		printNumber("even",numBox);
	}
	public static void printNumber(String oddOrEven,int[] numArray){
		if(oddOrEven.equals("odd")){
			System.out.print("Odd Numbers:");
			for(int n:numArray){
				if(n%2!=0){
					System.out.print(n);
					System.out.print(" ");
				}
			}
			System.out.println();
		}else{
			System.out.print("Even Numbers:");
			for(int n:numArray){
				if(n%2==0){
					System.out.print(n);
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
