import java.util.*;
public class Main {
	static final int MIN_NUM=1,MAX_NUM=5;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		//comの番号配列を宣言{0,0,0,0,0}
		int[] comNums=new int[MAX_NUM-MIN_NUM+1];
		//comの番号配列に中身を入れる{3,2,5,1,4}
		init(comNums);
		//プレイヤーの出した数字を格納していくリスト
		List<Integer> playerNums=new ArrayList<>();
		int win=0,lose=0;
		/***メインルーチン***/
		for(int i=0;i<comNums.length;i++){
			//正常な値が入るまで回るループ
			while(true){
				System.out.printf("%d回戦目。%d~%dの数字を入力>",i+1,MIN_NUM,MAX_NUM);
				int num=scan.nextInt();
				if(checkNum(playerNums,num)){
					//正常な値だった場合にリストに加える
					playerNums.add(num);
					break;
				}
			}
			System.out.println("PCの数字:"+comNums[i]);
			if(playerNums.get(i)>comNums[i]){
				System.out.println("あなたの勝ち");
				win++;
			}else if(playerNums.get(i)<comNums[i]){
				System.out.println("あなたの負け");
				lose++;
			}else{
				System.out.println("引き分け");
			}
		}
		String result;
		if(win>lose){
			result="あなたの勝ち";
		}else if(win<lose){
			result="あなたの負け";
		}else{
			result="引き分け";
		}
		System.out.printf("%d対%dで%s%n",win,lose,result);
	}
	//配列をシャッフルするメソッド
	static void shuffleArr(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			int index=new Random().nextInt(arr.length-i);
			int temp=arr[index];
			arr[index]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
		}
	}
	//comの番号配列を生成
	static void init(int[] comsNum){
		for(int i=0;i<MAX_NUM-MIN_NUM+1;i++){
			comsNum[i]=MIN_NUM+i;
		}
		shuffleArr(comsNum);
		//System.out.println(Arrays.toString(comsNum));
	}
	//プレイヤーの入力した数字が不正でないかをチェックするメソッド
	static boolean checkNum(List<Integer> list,int num){
		//最小値より小さいまたは最大値より大きい場合はfalse
		if(num<MIN_NUM || num>MAX_NUM){
			System.out.printf("%d~%dの数字を入力してください%n",MIN_NUM,MAX_NUM);
			return false;
		}
		//一度使った数字をもう一度使おうとしたらfalse
		if(list.contains(num)){
			System.out.println("一度使った数字は使えません");
			return false;
		}
		return true;
	}
}
