import java.util.*;
public class Cleric{
	String name;
	int hp=50;
	final int MAX_HP=50;
	int mp=10;
	final int MAX_MP=10;
	public void selfAid(){
		System.out.println(this.name+"はセルフエイドを唱えた");
		this.hp=this.MAX_HP;
		this.mp-=5;
		System.out.println("HPが最大まで回復した");
	}
	public void aid(Hero h){
		System.out.println(this.name+"はエイドを唱えた");
		h.hp+=10;
		this.mp-=5;
		System.out.println(h.name+"のHPが10回復した");
	}
	public int pray(int sec){
		System.out.println(this.name+"は"+sec+"秒間天に祈った!");
		int recoverMp=sec+new Random().nextInt(3);
		if(this.mp+recoverMp>MAX_MP){
			recoverMp=MAX_MP-this.mp;
		}
		this.mp+=recoverMp;
		System.out.println("MPが"+recoverMp+"回復した");
		return recoverMp;
	}
}
