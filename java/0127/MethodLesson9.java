import java.util.Scanner;
public class MethodLesson9{
	public static void main(String[] args){
		System.out.print("体重を入力してください(kg)>");
		double weight=new Scanner(System.in).nextDouble();
		System.out.print("身長を入力してください(cm)>");
		double height=new Scanner(System.in).nextDouble();
		System.out.printf("体重:%.1fkg,身長:%.1fcmのBMIは%.1fです。",
			weight,height,calcBMI(weight,height));
	}
	public static double calcBMI(double weightKg,double heightCm){
		return weightKg/((heightCm/100)*(heightCm/100));
	}
}
