public class Book{
	String name;
	@Override
	public String toString(){
		return "名前:"+this.name;
	}
	@Override
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if(o instanceof Book){
			Book b=(Book)o;
			if(this.name.equals(b.name)){
				return true;
			}
		}
		return false;
	}
}
