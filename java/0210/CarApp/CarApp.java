public class CarApp{
	public static void main(String[] args){
		new F1().run();
		new Truck().run();
	}
}
abstract class Car{
	String name;
	abstract void run();
}
class F1 extends Car{
	void run(){
		System.out.println("ファーーーーーーン");
	}
}
class Truck extends Car{
	void run(){
		System.out.println("ゴー");
	}
}
