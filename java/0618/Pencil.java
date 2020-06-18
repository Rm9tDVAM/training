public class Pencil{
	private String color;
	private int len;

	Pencil(String color,int len){
		this.color=color;
		this.len=len;
	}

	public String getColor(){
		return this.color;
	}

	public void setColor(String color){
		this.color=color;
	}

	public int getLen(){
		return this.len;
	}

	public void setLen(int len){
		this.len=len;
	}

	public void showInfo(){
		System.out.printf("色:%s, 長さ:%d%n",this.color,this.len);
	}
}
