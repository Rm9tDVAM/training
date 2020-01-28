import java.util.*;
public class Lesson1{
	public static void main(String[] input){
		if (input.length==0){
			System.out.println("引数にメンバーを入れてもう一度実行してください。");
			return;
		}

		String[] member;
		if (input.length%2!=0){
			member=new String[input.length+1];
			for(int i=0;i<input.length;i++){
				member[i]=input[i];
			}
			member[member.length-1]="先生";
		}else {
			member=input;
		}

		for (int i=0;i<member.length-1;i++){
			int index=new Random().nextInt(member.length-i);
			String temp=member[index];
			member[index]=member[member.length-1-i];
			member[member.length-1-i]=temp;
		}

		for (int i=0;i<member.length;i+=2){
			System.out.printf("{N.%s,D.%s}%n",member[i],member[i+1]);
		}
	}
}
