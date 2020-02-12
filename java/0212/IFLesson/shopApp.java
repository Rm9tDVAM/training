public class shopApp{
	public static void main(String[] args){
		TanakaShop ts=new TanakaShop();
		ts.sellFood();
		ts.sellTabacco();
		SuzukiShop ss=new SuzukiShop();
		ss.sellBook();
		ss.sellTabacco();
		ss.sellAlcohol();
	}
}
interface Tabacco{
	void sellTabacco();
}
interface Alcohol{
	void sellAlcohol();
}
class TanakaShop implements Tabacco{
	String tel;
	void sellFood(){
		System.out.println("食品を売ります");
	}
	@Override
	public void sellTabacco(){
		System.out.println("煙草を売ります");
	}
}
class SuzukiShop implements Tabacco,Alcohol{
	String tel;
	void sellBook(){
		System.out.println("本を売ります");
	}
	@Override
	public void sellTabacco(){
		System.out.println("煙草を売ります");
	}
	@Override
	public void sellAlcohol(){
		System.out.println("お酒扱ってます");
	}
}
