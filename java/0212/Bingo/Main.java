import java.util.Random;
import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		Random r=new Random();
		System.out.printf("1.Bingo player%n2.Bingo master%n3.Auto1000avg%n>>");
		int select=scan.nextInt();scan.nextLine();
		int[] rArr=new int[75];
		for(int i=0;i<rArr.length;i++){
			rArr[i]=i+1;
		}
		boolean bingo=false;
		Bingo[][] bingoArr=newBingoArr();
		switch(select){
			case 1:
				showBingoArr(bingoArr);
				while(true){
					System.out.print("input number>");
					int input=scan.nextInt();
					bingoGame(bingoArr,input);
					showBingoArr(bingoArr);
					bingo=checkBingo(bingoArr);
					if(bingo==true){
						return;
					}
				}
			case 2:
				int j=0;
				while(true){
					int input=r.nextInt(75-j);
					System.out.println(j+1+" pick up ball is "+rArr[input]);
					bingoGame(bingoArr,rArr[input]);
					rArr[input]=rArr[rArr.length-1-j];
					showBingoArr(bingoArr);
					bingo=checkBingo(bingoArr);
					if(bingo==true){
						return;
					}
					System.out.print("return next>");scan.nextLine();
					j++;
				}
			case 3:
				long start=System.currentTimeMillis();
				int k=0,sumCount=1,trueBingo=0;
				while(trueBingo!=1000){
					int input=r.nextInt(75-k);
					System.out.println(k+1+" pick up ball is "+rArr[input]);
					System.out.println(trueBingo+"bingo");
					bingoGame(bingoArr,rArr[input]);
					rArr[input]=rArr[rArr.length-1-k];
					showBingoArr(bingoArr);
					bingo=checkBingo(bingoArr);
					if(bingo==true){
						for(int i=0;i<rArr.length;i++){
							rArr[i]=i+1;
						}
						bingoArr=newBingoArr();
						sumCount+=k-1;
						k=0;
						trueBingo++;
					}
					k++;
				}
				System.out.println("Bingo Avg="+(sumCount-1)/1000);
				long end=System.currentTimeMillis();
				long diff=end-start;
				System.out.println(diff+"ms");
		}
	}
	public static boolean checkBingo(Bingo[][] bingoArr){
		int count=0,reachCount=0;
		for(int i=0;i<bingoArr.length;i++){
			if(bingoArr[i][i].isHit==true){
				count++;
			}
		}
		if(count==5){
			System.out.println("BINGO!!");
			return true;
		}else if(count==4){
			reachCount++;
		}

		count=0;
		for(int i=0,j=4;i<bingoArr.length;i++,j--){
			if(bingoArr[i][j].isHit==true){
				count++;
			}
		}
		if(count==5){
			System.out.println("BINGO!!");
			return true;
		}else if(count==4){
			reachCount++;
		}

		for(int i=0;i<bingoArr.length;i++){
			count=0;
			for(int j=0;j<bingoArr[i].length;j++){
				if(bingoArr[i][j].isHit==true){
					count++;
				}
			}
			if(count==5){
				System.out.println("BINGO!!");
				return true;
			}else if(count==4){
				reachCount++;
			}
		}

		for(int i=0;i<bingoArr.length;i++){
			count=0;
			for(int j=0;j<bingoArr[i].length;j++){
				if(bingoArr[j][i].isHit==true){
					count++;
				}
			}
			if(count==5){
				System.out.println("BINGO!!");
				return true;
			}else if(count==4){
				reachCount++;
			}
		}

		if(reachCount>8){
			System.out.println("Nine REACH!!");
		}else if(reachCount>7){
			System.out.println("Eight REACH!!");
		}else if(reachCount>6){
			System.out.println("Seven REACH!!");
		}else if(reachCount>5){
			System.out.println("Six REACH!!");
		}else if(reachCount>4){
			System.out.println("Five REACH!!");
		}else if(reachCount>3){
			System.out.println("Four REACH!!");
		}else if(reachCount>2){
			System.out.println("Triple REACH!!");
		}else if(reachCount>1){
			System.out.println("Double REACH!!");
		}else if(reachCount>0){
			System.out.println("REACH!!");
		}else{
		}
		System.out.println();
		return false;
	}
	public static void bingoGame(Bingo[][] bingoArr,int input){
		for(int i=0;i<bingoArr.length;i++){
			for(int j=0;j<bingoArr[i].length;j++){
				if(input==bingoArr[i][j].num){
					bingoArr[i][j].isHit=true;
				}
			}
		}
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
		bingoArr[2][2].isHit=true;
		return bingoArr;
	}
	public static void showBingoArr(Bingo[][] bingoArr){
		for(int i=0;i<bingoArr.length;i++){
			for(int j=0;j<bingoArr[i].length;j++){
				System.out.printf("%3d",bingoArr[j][i].num);
			}
			for(int j=0;j<bingoArr[i].length;j++){
				System.out.printf("%2s",bingoArr[j][i].isHit==true?"O":"-");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void showBingoHit(Bingo[][] bingoArr){
		for(int i=0;i<bingoArr.length;i++){
			for(int j=0;j<bingoArr[i].length;j++){
				System.out.printf("%6s",bingoArr[j][i].isHit);
			}
			System.out.println();
		}
		System.out.println();
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
