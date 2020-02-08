import java.util.*;
public class zombieApp{
	public static void main(String[] args){
		Random rand=new Random();
		Person[] persons=new Person[100];
		for(int i=0;i<100;i++){
			int hp=rand.nextInt(99)+1;
			persons[i]=new Person(hp);
		}
		Zombie[] teamA=new Zombie[3];
		Zombie[] teamB=new Zombie[3];
		char s='A';
		teamA[0]=new Zombie(50,s++);
		char sb='a';
		teamB[0]=new Zombie(50,sb++);
		for(int i=0;i<4;i++){
			if(i<2){
				teamA[i+1]=teamA[0].bitePerson(persons[i],s++);
			}else{
				teamB[i-1]=teamB[0].bitePerson(persons[i],sb++);
			}
		}
		showTeam("TeamA",teamA);
		showTeam("TeamB",teamB);
		battleTeam(teamA,teamB);
	}
	static void battleTeam(Zombie[] teamA,Zombie[] teamB){
		while(true){
			Zombie a=pickZombie(teamA);
			Zombie b=pickZombie(teamB);
			if(a==null){
				System.out.println("Team B Win!!");
				break;
			}else if(b==null){
				System.out.println("Team A Win!!");
				break;
			}else{
				System.out.println("zombie-"+a.suffix+
						" VS "+"zombie-"+b.suffix);
				battleZombie(a,b);
			}
		}
	}
	static void battleZombie(Zombie a,Zombie b){
		while(a.hp > 0 && b.hp>0){
			int n=new Random().nextInt(2);
			int power;
			if(n==0){
				power=a.attack();
				b.attacked(power);
			}else{
				power=b.attack();
				a.attacked(power);
			}
		}
	}
	static Zombie pickZombie(Zombie[] team){
		for(int i=0;i<team.length;i++){
			if(team[i].hp >0){
				return team[i];
			}
		}
		return null;
	}
	static void showTeam(String teamName,Zombie[] team){
		sortTeam(team);
		System.out.println("***"+teamName+"***");
		for(Zombie z:team){
			z.showInfo();
		}
	}
	static void sortTeam(Zombie[] team){
		for(int i=0;i<team.length-1;i++){
			for(int j=i+1;j<team.length;j++){
				if(team[i].hp>team[j].hp){
					Zombie temp=team[i];
					team[i]=team[j];
					team[j]=temp;
				}
			}
		}
	}
}
class Zombie{
	int hp;
	int mp=10;
	char suffix;
	Zombie(int hp){
		this.hp=hp;
	}
	Zombie(int hp,char suffix){
		this(hp);
		this.suffix=suffix;
	}
	Zombie bitePerson(Person p,char suffix){
		System.out.println("zombie-"+this.suffix+"が咬みついた!");
		p.bite();
		Zombie z=new Zombie(p.hp,suffix);
		z.created();
		return z;
	}		
	void created(){
		System.out.println("うぉ～");
		this.showInfo();
		System.out.println("が誕生した!");
	}
	void showInfo(){
		System.out.printf("zombie-%s HP:%d MP:%d%n",
				this.suffix,
				this.hp,
				this.mp
				);
	}
	int attack(){
		int power=new Random().nextInt(30);
		if(power<4){
			System.out.println("zombie-"+this.suffix+"腕をちぎって投げた!");
			if(this.mp<5){
				System.out.println("しかし、腕がなかった!!!");
			}else{
				power=50;
				this.hp-=5;
			}
		}else{
			System.out.println("zombie-"+this.suffix+"は咬みついた!");
		}
		return power;
	}
	void attacked(int power){
		System.out.println("ｷｬ━━━━(ﾟ∀ﾟ)━━━━!!");
		System.out.println("zombie-"+this.suffix+"は"+power+"のダメージを受けた");
		this.hp-=power;
		if(this.hp<=0){
			System.out.println("zombie-"+this.suffix+"は力尽きた");
		}else{
			this.showInfo();
		}
		System.out.println();
	}
}
class Person{
	int hp;
	boolean isAlive=true;
	Person(int hp){
		this.hp=hp;
	}
	void bite(){
		System.out.println("ぎゃー");
		this.isAlive=false;
	}
}
