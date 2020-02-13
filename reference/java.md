# Java
## import
`import java.util.*;`
## 変数(variable)
~~~java
型名 変数名;
型名 変数名=初期値;
~~~
## 定数(constant)
~~~java
final 型名 変数名=初期値;
~~~
> 変数名は全部大文字
## System.out.print and ln
~~~java
System.out.print("Hello World");//改行されない
System.out.println("Hello World");//改行される
~~~
## System.out.printf
~~~java
System.out.printf("%s,%.1f,%s",123,4.5,"あいう");
~~~
- 123,4.5,あいう と表示される
> %d int  
> %f double  
> %s String  
[Joytas.net/System.out.printf()の使い方](https://joytas.net/programming/system-out-printf%e3%81%ae%e4%bd%bf%e3%81%84%e6%96%b9).
## Math.max and min
~~~java
int big=Math.max(num1,num2);
int small=Math.min(num1,num2);
~~~
## Random
~~~java
Random ran=new Random();
int ran=ran.nextInt(100);
~~~
~~~java
int r=new Random().nextInt(100);
~~~
## Scanner
~~~java
Scanner scan=new Scanner(System.in)
int input=scan.nextInt();
~~~
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
## StringをIntに変換する
`temp=Integer.parseInt(strData[i]);`
## 小文字を大文字にする。またはその逆
~~~java
str.toUpperCase();
str.LowerCase();
~~~
## intをStringに変換する
`String intStr=String.valueOf(int);`
## 10進数を2進数(String)に変換する
`String binStr=Integer.toBinaryString(int);`
## 文字列内の文字を文字配列に抽出する
`char[] data=str.toCharArray();`
## 文字列の比較など
1. 変数strの文字数を取得する `str.length()`
1. 変数strとその文字列は等しいか `str.equals("abc")`
1. 変数strがaから始まるか `str.startsWith("a")`
1. 変数strがsで終わるか `str.endsWith("c"`
1. 変数strはその文字(列)を含むか `str.contains("abc")`
1. 変数strのある部分を取得する `String cutStr=str.substring)0,4);`
1. 変数strの最後の一文字を取得する `String cutStr=substring(0,str.length()-1);`
## charをfor文を使ってchar配列に格納する
~~~java
char[] chars=new char[26];
for(int i=0;i<26;i++){
	chars[i]=(char)('a'+i);
}
~~~
> aはユニコードでu0061、bはu0062、cはu0063となるため、インクリメントしていけばa~zまでを表現できる
## 三項条件演算子(三項演算子)
- 条件式?式1:式2
~~~java
big>small?"true":"false"
~~~
## if文 `分岐の制御構文`
条件式がtrueなら中のブロックへ
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
値とcaseが一致したら中のブロックへ
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
条件式がtrueなら中のブロックへ
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
条件式がtrueなら中のブロックへ
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
forのブロックは(初期化処理 ; 繰り返し条件 ; 繰り返し時処理)に分かれている
## 拡張for文 `繰り返しの制御構文`
~~~java
for(int n:配列名){
	処理
}
~~~
1. 配列要素をnに代入
1. 処理
1. 1~2の処理を配列要素が無くなるまで繰り返す
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
- int intArray=new int[3];の場合は3を返す
- インデックス0~2に対し、要素数は3なので注意
#### 配列の中身を出力する
~~~java
System.out.println(Arrays.toString(intArray));
~~~
int[] intArray={10,20,30};の場合は[10,20,30]と出力される
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
- int[][] intArray=new int[2][4];で宣言した場合  
	- intArray.lengthで2を返す  
	- intArray[0].lengthで4を返す
#### 配列の中身を出力する
~~~java
System.out.println(Arrays.deepToString(intArray));
~~~
int[][] intArray={{10,20,30},{40,50,60}};の場合は  
[[10,20,30],[40,50,60]]と出力される
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
## コマンドライン引数
`public static void main(String[] args){`  
プログラム起動時に指定したコマンドライン引数がJVMによって配列に変換され、mainメソッド起動時に渡される。
#### コマンドライン引数を利用したJavaプログラムの起動
`java プログラム名 引数リスト`  
引数リストは()で囲まずに、半角スペースで区切って入力する
## 複数クラスを用いた開発
#### クラスをパッケージに所属させる
	~~~java
	packeage 所属させたいパッケージ名;
	~~~
	package文はソースコードの先頭に記載する必要がある。 パッケージ名は小文字を使用するのが一般的
- デフォルトパッケージ
	- package文がない場合は、「無名パッケージ」もしくは「デフォルトパッケージ」に属していると表現される
- 完全限定クラス名(FQCN:Full Qualified Class Name)
	- パッケージ名.クラス名
## 名前空間
- 新しくクラスを作ると、そのクラス名は使えなくなり、使えるクラス名は減っていく(名前の衝突)
- packageが異なれば、同じクラス名を使ってよい
	- 完全限定クラス名(FQCN)が異なるので区別ができる
## Java API(Application Programming Interface)について
- APIで提供されるパッケージ

	|package name|comment|
	|---|---|
	|java.lang|javaに欠かせない、重要なクラス群|
	|java.util|プログラミングを便利にするさまざまなクラス群|
	|java.math|数学に関するクラス群|
	|java.net|ネットワーク通信などを行うためのクラス群|
	|java.io|ファイル読み書きなど、データを逐次処理するためのクラス群|
	> java.langは頻繁に利用されるのでimport文を記述しなくても自動的にインポートされる  
	> 必要なクラスだけを、必要になったときにロードする
## オブジェクト指向
#### オブジェクト指向の3大機能
- 継承
- 多態性
- カプセル化
#### フィールドの宣言
属性を宣言するにはクラスブロックの中に変数を記述する。
#### クラス名とメンバ名のルール
|対象|品詞|大文字/小文字の用法|例|
|---|---|---|---|
|クラス名|名詞|単語の頭が大文字|Hero,MonsterInfo|
|フィールド名|名詞|最初以外の単語の頭が大文字|level,itemList|
|メソッド名|動詞|最初以外の単語の頭が大文字|attack,findWeakPoint|
#### インスタンスの生成
~~~java
クラス名 変数名=new クラス名();
~~~
#### フィールドへの値の代入
~~~java
変数名.フィールド名=値;
~~~
#### フィールドの初期値

|型名|値|
|---|---|
|int型、short型、long型などの数値の型|0|
|char型(文字)|\u0000|
|boolean型|false|
|int[]型などの配列型|null|
|String型などのクラス型|null|
#### インスタンス利用のまとめ
- インスタンスの生成にはnewを使う。
- フィールドを利用する場合は「変数名.フィールド名」と記述する。
- メソッドを呼び出す場合は「変数名.メソッド名()」と記述する。
#### コンストラクタ
インスタンス生成時に走る初期化処理
- コンストラクタ名はクラス名と同じ。また、戻り値はなし
- オーバーロード可能
#### コンストラクタとみなされる条件
- メソッド名がクラス名と完全に等しい
- メソッド宣言に戻り値が記述されていない(voidもダメ)
#### 暗黙のコンストラクタ
- 全てのクラスはインスタンス化に際して必ず何らかのコンストラクタを実行することになっている。
- クラスに1つもコンストラクタが定義されていない場合に限って、「引数なし、処理内容なし」のコンストラクタ(**デフォルトコンストラクタ**)がコンパイル時に自動実行される。
#### 同一クラス内の別のコンストラクタの呼び出しをJVMに依頼する
~~~java
this(引数);
~~~
#### クラス型と参照
- クラス型変数の中には、「インスタンスの情報が格納されているメモリの先頭番地」が入っている。
- あるクラス型変数を別の変数に代入すると、番地情報だけがコピーされる。
- クラス型は、フィールドの型や、メソッドの引数・戻り値の型としても利用できる
#### static method
class.methodで呼び出して使うメソッド
#### instance method
instanceを生成しないと使用できないメソッド
#### 継承を用いたクラスの定義
~~~java
class クラス名 extends 元となるクラス名{
	親クラスとの「差分」メンバ
}
~~~
#### 継承関係
- 元となるクラス「スーパークラス」「基底クラス」「親クラス」  
- 新たに定義されるクラス「サブクラス」「派生クラス」「子クラス」
#### オーバーライド(override)
親クラスのメンバを子クラス側で上書きすること。
#### アノテーション
- `@Override`とオーバライドするメソッドの上に記述する
- オーバーライド時にメソッド名を間違えているとコンパイラが教えてくれる。また、**明示的にオーバーライドしている**メソッドだと他のプログラマに知らせる事ができる。
#### 継承やオーバーライドの禁止
- クラス宣言にfinalを付けると、継承禁止となる。
- メソッド宣言にfinalを付けると、オーバーライド禁止となる。
#### 継承されたクラスは、より外側のインスタンス部分に属するメソッドが優先的に動作する。
#### 親インスタンス部分のフィールドを利用する
~~~java
super.フィールド名
~~~
#### 親インスタンス部分のメソッドを呼び出す
~~~java
super.メソッド名(引数)
~~~
#### 親コンストラクタの呼び出し
~~~java
super(引数)
~~~
- コンストラクタの先頭に記述する必要がある。
- すべてのコンストラクタは、その先頭で必ず内部インスタンス部分(親クラス)のコンストラクタを呼び出さなければならないという**ルール**になっている。
- コンストラクタの先頭にsuper()がなければ**暗黙的**に「super();」が追加される。
#### is-aの関係
子クラスis-a親クラス(子クラスは、親クラスの一種である)
#### 「未来に備える開発者」の役割
他の開発者が効率よく安心して利用できる継承の材料を作ること。
#### 抽象メソッドを含むクラスの宣言
~~~java
public abstract class クラス名{
}
~~~
#### 詳細未定のメソッド(抽象メソッド)を宣言
~~~java
public abstract 戻り値 メソッド名(引数リスト);
~~~
#### 抽象クラスの制約
抽象クラスは、newによるインスタンス化が禁止されている。
#### インタフェースの宣言
~~~java
public interface インタフェース名{
}
~~~
#### インタフェースとして宣言したCreature
~~~java
public interface Creature{
	public abstract void run();
}
~~~
#### 一般的な書き方をしたCreatureインタフェース
~~~java
public interface Creature{
	void run();
}
~~~
#### インタフェースにおける定数宣言
~~~java
public interface Circle{
	double PI=3.141592;
}
~~~
> 自動的にpublic static finalが補われる
#### インタフェースの実装
~~~java
public class クラス名 implements インタフェース名{
}
~~~
#### 実装(implements)とは  
親インタフェースで未定だった各メソッドをオーバーライドして使えるようにすること
#### インタフェースの効果
1. 同じインタフェースをimplementsする複数の子クラスたちに、共通のメソッド群を実装するよう強制できる。
1. あるクラスがインタフェースを実装していれば、少なくともそのインタフェースが定めたメソッドは持っていることが保証される。
#### クラスにはないインタフェースの特権
異なる実装が衝突する問題が発生しないため、複数の親インタフェースによる多重継承が認められている。
#### インタフェースによる多重継承
~~~java
public class クラス名 implements 親インタフェース名1,親インタフェース名2{
}
~~~
#### インタフェースの継承

|継承元|継承先|使用するキーワード|継承元の数|
|---|---|---|---|
|クラス|クラス|extends|1つ|
|インタフェース|クラス|implements|1つ以上|
|インタフェース|インタフェース|extends|1つ以上|
#### extendsとimplementsの両方を使ったクラス定義
~~~java
public class クラス名 extends 親クラス implements 親インタフェース1,親インタフェース2{
}
~~~
#### 多態性
#### SuperHeroを「ザックリCharacterとして捉える」書き方  
~~~java
Character c=new SuperHero();
~~~
> このときCharacterは箱、中身がSuperHeroと捉えるとわかりやすい
#### 「箱の型」と「中身の型」
- 箱の型 どのメソッドを「呼べるか」を決定する。
- 中身の型 メソッドが呼ばれたら、「どう動くか」を決定する。
#### キャスト演算子で型を変換する
~~~java
Character c=new Wizard();
Wizard w=(Wizard)c;
~~~
あいまいな型に入っている中身を厳密な型に代入するのは**ダウンキャスト**(down cast)という
#### 安全にキャストできるかを判定する
~~~java
変数 instanceof 型名
~~~
> 変数を型名の箱に代入可能ならばtrueが帰る
#### アクセス制御(access control)

||class|package|subclass|all|
|---|:---:|:---:|:---:|:---:|
|public|〇|〇|〇|〇|
|protected|〇|〇|〇|×|
|package private|〇|〇|×|×|
|private|〇|×|×|×|
アクセス修飾子(access modifier)と呼ばれる
#### フィールドのアクセス制御
~~~java
アクセス修飾子 フィールド宣言;
~~~
#### メソッドのアクセス制御
~~~java
アクセス修飾子 メソッド宣言;
~~~
- privateアクセス修飾  
privateであっても自分クラスからthis.~での読み書きは可能
- メンバに関するアクセス修飾の定石
- フィールドはすべてprivate
- メソッドはすべてpublic
- クラスに対するアクセス修飾の定石
特に理由がない限りpublicで修飾するのが一般的
#### getterとsetter
- getterメソッドの定石
~~~java
public フィールドの型 getフィールド名(){
	return this.フィールド名;
}
~~~
- setterメソッドの定石
~~~java
public void setフィールド名(フィールドの型 任意の変数名){
	this.フィールド名=任意の変数名;
}
~~~
- getter/setterの存在価値
1. Read Only、Write Onlyのフィールドを実現できる
1. フィールドの名前など、クラスの内部設計を自由に変更できる
1. フィールドへのアクセスを検査できる
- 非publicクラスの特徴
1. クラスの名前はソースファイル名と異なってもよい。
1. 1つのソースファイルにクラスを複数宣言してもよい。
- さまざまなデータ構造
1. List(順序どおりに並べて格納する)
1. Set(順序があるとは限らない
1. Map(ペアで対応付けて格納する)
- コレクションにはできないこと  
コレクションには、基本データ型の情報を格納することができない。
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
## カンマ区切りの文字列をカンマで区切ってstr配列に格納する
~~~java
public class strToArr{
	public static void main(String[] args){
		String str="リンゴ,ゴリラ,ラッパ";
		String[] data=str.split(",");
		System.out.println(Arrays.toString(data));
	}
}
~~~
## 表記ゆれのある文字列を区切ってstr配列に格納する
~~~java
public class strToArr{
	public static void main(String[] args){
		String str="Mac,Win、Linux";
		String[] data=str.split("[,、]");
		System.out.println(Arrays.toString(data));
	}
}
~~~
> [,、]は正規表現、「,」「、」が一致対象
## カンマ区切りの文字列数字を配列に格納してから合計する
~~~java
public class strintSum{
	public static void main(String[] args){
		String str="3,5,7,19";
		int[] dataInt;
		String[] data=str.split(",");
		dataInt=new int[data.length];
		for(int i=0;i<data.length;i++){
			int temp=0;
			temp=Integer.parseInt(data[i]);
			dataInt[i]=temp;
		}
		int sum=0;
		for(int n:dataInt){
			sum+=n;
		}
		System.out.print("合計は"+sum);
	}
}
~~~
## 文字列を置換する
~~~java
import java.util.Scanner;
public class Lesson3{
	public static void main(String[] args){
		String word=new Scanner(System.in).next();
		String word2=word.replaceAll("[aiueo]","");
		System.out.println(word2);
	}
}
~~~
> replaceAllは前のブロックで一致したら後ろのブロックと置き換える
>> [aiueo]は正規表現、「a」「i」「u」「e」「o」が一致対象
## 時間計測
~~~java
public class timeCount{
	public static void main(String[] args) throws Exception{
		long start=System.currentTimeMillis();
		Thread.sleep(3000);
		long end=System.currentTimeMillis();
		long diff=end-start;
		System.out.println(diff);
	}
}
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
## リンク
[Java(tm) Platform, Standard Edition 8 API仕様](https://docs.oracle.com/javase/jp/8/docs/api/).  
[splitでJavaの文字列を分割しよう! 良く使うサンプル付き!](https://engineer-club.jp/java-split).
[デザインパターン](https://www.techscore.com/tech/DesignPattern/index.html/).  
[Gang of Fourデザインパターン学習](https://qiita.com/takumi0619/items/03986742efbb7e3a9bbe).
## おまけ
; セミコロン  
\: コロン  
. ピリオド  
, カンマ  
1+5 オペランド 演算子 オペランド  
リテラル(literal)ソースコードに記述されている具体
