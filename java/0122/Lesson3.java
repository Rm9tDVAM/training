import java.util.Scanner;
public class Lesson3{
	public static void main(String[] args){
		System.out.print("数値を入力してください>");
		int a=new Scanner(System.in).nextInt();
		multiNum(a);
		System.out.printf("a=%d\n",a);
		System.out.println("値渡しはもともとの引数には影響しません。");
	}
	public static void multiNum(int num){
		System.out.printf("%dを2倍にします\n",num);
		num=num*2;
		System.out.printf("%dになりました。\n",num);
	}
}
