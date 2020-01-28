import java.util.Scanner;
public class Q2{
	public static void main(String[] args){
		System.out.print("何回繰り返しますか?>");
		int round=new Scanner(System.in).nextInt();
		System.out.print("出力する文字列を入れてください>");
		String str=new Scanner(System.in).nextLine();
		printString(round,str);
	}
	public static void printString(int round,String str){
		for(int i=0;i<round;i++){
			System.out.println(str);
		}
	}
}
