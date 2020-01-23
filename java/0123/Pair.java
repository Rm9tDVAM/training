import java.util.*;
public class Pair{
	public static void main(String[] args){
		System.out.print("何人?>");
		int howMany=new Scanner(System.in).nextInt();
		int[] players=new int[howMany];
		int[] card=new int[53];
		for(int i=0;i<card.length;i++){
			card[i]=i+1;
		}
		for(int i=0;i<players.length;i++){
			players[i]=i+1;
		}
		int cardCount=1;
		for(int i=0;i<players.length;i++){
			for(int j=0;j<card.length-1;j++){
				int index=new Random().nextInt(card.length-j);
				int temp=card[index];
				card[index]=card[card.length-1-j];
				card[card.length-1-j]=temp;
			}
			if(cardCount!=1){
				System.out.println("<カードを戻しシャッフルしました>");
			}
			int k=0,playersCount=0;
			while(true){
				if(card[k]==53){
					System.out.printf("%d枚目でPlayer%dが脱落しました%n"
							,cardCount,players[playersCount]);
				break;
				}
				k++;
				cardCount++;
				if(playersCount<players.length-1-i){
					playersCount++;
				}else{
					playersCount=0;
				}
			}
			int temp=players[playersCount];
			players[playersCount]=players[players.length-1-i];
			players[players.length-1-i]=temp;
			System.out.println(Arrays.toString(players));
		}
		System.out.println("優勝賞金"+cardCount+"万円");
	}
}
