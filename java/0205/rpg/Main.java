public class Main{
	public static void main(String[] args){
		SuperHero sh=new SuperHero();
		Matango m1=new Matango();
		m1.suffix='A';
		sh.fly();
		sh.land();
		sh.run();
		sh.fly();
		sh.attack(m1);
		Hero h=new Hero();
		poisonMatango pm=new PoisonMatango();
		pm.attack(h);
	}
}
