# Java
## import
~~~java
import java.util.\*;//エスケープのバックスラッシュの消し方が？
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
## 逆引き条件式
1. 偶数 `10/2==0`
1. 奇数 `5/2!=0`
1. 倍数 `9%3==0`
## 文字列の比較など
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
