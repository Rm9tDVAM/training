import java.util.Scanner;
public class MonkeyApp{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.print("おさるの名前を決めてください>");
		String name=scan.nextLine();
		System.out.print("おさるの歳を決めてください>");
		int age=scan.nextInt();
		Monkey monk1=new Monkey();
		monk1.name=name;
		monk1.age=age;
		while(true){
			System.out.print("おさるに何をさせますか？1...挨拶、2...竹馬、3...逆立ち、4...終了>");
			int select=scan.nextInt();
			switch(select){
				case 1:
					monk1.monHello();
					break;
				case 2:
					monk1.monTakeuma();
					break;
				case 3:
					monk1.monSakadachi();
					break;
				case 4:
					System.out.println("アプリケーションを終了します。");
					return;
			}
		}
	}
}
