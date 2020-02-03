import java.util.Scanner;
public class Q6_3{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.print("x>");
		int x=scan.nextInt();
		System.out.print("y>");
		int y=scan.nextInt();
		System.out.print("z>");
		int z=scan.nextInt();
		int temp=numMax(x,y);
		System.out.println(numMax(temp,z));
	}
	public static int numMax(int num1,int num2){
		int temp=0;
		if(num1>num2){
			return num1;
		}else{
			return num2;
		}
	}
}
