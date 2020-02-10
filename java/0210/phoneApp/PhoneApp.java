import java.util.*;
public class PhoneApp{
	public static void main(String[] args){
		Phone p1=new Phone("黒電話",12000);
		p1.call("鈴木");
		p1.showInfo();
		SmartPhone sp1=new SmartPhone("iPhone",80000,"iOS");
		sp1.call("田中");
		sp1.playAppri("パズドラ");
		sp1.showInfo();
		SmartPhone sp2=new SmartPhone("Aquos",60000,"Android");
		sp2.call("山田");
		sp2.playAppri("モンスト");
		sp2.showInfo();
	}
}
class Phone{
	String name;
	int price;
	Phone(String name,int price){
		this.name=name;
		this.price=price;
	}
	void call(String name){
		System.out.println(name+"に電話をかけた");
	}
	void showInfo(){
		System.out.printf("%s(%d)%n",this.name,this.price);
	}
}
class SmartPhone extends Phone{
	String os;
	SmartPhone(String name,int price,String os){
		super(name,price);
		this.os=os;
	}
	void playAppri(String appName){
		System.out.println(appName+"で遊んだ");
	}
	@Override
	void showInfo(){
		super.showInfo();
		System.out.println("OS"+this.os);
	}
}
