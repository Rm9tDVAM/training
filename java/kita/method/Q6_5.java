/*
練習問題 6 - 5
サイズを示す数値と、表示する文字を引数とし、三角形を表示するメソッドを作成しなさい。
このメソッドを使用して、サイズと文字の異なる３つの三角形を表示しなさい。
※ 	サイズを示す引数は int 型、表示する文字の引数は char 型にする。

output
$ java Q6_5
#
##
###

$
$$
$$$
$$$$
$$$$$

&
&&
&&&
&&&&
&&&&&
&&&&&&
&&&&&&&
*/
	public class Q6_5{
	public static void main(String[] args){
		printChar(3,'#');
		printChar(5,'$');
		printChar(7,'&');
	}
	public static void printChar(int num,char printChar){
		for(int i=0;i<num;i++){
			for(int j=0;j<i+1;j++){
				System.out.print(printChar);
			}
			System.out.println();
		}
		System.out.println();
	}
}
