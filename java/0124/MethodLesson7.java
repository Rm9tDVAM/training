import java.util.Scanner;
public class MethodLesson7{
	static void printSquare(char c,int width){
		for(int i=0;i<width;i++){
			for(int j=0;j<width;j++){
				System.out.print(c);
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.print("一文字入れてください>");
		String s=scan.next();
		char c=s.charAt(0);
		System.out.print("幅を入れてください>");
		int width=scan.nextInt();
		printSquare(c,width);
		scan.close();
	}
}
