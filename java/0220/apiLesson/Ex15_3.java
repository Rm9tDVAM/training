public class Ex15_3{
	public static void main(String[] args){
		String pattern=".*";
		if("abcdefghijklmnopqrstuvwyz0123456789".matches(pattern)){
			System.out.println("match!!");
		}
		pattern="A[0-9][0-9]?";
		if("A3".matches(pattern)){
			System.out.println("match!!");
		}
		pattern="U[A-Z]{3}";
		if("UABC".matches(pattern)){
			System.out.println("match!!");
		}
	}
}
