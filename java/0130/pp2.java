import java.util.Arrays;
import java.util.Random;
public class pp2{
	public static void main(String[] args){
		String[] suits={"♠","♦","♥","♣"};
		String[] numbers={"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] cards=new String[52];
		for(int i=0;i<cards.length;i++){
			if(i<13){
				cards[i]=suits[0]+numbers[i];
			}else if(i<26){
				cards[i]=suits[1]+numbers[i-13];
			}else if(i<39){
				cards[i]=suits[2]+numbers[i-26];
			}else{
				cards[i]=suits[3]+numbers[i-39];
			}
		}
		for(int i=0;i<cards.length;i++){
			if(i<13){
				System.out.print(cards[i]+" ");
				if(i==12){
					System.out.println();
				}
			}else if(i<26){
				System.out.print(cards[i]+" ");
				if(i==25){
					System.out.println();
				}
			}else if(i<39){
				System.out.print(cards[i]+" ");
				if(i==38){
					System.out.println();
				}
			}else{
				System.out.print(cards[i]+" ");
			}
		}
		for(int i=0;i<cards.length-1;i++){
			int index=new Random().nextInt(cards.length-i);
			String temp=cards[index];
			cards[index]=cards[cards.length-1-i];
			cards[cards.length-1-i]=temp;
		}
		System.out.println();
		for(int i=0;i<5;i++){
			int index=new Random().nextInt(cards.length-1);
			System.out.print(cards[i]+" ");
		}
		String temp=cards[0].substring(1,2);
		int tempInt=Integer.parseInt(temp);
			System.out.println(tempInt);
	}
}
