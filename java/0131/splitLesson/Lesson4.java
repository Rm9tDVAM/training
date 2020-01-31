import java.util.Arrays;
import java.util.Scanner;
public class Lesson4{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.print("数値いれてね>");
		int n=scan.nextInt();scan.nextLine();//空読み
		System.out.print("名前いれてね>");
		String name=scan.nextLine();
		System.out.printf("%sさんは%dといれました%n",name,n);
	}
}
