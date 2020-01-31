import java.util.Arrays;
public class Lesson1{
	public static void main(String[] args){
		String str="リンゴ,ゴリラ,ラッパ";
		String[] data=str.split(",");
		System.out.println(Arrays.toString(data));
		String str2="リンゴとゴリラとラクダ";
		String[] data2=str2.split("と");
		System.out.println(Arrays.toString(data2));
		String str3="Mac,Win、Linux";
		String[] data3=str3.split("[,、]");//正規表現[,、]は,または、
		System.out.println(Arrays.toString(data3));
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
