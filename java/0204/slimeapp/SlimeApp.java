public class SlimeApp{
	public static void main(String[] args){
		Slime surarin=new Slime();
		surarin.name="スラリン";
		Slime surakiti=new Slime();
		surakiti.name="スラキチ";
		surarin.appear();
		surakiti.appear();
		Slime surachi=new Slime("スラッチ");
		surachi.appear();
		Slime[] SlimeArr={surarin,surakiti,surachi};
		for(Slime n:SlimeArr){
			n.run();
		}
	}
}
