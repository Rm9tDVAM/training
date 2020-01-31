public class Main{
	public static void main(String[] args){
		Hero h=new Hero();
		h.name="ミナト";
		h.hp=100;
		System.out.println("勇者"+h.name+"を生み出しました!");
		h.sit(5);
		h.slip();
		h.sit(25);
		//h.run();
		Hero h2=new Hero();
		h2.name="ロト";
		h2.hp=1000;
		System.out.println("勇者"+h2.name+"がパーティに加わった");
		h2.sit(25);
	}
}
