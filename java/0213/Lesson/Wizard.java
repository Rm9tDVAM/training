public class Wizard{
	private int hp;
	private int mp;
	private String name;
	Wand wand;
	void heal(Hero h){
		int basePoint=10;
		int recovPoint=(int)(basePoint*getPower());
		h.setHp(h.getHp()+recovPoint);
		System.out.println(h.getName()+"のHPを"+recovPoint+"回復した!");
	}
	public void setHp(int hp){
		this.hp=hp;
	}
	public int getHp(){
		return this.hp;
	}
	public void setMp(int mp){
		this.mp=mp;
	}
	public int getMp(){
		return this.mp;
	}
	public void setName(String name){
		if(name.length()<3){
			throw new IllegalArgumentException("名前は3文字以上です");
		}
	}
	public String getName(){
		return this.name;
	}
	public void setWand(Wand wand){
		this.wand=wand;
	}
	public Wand getWand(){
		return this.wand;
	}
}
