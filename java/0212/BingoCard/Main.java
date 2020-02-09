import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Bingo[][] bingoArr=newBingoArr();
		showBingoArr(bingoArr);
	}

	public static Bingo[][] newBingoArr(){
		Random ran=new Random();
		Bingo[][] bingoArr=new Bingo[5][5];
		int [][] intArr=new int[5][15];
		for(int i=0,num=1;i<intArr.length;i++){
			for(int j=0;j<intArr[i].length;j++,num++){
				intArr[i][j]=num;
			}
		}

		for(int i=0;i<bingoArr.length;i++){
			for(int j=0,temp;j<bingoArr[i].length;j++){
				temp=ran.nextInt(15-j);
				Bingo bin=new Bingo(false,intArr[i][temp]);
				intArr[i][temp]=intArr[i][intArr[i].length-1-j];
				bingoArr[i][j]=bin;
			}
		}
		bingoArr[2][2].num=0;
		return bingoArr;
	}
	public static void showBingoArr(Bingo[][] bingoArr){
		for(int i=0;i<bingoArr.length;i++){
			for(int j=0;j<bingoArr[i].length;j++){
				System.out.printf("%3d",bingoArr[j][i].num);
			}
			System.out.println();
		}
	}
} 
class Bingo{
	boolean isHit;
	int num;
	Bingo(boolean isHit,int num){
		this.isHit=isHit;
		this.num=num;
	}
}
