import java.util.Scanner;
public class Q1 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		while(true){
			System.out.print("1. 立方体 / 2. 球 / 3.終了 >");
			int select=s.nextInt();
			switch(select){
			case 1:
				System.out.print("１辺の長さを入力して下さい >");
				double width=s.nextDouble();
				Cube c1=new Cube(width);
				c1.displayAreaInfo();
				break;
			case 2:
				System.out.print("半径を入力して下さい >");
				double r=s.nextDouble();
				new Sphere(r).displayAreaInfo();
				break;
			case 3:
				System.out.println("アプリケーションを終了します。");
				return;
			}
		}
	}
}
