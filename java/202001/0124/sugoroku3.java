import java.util.Random;
import java.util.Scanner;
public class sugoroku3{
	public static void main(String[] args){
		System.out.print("何人>");
		int input=new Scanner(System.in).nextInt();
		int[] playerTotal=new int[input];
		int[] players=new int[input];
		for(int i=0;i<input;i++){
			players[i]=i+1;
		}
		for(int i=0;i<20;i++){
			for(int j=0;j<input;j++){
				int dice=new Random().nextInt(6)+1;
				playerTotal[j]+=dice;
				System.out.printf("P%d...%d(%d)%n",
						players[j],dice,playerTotal[j]);
				if(playerTotal[j]>20){
					System.out.printf("Overしたので%d戻った%n",
							dice);
					playerTotal[j]-=dice;
				}
				for(int l=0;l<playerTotal[j];l++){
					System.out.print("*");
				}
				if(playerTotal[j]==20){
					System.out.printf("%nGoal! P%d Win!",
							players[j]);
					return;
				}
				for(int l=0;l<19-playerTotal[j];l++){
					System.out.print(" ");
				}
				if(playerTotal[j]<20){
					System.out.print("|");
				}
				new Scanner(System.in).nextLine();
			}
			System.out.println();
		}
	}
}
