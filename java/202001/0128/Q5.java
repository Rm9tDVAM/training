import java.util.Scanner;
public class Q5{
	public static void main(String[] args){
		System.out.print("人数:");
		int input=new Scanner(System.in).nextInt();
		int[] numBox=new int[input];
		for(int i=0;i<numBox.length;i++){
			System.out.print(i+1+"人目:");
			numBox[i]=new Scanner(System.in).nextInt();
		}
		printStar(numBox);
	}
	public static void printStar(int[] star){
		System.out.println("点数グラフ");
		for(int i=0;i<star.length;i++){
			for(int j=0;j<star[i];j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
