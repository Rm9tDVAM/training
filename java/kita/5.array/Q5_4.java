import java.util.Scanner;
public class Q5_4{
	public static void main(String[] args){
		int sum=0;
		int[] numBox=new int[10];

		for(int i=0;i<numBox.length;i++){
			numBox[i]=userInputNum();
			sum+=numBox[i];
			if(sum>100){
				arrayPrint(numBox,i+1);
				return;
			}
		}
		arrayPrint(numBox);
	}

	public static int userInputNum(){
		System.out.print("input number>");
		int temp=new Scanner(System.in).nextInt();
		return temp;
	}

	public static void arrayPrint(int[] array){
		for(int n:array){
			System.out.println(n);
		}
	}

	public static void arrayPrint(int[] array,int round){
		for(int i=0;i<round;i++){
			System.out.println(array[i]);
		}
	}
}
