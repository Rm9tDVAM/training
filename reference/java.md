# Java
## import
~~~java
import java.util.\*;//エスケープのバックスラッシュの消し方が？
import java.util.Random;
import java.util.Scanner;
~~~
## 変数の宣言
~~~java
型名 変数名;
型名 変数名=初期値;
~~~
## 定数の宣言
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
- > 左辺が右辺より大きい
- < 左辺が右辺より小さい
- >= 左辺が右辺より大きいか等しい
- <= 左辺が右辺より小さいか等しい
- && かつ`&&で区切られたブロック全てがtrueの場合true`
- || または`||で区切られたブロックのどれかがtrueの場合true`

