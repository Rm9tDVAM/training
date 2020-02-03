public class Main{
	public static void main(String[] args){
		Hero h1=new Hero("ミナト");
		Hero h2=new Hero("カイル");
		h1.sleep();
		h2.sleep();
		Matango m1=new Matango();
		m1.suffix='A';
		Cleric c=new Cleric();
		c.name="アラン";
		h1.slip();
		h2.slip();
		m1.run();
		c.aid(h1);
		c.pray(3);
		Sword fireSword=new Sword();
		fireSword.name="炎の剣";
		fireSword.damege=10;
		Sword iceSword=new Sword();
		iceSword.name="氷の剣";
		iceSword.damege=8;
		h1.sword=iceSword;
		h1.attack(m1);
		h2.sword=fireSword;
		h2.attack(m1);
		h1.run();
		h2.run();
	}
}
