/*
⑥ 配列をうけとり要素の並びを反転させ返却するメソッドを作成せよ。
mainメソッドで作ったメソッドの動作を確認すること。

--実行結果--
要素数：5 ←ここで入力する
x[0]：10 ←ここで入力する
x[1]：73 ←ここで入力する
x[2]：2 ←ここで入力する
x[3]：-5 ←ここで入力する
x[4]：42 ←ここで入力する
要素の並びを反転しました。
x[0]：42
x[1]：-5
x[2]：2
x[3]：73
x[4]：10
*/
import java.util.Scanner;
public class Q6{
	public static void main(String[] args){
		System.out.print("要素数:");
		int input=new Scanner(System.in).nextInt();
		int[] inputBox=new int[input];
		for(int i=0;i<inputBox.length;i++){
			System.out.printf("x[%d]:",i);
			inputBox[i]=new Scanner(System.in).nextInt();
		}
		reverseArray(inputBox);
		System.out.println("要素の並びを反転しました");
		for(int i=0;i<inputBox.length;i++){
			System.out.printf("x[%d]:%d%n",i,inputBox[i]);
		}
	}
	public static int[] reverseArray(int[] arr){
		for(int i=0;i<arr.length/2;i++){
			int temp;
			temp=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
		}
	return arr;
	}
}
