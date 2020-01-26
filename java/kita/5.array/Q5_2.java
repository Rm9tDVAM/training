import java.util.Scanner;
public class Q5_2{
	public static void main(String[] args){
		int[] numBox=new int[10];

		for(int i=0;i<numBox.length;i++){
			System.out.print(i+1+" input num>");
			numBox[i]=new Scanner(System.in).nextInt();
		}
		System.out.println();

		for(int i=0;i<numBox.length;i++){
			System.out.println(numBox.length-1-i);
		}
	}
}
