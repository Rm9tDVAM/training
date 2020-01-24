import java.util.Scanner;
import java.util.Arrays;
public class MethodLesson8{
	public static void main(String[] args){
		System.out.print("文字を入れてね>");
		String str=new Scanner(System.in).nextLine();
		System.out.println("逆さにしたよ!");
		System.out.println(reverseWord(str));	
	}
	public static String reverseWord(String word){
		char[] str=new char[word.length()];
		for(int i=0;i<word.length();i++){
			str[i]=word.charAt(word.length()-1-i);
		}
		String str2="";
		for(int i=0;i<str.length;i++){
			str2+=str[i];
		}
		return str2;

	}
}
