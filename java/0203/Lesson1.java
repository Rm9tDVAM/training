public class Lesson1{
	public static void main(String[] args){
		System.out.println(sumOf(10));
	}
	public static int sumOf(int n){
		if(n<=1){
			return n;
		}else{
			return n+sumOf(n-1);
		}
	}
}
