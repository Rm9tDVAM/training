import java.util.*;
public class Main{
	public static void main(String[] args){
		String s1="Java and JavaScript";
		if(s1.contains("Java")){
			sop("含まれています");
		}
		String s2=s1.substring(0,4);
		sop(s2);
		String s3=s1.substring(5,8);
		sop(s3);
		sop(100);

		StringBuilder sb=new StringBuilder();
		sb.append("Hello");
		sb.append(" World");
		sb.append(System.lineSeparator());
		sb.append("Bye!");
		sop(sb);

		String name="B334890Z";
		if(isValidPlayerName(name)){
			sop(name+"はOK");
		}
		String s4=name.replaceAll("\\d","*");
		sop(s4);

		int s5=sumOf(10,20,30,40,50);
		sop(s5);

		Object[] s6=createArr("あ",2,3,4,5);
		System.out.println(Arrays.toString(s6));
	}
	static void sop(Object o){
		System.out.println(o);
	}
	static boolean isValidPlayerName(String name){
		return name.matches("[A-Z][A-Z0-9]{7}");
	}
	static int sumOf(int a,int b,int... nums){
		int sum=a+b;
		for(int n:nums){
			sum+=n;
		}
		return sum;
	}
	static Object[] createArr(Object... nums){
		return nums;
	}
}
