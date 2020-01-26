import java.util.Scanner;
public class Q5_5{
	public static void main(String[] args){
		System.out.print("input num>");
		int inputNum=new Scanner(System.in).nextInt();
		int[] binary=new int[16];

		for(int i=0;i<binary.length;i++){
			binary[binary.length-1-i]=inputNum%2;
			inputNum/=2;
		}

		for(int n:binary){
			System.out.print(n);
		}
	}
}
