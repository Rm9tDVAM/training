public class Matango{
	int hp=50;
	final int LEVEL=10;
	char suffix;
	public void run(){
		System.out.println("お化けキノコ"+this.suffix+"は逃げ出した");
	}
	public void attack(hero h){
		System.out.println("キノコ"+this.suffix+"の攻撃");
		System.out.println("10のダメージ");
		h.hp-=10;
	}
}
