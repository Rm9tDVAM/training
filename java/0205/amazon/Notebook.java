import java.util.Scanner;
public class NoteBook extends Book{
	String note="";
	Scanner scan=new Scanner(System.in);
	NoteBook(){
	}
	NoteBook(int page,int price){
		this.page=page;
		this.price=price;
	}
	public void writeBook(){
		System.out.print("書き込む内容を入力して下さい>");
		this.note+=scan.nextLine();
	}
	@Override
	public void showBook(){
		System.out.printf("ページ数:%d%n価格:%d%n内容:%s%n",
				this.page,this.price,this.note);
	}
}
