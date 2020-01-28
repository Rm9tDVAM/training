import java.util.Scanner;
public class Q6{
	public static void main(String[] args){
		System.out.print("要素数:");
		int input=new Scanner(System.in).nextInt();
		int[] inputBox=new int[input];
		for(int i=0;i<inputBox.length;i++){
			System.out.printf("x[%d]:",inputBox[i]);
			inputBox[i]=new Scanner(System.in).nextInt();
		}
		reverseArray(inputBox);
		System.out.println("要素の並びを反転しました");
		for(int n:inputBox){
			System.out.printf("x[%d]:%n",n);
		}
	}
	public static int[] reverseArray(int[] arr){
	return arr;
	}
}
