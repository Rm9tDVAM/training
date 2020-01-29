# Java
## import
~~~java
import java.util.\*;
import java.util.Random;
import java.util.Scanner;
~~~
## 変数(variable)
~~~java
型名 変数名;
型名 変数名=初期値;
~~~
## 定数(constant)
~~~java
final 型名 変数名=初期値;
~~~
## System.out.print and ln
~~~java
System.out.print("Hello World");//改行されない
System.out.println("Hello World");//改行される
~~~
## System.out.printf
~~~java
System.out.printf("%s,%.1f,%s",123,4.5,"あいう");
~~~
> 123,4.5,あいう と表示される
>> %d int  
>> %f double  
>> %s String  
[Joytas.net/System.out.printf()の使い方](https://joytas.net/programming/system-out-printf%e3%81%ae%e4%bd%bf%e3%81%84%e6%96%b9).
## Math.max and min
~~~java
int big=Math.max(num1,num2);
int small=Math.min(num1,num2);
~~~
## Random
~~~java
int r=new Random().nextInt(100);
~~~
## Scanner
~~~java
int inputInt=new Scanner(System.in).nextInt();
~~~
~~~java
String inputStr=new Scanner(System.in).nextLine();
~~~
## 演算子(operator)
- 加算 +
- 減算 -
- 乗算 *
- 除算 /
- 余剰 %
## 条件式
- == 左辺と右辺が等しい
- != 左辺と右辺が異なる
- \> 左辺が右辺より大きい
- < 左辺が右辺より小さい
- \>= 左辺が右辺より大きいか等しい
- <= 左辺が右辺より小さいか等しい
- && かつ `&&で区切られたブロック全てがtrueの場合true`
- || または `||で区切られたブロックのどれかがtrueの場合true`
- 偶数 `10%2==0`
- 奇数 `5%2!=0`
- 倍数 `9%3==0`
## 文字列の比較など
1. 変数strの文字数を取得する `str.length()`
1. 変数strとその文字列は等しいか `str.equals("abc")`
1. 変数strがaから始まるか `str.startsWith("a")`
1. 変数strがsで終わるか `str.endsWith("c"`
1. 変数strはその文字(列)を含むか `str.contains("abc")`
1. 変数strのある部分を取得する `String cutStr=str.substring)0,4);`
1. 変数strの最後の一文字を取得する `String cutStr=substring(0,str.length()-1);`
## 三項条件演算子(三項演算子)
- 条件式?式1:式2
~~~java
big>small?"true":"false"
~~~
## if文 `分岐の制御構文`
> 条件式がtrueなら中のブロックへ
~~~java
if(条件式){
	処理
}else if(条件式){
	処理
}else{
	処理
}
~~~
## switch文 `分岐の制御構文`
> 値とcaseが一致したら中のブロックへ
~~~java
switch(条件式){
	case 1:
		処理
		break;
	case 2:
		処理
		break;
}
~~~
## while文 `繰り返しの制御構文`
> 条件式がtrueなら中のブロックへ
~~~java
while(条件式){
	if(条件式){
		処理
		break;
	}else{
		処理
	}	
}
~~~
## do while文 `繰り返しの制御構文`
> 条件式がtrueなら中のブロックへ
~~~java
do{
	処理
}while(条件式);
~~~
## for文 `繰り返しの制御構文`
~~~java
for(int i=0;i<10;i++){
	処理
}
~~~
> forのブロックは(初期化処理 ; 繰り返し条件 ; 繰り返し時処理)に分かれている
## 拡張for文 `繰り返しの制御構文`
~~~java
for(int n:配列名){
	処理
}
~~~
>1. 配列要素をnに代入
>1. 処理
>1. 1~2の処理を配列要素が無くなるまで繰り返す
## 配列
#### 宣言
~~~java
型名[] 配列名;
配列名[]=new 型名[配列の長さ];
型名[] 配列名=new 型名[配列の長さ];
~~~
~~~java
int[] intArray;
intArray=new int[3];
int[] intArray=new int[3];
~~~
#### 代入
~~~java
配列名[インデックス]=値;
~~~
~~~java
intArray[0]=10;
intArray[0]=20;
intArray[0]=30;
~~~
#### 宣言して代入
~~~java
型名[] 配列名={10,20,30};
~~~
~~~java
int[] intArray={10,20,30};
~~~
#### 要素数の取得
~~~java
intArray.length
~~~
> int intArray=new int[3];の場合は3を返す
>> インデックス0~2に対し、要素数は3なので注意
#### 配列の中身を出力する
~~~java
System.out.println(Arrays.toString(intArray));
~~~
> int[] intArray={10,20,30};の場合は[10,20,30]と出力される
## 二次元配列
#### 二次元配列の宣言
~~~java
型名[][] 配列名;
配列名=new 型名[配列の長さ][配列の長さ]
型名[][] 配列名=new 型名[配列の長さ][配列の長さ];
~~~
~~~java
int[][] intArray;
intArray[][]=new int[3][3];
int[][] intArray=new int[3][3];
~~~
| |0|1|2|
|-|-|-|-|
|0|00|01|02|
|1|10|11|12|
|2|20|21|22|
#### 二次元配列に値を代入
~~~java
配列名[インデックス][インデックス]=値;
~~~
~~~java
intArray[0][0]=10;
intArray[1][0]=20;
intArray[2][0]=30;
~~~
| |0|1|2|
|-|-|-|-|
|0|10|00|00|
|1|20|00|00|
|2|30|00|00|
#### 宣言して代入
~~~java
型名[][] 配列名={{10,20,30},{40,50,60}};
~~~
~~~java
int[][] intArray={{10,20,30},{40,50,60}};
~~~
#### 要素数の取得
~~~java
intArray.length
intArray[].length
~~~
> int[][] intArray=new int[2][4];で宣言した場合  
> intArray.lengthで2を返す  
> intArray[0].lengthで4を返す
## 二次元ジャグ配列
#### 二次元ジャグ配列の宣言
~~~java
int[][] intArray=new int[2][];
intArray[0]=new int[3];
intArray[1]=new int[6];
~~~
| |0|1|2|3|4|5|
|-|-|-|-|-|-|-|
|0|00|01|02|
|1|10|11|12|13|14|15|
## メソッド
#### メソッド利用によるメリット
- プログラムの見通しがよくなり、全体を把握しやすくなる。
- 機能単位に記述するため、修正範囲を限定できる。
- 同じ処理を1つのメソッドにまとめることで、作業効率が上がる。
#### ローカル変数の独立性
- 異なるメソッドに属するローカル変数は、お互いに独立していて無関係である。
#### オーバーロード
仮引数の個数か型が異なれば、同じ名前のメソッドを複数定義できる。
引数は同じで、戻り値の型だけが異なるものは定義できない。
#### メソッドの定義
~~~java
public static 戻り値の型 メソッド名(引数リスト){
	メソッドが呼び出されたときに実行される具体的な処理
}
~~~
~~~java
public static voi hello(){
	System.out.println("湊さん、こんにちは");
}
~~~
#### 引数の渡し方
~~~
何も渡さない場合：メソッド名()
値を1つ渡す場合：メソッド名(値)
値を複数渡す場合：メソッド名(値,値)
値には、変数名を指定することもできる。
~~~
~~~java
public class Main{
	public static void main(String[] args){
		System.out.println("メソッドを呼び出します");
		hello("湊");
		hello("朝香");
		hello("菅原");
		System.out.println("メソッドの呼び出しが終わりました");
	}
	public static void hello(String name){
		System.out.println(name+"さん、こんにちは");
	}
}
~~~
#### 値の戻し方
~~~java
public static 戻り値の型 メソッド名(引数リスト){
	メソッドが実行されたときに動く処理
	return 戻り値;
}
~~~
#### メソッドの呼び出し、戻り値を受け取る
~~~
型 変数名=メソッド名(引数リスト);
~~~
~~~java
public class Main{
	public static int add(int x,int y){
		return x+y;
	}
	public static void main(String[] args){
		System.out.println("100+10="+add(100,10));
	}
}
~~~
#### 引数に配列を受け取るメソッドの利用
~~~java
public class Code5_12{
	public static void printArray(int[] array){
		for(int element:array){
			System.out.println(element);
		}
	}
	public static void main(String[] args){
		int[] array={1,2,3};
		printArray(array);
	}
}
~~~
~~~
$ java Code5_12
1
2
3
~~~
#### 基本型の変数をメソッド呼び出しで渡すと
- 呼び出し元の変数の内容が、呼び出し先にコピーされる。
- 呼び出し先で引数の内容を書き換えても、呼び出し元の変数は変化しない。
#### 配列をメソッド呼び出しで渡すと
- 呼び出し元の配列のアドレスが、呼び出し先の引数にコピーされる。
- 呼び出し先で配列の実体を書き換えると、呼び出し元にも影響する。
~~~java
public class Code5_13{
	public static void intArray(int[] array){
		for(int i=0;i<array.length;i++){
			array[i]++;
		}
	}
	public static void main(String[] args){
		int[] array={1,2,3};
		intArray(array);
		for(int i:array){
			System.out.println(i);
		}
	}
}
~~~
~~~
$ java Code5_13
2
3
4
~~~
#### コマンドライン引数
`public static void main(String[] args){`  
プログラム起動時に指定したコマンドライン引数がJVMによって配列に変換され、mainメソッド起動時に渡される。
#### コマンドライン引数を利用したJavaプログラムの起動
`java プログラム名 引数リスト`  
> 引数リストは()で囲まずに、半角スペースで区切って入力する
#### 複数クラスを用いた開発
- 1つのプログラムを複数の部品に分けることを部品化という
- Javaプログラムの完成品
	- Javaプログラムの完成品は、複数のクラスファイルの集合体。
	- 誰かに配布する場合には、すべてのクラスファイルを渡す必要がある。
- クラスをパッケージに所属させる
	- packeage 所属させたいパッケージ名;
		> package文はソースコードの先頭に記載する必要がある。 パッケージ名は小文字を使用するのが一般的
- デフォルトパッケージ
	- package文がない場合は、「無名パッケージ」もしくは「デフォルトパッケージ」に属していると表現される
- 完全限定クラス名(FQCN:Full Qualified Class Name)
	- パッケージ名.クラス名
#### 名前空間
- 新しくクラスを作ると、そのクラス名は使えなくなり、使えるクラス名は減っていく(名前の衝突)
- packageが異なれば、同じクラス名を使ってよい
> 完全限定クラス名(FQCN)が異なるので区別ができる
	> packageを使うことによって、それぞれのpackage内では自由にクラス名をつけることが可能になる
## sleepで処理を一時停止させる
`public static void sleep(long millis)`
~~~java
public class sleep{
	public static void showMondokoro() throws Exception{
		Thread.sleep(3000);
	}
}
~~~
> 単位ははミリ秒(3000=3秒)
>> sleepメソッドを使う場合は例外処理が必要
## キー入力があるまでコンソールの出力を止める
~~~java
new Scanner(System.in).nextLine();
~~~
> Enterが読み込まれるので注意する
## 配列のインデックスを循環させる
~~~java
public class loopIndex{
  public static void main(String[] args){
    int[] array={1,2,3};
    for(int i=0;i<10;i++){
      System.out.println(array[i%array.length]);
    }
  }
}
~~~
~~~
$ java loopIndex
1
2
3
1
2
3
1
2
3
1
~~~
## 配列を昇順に並び替える(sort)
~~~java
public class sort{
	public static void main(String[] args){
		int[] array={6,2,10,4,8};
		for(int i=0;i<array.length-1;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i] > array[j]){
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		for(int n:array){
			System.out.println(n);
		}
	}
}
~~~
## 配列を逆順に並びかえる(reverse)
~~~java
public class reverse{
	public static void main(String[] args){
		int[] array={1,2,3,4,5};
		for(int i=0;i<array.length/2;i++){
			int temp=array[i];
			array[i]=array[array.length-1-i];
			array[array.length-1-i]=temp;
		}
		for(int n:array){
			System.out.println(n);
		}
	}
}
~~~
## 配列をランダムに並びかえる(shuffle)
~~~java
import java.util.Arrays;
import java.util.Random;
public class shuffle{
	public static void main(String[] args){
		int[] array={1,2,3,4,5};
		for(int i=0;i<array.length-1;i++){
			int index=new Random().nextInt(array.length-i);
			int temp=array[index];
			array[index]=array[array.length-1-i];
			array[array.length-1-i]=temp;
		}
		System.out.println(Arrays.toString(array));
	}
}
~~~
## インプットした4桁を降順に並び替える(reverse)
~~~java
import java.util.Scanner;
public class reverse{
	public static void main(String[] args){
		System.out.print("4桁の数字>");
		int num=new Scanner(System.in).nextInt();
		for(int i=0;i<4;i++){
			System.out.println(num%10);
			num/=10;
		}
	}
}
~~~
>1234と入力した場合は4321の順で表示される
## 文字列をさかさまにする
[Joytas.net/day21](https://joytas.net/%e8%a8%93%e7%b7%b4/day21).
~~~java
public class reverseWord{
  public static void main(String[] args){
    String Word="abcde";
    String str="";
    for(int i=Word.length()-1;i>=0;i--){
      str+=Word.charAt(i);
    }
    System.out.println(str);
  }
}
~~~
~~~
$ java reverseWord
edcba
~~~
## 入力した秒からhh:mm:ssを求める
~~~java
import java.util.Scanner;
public class secondTo{
	public static void main(String[] args){
		System.out.print("秒を入力>");
		int second=new Scanner(System.in).nextInt();
		int hour=second/3600;
		int minute=second%3600/60;
		int rSecond=second%60;
		System.out.printf("%02d:%02d:%02d%n",hour,minute,rSecond);
	}
}
~~~
## 知識として
1. ラベル付きブレイク
	- break outerでouter:whileに抜けることができる
1. ASC Order(アセンディング、昇順)
1. DESC Order(ディセンディング、降順)
1. scan.close();
	- newで確保したメモリを明示的に開放する
1. System.exit(0);
	- アプリ強制終了(0は正常終了)
## おまけ
; セミコロン  
\: コロン  
. ピリオド  
, カンマ  
1+5 オペランド 演算子 オペランド  
リテラル(literal)ソースコードに記述されている具体
