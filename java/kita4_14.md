# Question
練習問題 4 - 14
前の問題に次の修正を加えなさい。

１球ごとにストライク、ボール、ファウルの何れかを入力する。（残念ながらヒットにはなりません）
ファウルの場合、２ストライクまではストライクにカウントするが、３ストライクにはならない。
３ストライクまたは４ボールになったら入力を止め、ストライクとボールのカウントを表示する。
# Code
~~~java 
  3     public static void main(String[] args){
  4         int strike=0, ball=0;
  5         while(strike<3&&ball<4){
  6             System.out.print("ストライク=1, ボール=2, ファウル=3 ?");
  7             int ballCount=new Scanner(System.in).nextInt();
  8             switch(ballCount){
  9                 case 1:
 10                     strike++;
 11                 case 2:
 12                     ball++;
 13                     break;
 14                 case 3:
 15                     if(strike<2){
 16                         strike++;
 17                     }
 18                     break;
 19             }
 20         }
 21         System.out.printf("%dボール, %dストライク",ball,strike);
 22     }
 23 }
~~~
# Result
~~~java
$ java kita4_14
ストライク=1, ボール=2, ファウル=3 ?3
ストライク=1, ボール=2, ファウル=3 ?3
ストライク=1, ボール=2, ファウル=3 ?3
ストライク=1, ボール=2, ファウル=3 ?2
ストライク=1, ボール=2, ファウル=3 ?2
ストライク=1, ボール=2, ファウル=3 ?2
ストライク=1, ボール=2, ファウル=3 ?1
4ボール, 3ストライク
~~~
> Written with [StackEdit](https://stackedit.io/).
