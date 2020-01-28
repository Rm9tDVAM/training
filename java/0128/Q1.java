/*
① 以下のように、Helloを5回表示するメソッドを作成し、
それをmainメソッドで実行するプログラムを作成せよ

--実行結果--
Hello
Hello
Hello
Hello
Hello
*/
public class Q1{
	public static void main(String[] args){
		printString("Hello");
	}
	public static void printString(String str){
		for(int i=0;i<5;i++){
			System.out.println(str);
		}
	}
}
