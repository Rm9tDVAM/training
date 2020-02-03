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
