import java.util.Scanner;
public class Q6_4{
	public static void main(String[] args){
		printInt(3);
		printInt(4);
		printInt(5);
	}
	public static void printInt(int num){
		for(int i=0;i<num;i++){
			for(int j=0;j<i+1;j++){
				System.out.print("$");
			}
			System.out.println();
		}
		System.out.println();
	}
}
