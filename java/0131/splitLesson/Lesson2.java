public class Lesson1{
	public static void main(String[] args){
		String str4="3,5,7,19";
		int[] dataInt;
		String[] data4=str4.split(",");
		dataInt=new int[data4.length];
		for(int i=0;i<data4.length;i++){
			int temp=0;
			temp=Integer.parseInt(data4[i]);
			dataInt[i]=temp;
		}
		int sum=0;
		for(int n:dataInt){
			sum+=n;
		}
		System.out.print("合計は"+sum);
	}
}
