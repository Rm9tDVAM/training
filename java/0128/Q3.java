/*
③ 受け取ったint型引数の値が負であれば-1を返却し、
0であれば0を返却し、正であれば1を返却するメソッドを作成せよ。
mainメソッドで作ったメソッドの動作を確認すること。

--実行結果--
整数：-5 ←ここで入力する
実行結果は-1です。

--実行結果2--
整数：8 ←ここで入力する
実行結果は1です。
*/
import java.util.Scanner;
public class Q3{
	public static void main(String[] args){
		System.out.print("整数:");
		int input=new Scanner(System.in).nextInt();
		System.out.printf("実行結果は%dです%n",selectNum(input));
	}
	public static int selectNum(int num){
		if(num==0){
			return num;
		}
		if(num>0){
			return 1;
		}else{
			return -1;
		}
	}
}
