public class PoisonMatango extends Matango{
	int poisonCount=5;
	public PoisonMatango(char c){
		Super(c);
	}
	@override
	public void attack(hero h){
		super.attack(h);
		if(this.poisonCount>0){
			System.out.println("さらに毒の胞子をばらまいた!");
			int damege=h.hp/5;
			System.out.println(damege+"ポイントのダメージ");
			h.hp-=damege;
			this.poisonCount--;
		}
	}
}
