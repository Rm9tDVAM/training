import java.util.*;
public class ObjectArr{
	public static void main(String[] args){
		Sword s1=new Sword("炎の剣",20);
		Sword s2=new Sword("氷の剣",18);
		Sword s3=new Sword("ヒノキの剣",10);
		Sword s4=new Sword("こんぼう",5);
		/*Sword[] swords=new Sword[4];
		swords[0]=s1;
		swords[1]=s2;
		swords[2]=s3;
		swords[3]=s4;*/
		Sword[] swords2={
			new Sword("雷神の剣",100),
			new Sword("はやぶさの剣",50),
			new Sword("土の剣",8),
			s1,s2,s3,s4
		};
		showSword(swords2);
		System.out.print("どの武器を装備しますか>");
		//Sword sword=swords2[new Random().nextInt(swords2.length)];
		int num=new Scanner(System.in).nextInt();
		Sword sword=swords2[num];
		Hero h1=new Hero("みなと");
		h1.equip(sword);
		//h1.sword=sword;
		Matango m1=new Matango();
		m1.suffix='A';
		h1.attack(m1);
		m1.run();
	}
	public static void showSword(Sword[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.printf("%d...%s(%d)%n",i,arr[i].name,arr[i].damege);
		}
	}
}
