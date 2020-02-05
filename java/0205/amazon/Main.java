import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int inputPage,inputPrice;

		System.out.print("本のページ数を入力して下さい>");
		inputPage=scan.nextInt();
		System.out.print("本の価格を入力して下さい>");
		inputPrice=scan.nextInt();
		Book n1=new Book(inputPage,inputPrice);

		System.out.print("ノートのページ数を入力して下さい>");
		inputPage=scan.nextInt();
		System.out.print("ノートの価格を入力して下さい>");
		inputPrice=scan.nextInt();
		NoteBook n2=new NoteBook(inputPage,inputPrice);

		while(true){
			System.out.print("1. 本の情報表示 / 2. ノートの情報表示 / 3. ノートに追加書込 / 4. 終了>");
			int select=scan.nextInt();
			switch(select){
				case 1:
					n1.showBook();
					break;
				case 2:
					n2.showBook();
					break;
				case 3:
					n2.writeBook();
					break;
				case 4:
					System.out.println("アプリケーションを終了します。");
					return;
			}
		}
	}
}
