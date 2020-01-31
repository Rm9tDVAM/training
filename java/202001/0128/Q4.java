import java.util.Random;
import java.util.Scanner;
public class Q4{
	public static void main(String[] args){
		System.out.print("正の整数a:");
		int intA=new Scanner(System.in).nextInt();
		System.out.print("正の整数b:");
		int intB=new Scanner(System.in).nextInt();
		System.out.printf("生成したランダムな値は%dです",randomNum(intA,intB));
	}
	public static int randomNum(int a,int b){
		int r=new Random().nextInt(b-a+1)+a;
		return r;
	}
}
