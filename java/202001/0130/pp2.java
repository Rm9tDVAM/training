import java.util.Arrays;
import java.util.Random;
public class pp2{
	public static void main(String[] args){
		String[] suits={"♠","♦","♥","♣"};
		String[] numbers={"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] cards=new String[numbers.length*4];
		for(int i=0;i<cards.length;i++){
			cards[i]=suits[i/numbers.length]+numbers[i%numbers.length];
		}
		for(int i=0;i<cards.length;i++){
			System.out.print(cards[i]+" ");
			if(i%numbers.length==numbers.length-1){
				System.out.println();
			}
		}
		for(int i=0;i<cards.length-1;i++){
			int index=new Random().nextInt(cards.length-i);
			String temp=cards[index];
			cards[index]=cards[cards.length-1-i];
			cards[cards.length-1-i]=temp;
		}
		System.out.println();
		/*for(int i=0;i<5;i++){
			int index=new Random().nextInt(cards.length-1);
			System.out.print(cards[i]+" ");
		}*/
		System.out.println(Arrays.toString(cards));
		for(int i=0;i<4;i++){
			for(int j=0;j<4-i;j++){
				String temp1=cards[i].substring(1,cards[i].length());
				String temp2=cards[i+j+1].substring(1,cards[i+j+1].length());
				System.out.println(cardsToInt(temp1));
				System.out.println(cardsToInt(temp2));
				if(cardsToInt(temp1)>cardsToInt(temp2)){
				}
				String temp=cards[i];
				cards[i]=cards[i+j+1];
				cards[i+j+1]=temp;
			}
		System.out.println(Arrays.toString(cards));
				System.out.println();
		}
	}
	public static int cardsToInt(String str){
		switch(str){
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
			case "10":
				int temp=Integer.parseInt(str);
				return temp;
			case "J":
				return 11;
			case "Q":
				return 12;
			case "K":
				return 13;
		}
		return 0;
	}
}
