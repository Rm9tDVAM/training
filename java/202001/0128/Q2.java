/*
② 表示する文字列と、繰り返す回数を受けてその回数だけ、
文字列を表示するメソッドを作成せよ。
mainメソッドで作ったメソッドの動作を確認すること。

--実行結果--
文字列：わーい！ ←ここで入力する
実行回数：3 ←ここで入力する
わーい！
わーい！
わーい！
*/
import java.util.Scanner;
public class Q2{
	public static void main(String[] args){
		System.out.print("出力する文字列を入れてください>");
		String str=new Scanner(System.in).nextLine();
		System.out.print("何回繰り返しますか?>");
		int round=new Scanner(System.in).nextInt();
		printString(round,str);
	}
	public static void printString(int round,String str){
		for(int i=0;i<round;i++){
			System.out.println(str);
		}
	}
}
