# Regular Expression
## 正規表現の基本文法
1. 通常の文字:その文字でなければならない
	~~~
	String s="java";
	s.matches("Java")	//true
	s.matches("JavaJava")	//false
	s.matches("java")	//false
	~~~
1. ピリオド:任意の1文字あればよい
	~~~
	"Java".matches("J.va")	//true
	~~~
1. アスタリスク:直前の文字の0回以上の繰り返し
	~~~
	"Jaaaaava".matches("Ja*va")	//true
	"あいうxx019".matches(".*")	//true
	~~~
1. 波カッコ:指定回数繰り返し
	|パターン記述|意味|
	|---|---|
	|{n}|直前の文字のn回の繰り返し|
	|{n,}|直前の文字のn回以上の繰り返し|
	|{n,m}|直前の文字のn回以上m回以下の繰り返し|
	|?|直前の文字の0回または1回の繰り返し|
	|+|直前の文字の1回以上の繰り返し|
1. 角カッコ:いずれかの文字  
	"UR[LIN]"というパターンは、「1文字目がU、2文字目がR、3文字目がLかIかNであること」を意味する
1. 角カッコ内のハイフン:指定範囲のいずれかの文字
	~~~
	"url".matches("[a-z]{3}")	//true
	~~~
	定義済みの文字クラスの例
	|パターン記述|意味|
	|---|---|
	|\d|いずれかの数字([0-9]と同じ)|
	|\w|英字・数字・アンダーバー([a-zA-Z_0-9]と同じ)|
	|\s|空白文字(スペース、タブ文字、改行文字など)
1. ハットとダラー:先頭と末尾
	~~~
	^j.*p$
	~~~
	先頭文字がjで、最後の文字がpの任意の長さの文字列を意味する
1. splitメソッド:文字列の分割
	~~~java
	public class Main{
		public static void main(String[] args){
			String s="abc,def:ghi";
			String[] words=s.split("[,:]");
			for(String w:words){
				System.out.print(w+"->");
			}
		}
	}
	~~~
	~~~java
	abc->def->ghi->
	~~~
1. replaceAllメソッド:文字列の置換
	~~~java
	public class Main{
		public static void main(String[] args){
			String s="abc,def:ghi";
			String w=s.replaceAll("[beh]","x");
			System.out.println(w);
		}
	}
	~~~
	~~~java
	aXc,dXf:gXg
	~~~
## Link
[wiki 正規表現.](https://ja.wikipedia.org/wiki/%E6%AD%A3%E8%A6%8F%E8%A1%A8%E7%8F%BE)

