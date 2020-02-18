import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		Random rand=new Random();
		final int PLAYER_NUM=2;
		char suffix='A';
		int[] playerPoints=new int[PLAYER_NUM];
		char[] playerSuffix=new char[PLAYER_NUM];
		for(int i=0;i<PLAYER_NUM;i++){
			playerSuffix[i]=suffix++;
		}
		System.out.print("目標ポイントを設定してください>");
		int goal=scan.nextInt();

		for(int i=0;;i=++i%PLAYER_NUM){
			int startPoint=playerPoints[i];
			System.out.printf("現在のポイント(%d)%n",playerPoints[i]);
			System.out.printf("%n%sのターン%nサイコロを振ります%n",playerSuffix[i]);

			while(true){
				int num=rand.nextInt(6)+1;
				String str="サイコロの目は";
				if(playerPoints[i]==0){
					str="最初の目は";
				}
				System.out.println(str+num);
				if(num==1){
					System.out.printf("残念!ポイントは(%d)に戻った%n",startPoint);
					playerPoints[i]=startPoint;
					break;
				}
				playerPoints[i]+=num;
				if(playerPoints[i]>=goal){

					System.out.printf("%s Win!%n",playerSuffix[i]);
					return;
				}
				System.out.printf("現在のポイント(%d)%n",playerPoints[i]);
				System.out.print("さらにサイコロを振る? 1:振る2:やめとく>");
				int select=scan.nextInt();
				if(select !=1){
					System.out.println("ターン終了");
					break;
				}
			}
		}
	}
}
