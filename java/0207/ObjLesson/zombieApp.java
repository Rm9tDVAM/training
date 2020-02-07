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
		for(Zombie z:teamA){
			z.created();
		}
		for(Zombie z:teamB){
			z.created();
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
		p.bite();
		Zombie z=new Zombie(p.hp,suffix);
		return z;
	}
	void created(){
		System.out.printf("うぉ～(%s:%d)%n",this.suffix,this.hp);
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
