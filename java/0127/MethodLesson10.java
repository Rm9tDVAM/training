import java.util.Scanner;
public class MethodLesson10{
	public static void main(String[] args){
		System.out.print("消費税は何%ですか>");
		double tax=new Scanner(System.in).nextDouble();

		double totalPrice=0,taxPrice=0;
		while(true){
			System.out.print("価格を入力(0でお会計)>");
			int price=new Scanner(System.in).nextInt();
			totalPrice+=price;
			taxPrice=totalPrice/tax;
			k
			if(price==0){
				System.out.printf("お買い物合計金額は%.0f円(税込み)です。%n",totalPrice+taxPrice);
				break;
			}
		}
	}
	public static double calcTotalFee(double tax,int price){

	}
}
