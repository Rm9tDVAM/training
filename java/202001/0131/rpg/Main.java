public class Main{
	public static void main(String[] args){
		Hero h=new Hero();
		h.name="ミナト";
		h.hp=100;

		Hero h1=new Hero("ジェシカ");
		h1.hp=100;

		Hero h2=new Hero("カイル",200);

		Matango m1=new Matango();
		m1.hp=50;
		m1.suffix='A';

		Matango m2=new Matango();
		m1.hp=48;
		m1.suffix='A';

		h.slip();
		m1.run();
		m2.run();
		h.run();
		h1.run();
		h2.run();
	}
}
