import java.util.Scanner;
public class kita4_14{
	public static void main(String[] args){
		int strike=0, ball=0;
		while(strike<3&&ball<4){
			System.out.print("ストライク=1, ボール=2, ファウル=3 ?");
			int ballCount=new Scanner(System.in).nextInt();
			switch(ballCount){
				case 1:
					strike++;
				case 2:
					ball++;
					break;
				case 3:
					if(strike<2){
						strike++;
					}
					break;
			}
		}
		System.out.printf("%dボール, %dストライク",ball,strike);
	}
}
