/*
練習問題 6 - 7
ある数が素数かどうかを判定するメソッドを作成しなさい。
このメソッドを使用して 10000 以上 10100 未満の素数をすべて表示するプログラムを作成しなさい。

output
$ java Q6_7
10007
10009
10037
10039
10061
10067
10069
10079
10091
10093
10099
*/
public class Q6_7{
	public static void main(String[] args){
		for(int i=10000;i<10100;i++){
			if(judgeNum(i)){
				System.out.println(i);
			}
		}
	}
	public static boolean judgeNum(int n){
		for(int i=2;i<n;i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
}
