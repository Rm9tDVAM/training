import java.util.Scanner;
public class Lesson1{
	public static void main(String[] args){
		System.out.print("num>");
		int num=new Scanner(System.in).nextInt();
		for(int i=0;i<num;i++){
			System.out.print(num-i);
			new Scanner(System.in).nextLine();
		}
	}
}
