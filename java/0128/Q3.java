import java.util.Scanner;
public class Q3{
	public static void main(String[] args){
		System.out.print("整数:");
		int input=new Scanner(System.in).nextInt();
		System.out.printf("実行結果は%dです%n",selectNum(input));
	}
	public static int selectNum(int num){
		if(num==0){
			return num;
		}
		if(num>0){
			return 1;
		}else{
			return -1;
		}
	}
}
