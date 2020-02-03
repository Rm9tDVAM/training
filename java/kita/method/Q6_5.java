public class Q6_5{
	public static void main(String[] args){
		printInt(3,'#');
		printInt(5,'$');
		printInt(7,'&');
	}
	public static void printInt(int num,char printChar){
		for(int i=0;i<num;i++){
			for(int j=0;j<i+1;j++){
				System.out.print(printChar);
			}
			System.out.println();
		}
		System.out.println();
	}
}
