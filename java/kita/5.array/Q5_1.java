import java.util.Scanner;
public class Q5_1{
	public static void main(String[] args){
		int[] numBox=new int[10];

		for(int i=0;i<numBox.length;i++){
			System.out.print(i+1+" input num>");
			numBox[i]=new Scanner(System.in).nextInt();
		}
		System.out.println();

		for(int i:numBox){
			System.out.println(i*2);
		}
	}
}
