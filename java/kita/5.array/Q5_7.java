import java.util.Scanner;
public class Q5_7{
	public static void main(String[] args){
		int[][] kuku=new int[9][];

		for(int i=0;i<9;i++){
				kuku[i]=new int[9];
			for(int j=0;j<9;j++){
				kuku[i][j]=(i+1)*(j+1);
			}
		}

		System.out.print("input first num(1~9)>");
		int firstNum=new Scanner(System.in).nextInt();
		System.out.print("input second num(1~9)>");
		int secondNum=new Scanner(System.in).nextInt();

		System.out.println(kuku[firstNum-1][secondNum-1]);
	}
}
