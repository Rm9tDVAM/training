public class MethodLesson5{
	public static void main(String[] args){
		midashiMaker(20,"すごい!!");
		System.out.println("すごいことがありました");
		midashiMaker(30,"大事件発生しました");
		System.out.println("大変なことが起こりました");
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
}
