public class Slime{
	String name;
	int hp=20;
	Slime(){
	}
	Slime(String name){
		this.name=name;
	}
	void appear(){
		System.out.println(this.name+"が現れた!!");
	}
	void run(){
		System.out.println(this.name+"は逃げ出した!");
	}
}
