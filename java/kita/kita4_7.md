# Question
次のプログラムを作成しなさい。

巨人、阪神戦で毎回の得点を入力する。（１回～９回）
入力が終わったら、それぞれの得点とどちらが勝ったかを表示する。
※ 	試合は巨人の先行とする。
~~~java
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
~~~
# Code
~~~java
  1 import java.util.Scanner;
  2 public class kita4_7{
  3     public static void main(String[] args){
  4         String firstTeam="巨人",secondTeam="阪神";
  5         int[] scores=new int[20];
  6         baseball(firstTeam,secondTeam,scores);
  7         System.out.printf("%s:%d点,%s:%d点%n%sの勝ち%n",
  8                 firstTeam,scores[scores.length-2],secondTeam,scores[scores.length-1],
  9                 scores[scores.length-2]>scores[scores.length-1]?firstTeam:secondTeam);
 10     }
 11     public static void baseball(String team1,String team2,int[] scores){
 12         for(int i=0;i<(scores.length-2)/2;i++){
 13             System.out.printf("%d回表、%sの得点は?",i+1,team1);
 14             scores[i]=new Scanner(System.in).nextInt();
 15             System.out.printf("%d回裏、%sの得点は?",i+1,team2);
 16             scores[i+9]=new Scanner(System.in).nextInt();
 17             scores[scores.length-2]+=scores[i];
 18             scores[scores.length-1]+=scores[i+9];
 19         }
 20     }
 21 }

~~~
# Result
~~~
$ java kita4_7
1回表、巨人の得点は?2
1回裏、阪神の得点は?0
2回表、巨人の得点は?0
2回裏、阪神の得点は?0
3回表、巨人の得点は?2
3回裏、阪神の得点は?1
4回表、巨人の得点は?0
4回裏、阪神の得点は?0
5回表、巨人の得点は?2
5回裏、阪神の得点は?0
6回表、巨人の得点は?0
6回裏、阪神の得点は?0
7回表、巨人の得点は?0
7回裏、阪神の得点は?3
8回表、巨人の得点は?0
8回裏、阪神の得点は?0
9回表、巨人の得点は?0
9回裏、阪神の得点は?3
巨人:6点,阪神:7点
阪神の勝ち
~~~
> Written with [StackEdit](https://stackedit.io/).
