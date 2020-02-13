public class Wand{
	private String name;
	private double power;
	public void setName(String name){
		if(name.length()<3){
			throw new IllegleArgumentException(”名前は3文字以上です");
		}
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public void setPower(double power){
		this.power=power;
	}
	public double getPower(){
		return this.power;
	}
}

