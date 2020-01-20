#### Question
次のプログラムを作成しなさい。

巨人、阪神戦で毎回の得点を入力する。（１回～９回）
入力が終わったら、それぞれの得点とどちらが勝ったかを表示する。
※ 	試合は巨人の先行とする。
1回表、巨人の得点は？ 0
1回裏、阪神の得点は？ 0
2回表、巨人の得点は？ 0
2回裏、阪神の得点は？ 1
    ：
    ：
    ：
9回表、巨人の得点は？ 0
9回裏、阪神の得点は？ 1

巨人：5点, 阪神：6点
阪神の勝ち
#### Code
~~~java
  1 import java.util.Scanner;
  2 public class kita4_7{
  3     public static void main(String[] args){
  4         int[][] scores=new int[2][9];
  5         int gScoreSum=0,tScoreSum=0;
  6
  7         for(int i=0;i<scores[0].length;i++){
  8             System.out.printf("%d回表、巨人の得点は?>",i+1);
  9             scores[0][i]=new Scanner(System.in).nextInt();
 10
 11             System.out.printf("%d回表、阪神の得点は?>",i+1);
 12             scores[1][i]=new Scanner(System.in).nextInt();
 13         }
 14
 15         for(int i=0;i<scores[0].length;i++){
 16             gScoreSum+=scores[0][i];
 17             tScoreSum+=scores[1][i];
 18         }
 19
 20         System.out.printf("巨人:%d点,阪神%d点%n%sの勝ち%n",
 21                 gScoreSum,tScoreSum,gScoreSum>tScoreSum?"巨人":"阪神");
 22     }
 23 }

~~~
#### Result
~~~
$ java kita4_7
1回表、巨人の得点は?>2
1回表、阪神の得点は?>0
2回表、巨人の得点は?>0
2回表、阪神の得点は?>0
3回表、巨人の得点は?>2
3回表、阪神の得点は?>1
4回表、巨人の得点は?>0
4回表、阪神の得点は?>0
5回表、巨人の得点は?>0
5回表、阪神の得点は?>3
6回表、巨人の得点は?>0
6回表、阪神の得点は?>0
7回表、巨人の得点は?>2
7回表、阪神の得点は?>0
8回表、巨人の得点は?>0
8回表、阪神の得点は?>0
9回表、巨人の得点は?>0
9回表、阪神の得点は?>3
巨人:6点,阪神7点
阪神の勝ち
~~~
> Written with [StackEdit](https://stackedit.io/).
