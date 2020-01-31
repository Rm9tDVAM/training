import java.util.Scanner;
public class Lesson4{
	public static void main(String[] args){
		System.out.print("配列の要素数を入力してください>");
		int len=new Scanner(System.in).nextInt();
		int[] nums=new int[len];
		for(int i=0;i<nums.length;i++){
			System.out.printf("nums[%d]:>",i);
			nums[i]=new Scanner(System.in).nextInt();
		}
		displayArray(nums);
		multiNum(nums);
		System.out.println("もともとの配列を出力します。");
		displayArray(nums);
		System.out.println("参照渡しはもともとの引数に影響を及ぼします。(操作している配列は一つ)");
	}
	public static void multiNum(int[] nums){
		System.out.println("配列の要素を2倍します。");
		for(int i=0;i<nums.length;i++){
			nums[i]*=2;
		}
		displayArray(nums);
	}
	public static void displayArray(int[] arr){
		System.out.print("{");
		for(int i=0;i<arr.length;i++){
			System.out.printf("%d,",arr[i]);
		}
		System.out.println("}");
	}
}

