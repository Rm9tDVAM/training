public class Lesson1{
	public static void main(String[] args){
		if(args.length>0){
			for(String str:args){
				System.out.println(str);
			}
		}else{
			System.out.println("コマンドライン引数はありません");
		}
	}
}
