public class Monkey{
	String name;
	int age;
	public void monHello(){
		System.out.printf("こんにちは%s(%d歳)です。よろしく!%n",
				this.name,this.age);
	}
	public void monTakeuma(){
		System.out.printf("%s上手に竹馬にのった!%n",
				this.name);
	}
	public void monSakadachi(){
		System.out.printf("%sはひょいと逆立ちをした!%n",
				this.name);
	}
}
