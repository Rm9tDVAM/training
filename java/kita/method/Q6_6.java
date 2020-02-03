public class Q6_6{
	public static void main(String[] args){
		for(int i=0;i<9;i++){
			kuku(i+1);
		}
	}
	public static void kuku(int num){
		for(int i=0;i<9;i++){
			System.out.printf("%3d",(1+i)*num);
		}
		System.out.println();
	}
}
