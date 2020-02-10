public abstract class Charactor{
	String name;
	int hp;
	public abstract void attack(Matango m);
	public void run(){
		System.out.println(this.name+"は逃げ出した");
	}
}
abstract class Dancer extends Charactor{
	public void dance(){
		System.out.println("ダンスで魅了した");
	}
}
class SalsaDancer extends Dancer{
	@Override
	public void attack(Matango m){
		this.dance();
		System.out.println("マタンゴはつられて踊った!");
	}
}
class Hero extends Charactor{
	@Override
	public void attack(Matango m){
		System.out.println("マタンゴに攻撃した");
		m.hp-=10;
	}
}
