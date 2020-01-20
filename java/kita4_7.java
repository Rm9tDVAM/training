import java.util.Scanner;
public class kita4_7{
	public static void main(String[] args){
		int[][] scores=new int[2][9];
		int gScoreSum=0,tScoreSum=0;

		for(int i=0;i<scores[0].length;i++){
			System.out.printf("%d回表、巨人の得点は?>",i+1);
			scores[0][i]=new Scanner(System.in).nextInt();
			
			System.out.printf("%d回表、阪神の得点は?>",i+1);
			scores[1][i]=new Scanner(System.in).nextInt();
		}

		for(int i=0;i<scores[0].length;i++){
			gScoreSum+=scores[0][i];
			tScoreSum+=scores[1][i];
		}

		System.out.printf("巨人:%d点,阪神%d点%n%sの勝ち%n",
				gScoreSum,tScoreSum,gScoreSum>tScoreSum?"巨人":"阪神");
	}
}
