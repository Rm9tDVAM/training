public class Book{
	int page;
	int price;
	Book(){
	}
	Book(int page,int price){
		this.page=page;
		this.price=price;
	}
	public void showBook(){
		System.out.printf("ページ数:%d%n価格:%d%n",this.page,this.price);
	}
}
