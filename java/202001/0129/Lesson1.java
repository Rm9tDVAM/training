/*
下の図のように、今日の日付とある人の生年月日を入力すると、その人が現在何歳かを表示する。
 
【実行画面】
今日の年は？＞2012【enterキー】
今日の月は？＞4【enterキー】
今日の日は？＞16【enterキー】
誕生日の年は？＞1976【enterキー】
誕生日の月は？＞6【enterキー】
誕生日の日は？＞12【enterキー】
あなたの年齢は35歳です。
*/
import java.util.Scanner;
public class Lesson1{
	public static void main(String[] args){
		System.out.print("今日の年は?>");
		int year=new Scanner(System.in).nextInt();
		System.out.print("今日の月は?>");
		int month=new Scanner(System.in).nextInt();
		System.out.print("今日の日は?>");
		int day=new Scanner(System.in).nextInt();
		System.out.print("誕生日の年は?>");
		int birthYear=new Scanner(System.in).nextInt();
		System.out.print("誕生日の月は?>");
		int birthMonth=new Scanner(System.in).nextInt();
		System.out.print("誕生日の日は?>");
		int birthDay=new Scanner(System.in).nextInt();

		int old=birthYear-year;
		if(month<=birthMonth&&day<=birthDay){
			System.out.printf("あなたの年齢は%d歳です",old);
		}else{
			System.out.printf("あなたの年齢は%d歳です",old-1);
		}
	}
}

