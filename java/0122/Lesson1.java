public class Lesson1{
	public static void main(String[] args){
		countDown(-5);
		countDown(10);
	}
	public static void countDown(int num){
		if(num<=0){
			return;
		}
		for(int i=num;i>0;i--){
			System.out.println(i);
		}
	}
}
