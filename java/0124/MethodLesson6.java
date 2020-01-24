public class MethodLesson6{
	public static void main(String[] args){
		midashiDeco("hello");
		midashiDeco(" ");
		midashiDeco("i have a pen");
		midashiDeco("にばいともじ");
	}
	public static void printLine(int width){
		for(int i=0;i<width;i++){
			System.out.print("*");
		}
		System.out.println();
	}
	public static void midashiMaker(int width,String title){
		printLine(width);
		System.out.println("*"+title);
		printLine(width);
	}
	public static void midashiDeco(String title){
		printLine(title.length()+2);
		System.out.println("*"+title+"*");
		printLine(title.length()+2);
	}
}
