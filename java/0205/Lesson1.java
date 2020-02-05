public class Lesson1{
	public static void main(String[] args) throws Exception{
		long start=System.currentTimeMillis();
		Thread.sleep(3000);
		long end=System.currentTimeMillis();
		long diff=end-start;
		System.out.println(diff);
	}
}
