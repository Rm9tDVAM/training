import java.util.Scanner;
public class kita4_7{
	public static void main(String[] args){
		String firstTeam="巨人",secondTeam="阪神";
		int[] scores=new int[20];
		baseball(firstTeam,secondTeam,scores);
		System.out.printf("%s:%d点,%s:%d点%n%sの勝ち%n",
				firstTeam,scores[scores.length-2],secondTeam,scores[scores.length-1],
				scores[scores.length-2]>scores[scores.length-1]?firstTeam:secondTeam);
	}
	public static void baseball(String team1,String team2,int[] scores){
		for(int i=0;i<(scores.length-2)/2;i++){
			System.out.printf("%d回表、%sの得点は?",i+1,team1);
			scores[i]=new Scanner(System.in).nextInt();
			System.out.printf("%d回裏、%sの得点は?",i+1,team2);
			scores[i+9]=new Scanner(System.in).nextInt();
			scores[scores.length-2]+=scores[i];
			scores[scores.length-1]+=scores[i+9];
		}
	}
}
