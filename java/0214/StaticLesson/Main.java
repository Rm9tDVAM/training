public class Main{
	public static void main(String[] args){
		Hero.showNo();
		Hero h1=new Hero("Jhon");
		h1.showInfo();
		Hero h2=new Hero("Paul");
		h2.showInfo();
		Hero.showNo();
	}
}
class Hero{
	static int no;
	int id;
	String name;
	Hero(String name){
		Hero.no++;
		this.id=Hero.no;
		this.name=name;
	}
	void showInfo(){
		System.out.printf("name:%s id:%d%n",this.name,this.id);
	}
	static void showNo(){
		System.out.println(Hero.no);
	}
}
