public class Lesson2{
	public static void main(String[] args){
		method(10,20);
	}
	public static int method(int x,int y){
	}
	//シグネチャが同じなので不可(戻り値は関係ない)
	public static void method(int x, int y){
	}
	//引数名は関係ないので不可
	public static void method(int a,int b){
	}
	//シグネチャが違うのでオーバーロードできる
	public static int method(int a,int b,int c){
	}

	public static void methodB(String str,int a){
	}
	//シグネチャが同じなので不可
	public static void methodB(String s,int x){
	}
	//シグネチャが違うのでOK
	public static void methodB(int x,String str){
	}
}
