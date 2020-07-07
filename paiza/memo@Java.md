# memo
~~~java
// List ( add,set,get,size,isEmpty,contains,indexOf )
List<Integer> iList=Arrays.stream(str.split(" "))
    .map(Integer::parseInt)
    .sorted() // 昇順
    .sorted(Comparator.reverseOrder()) // 降順
    .collect(Collectors.toList());
Collections.sort(iList); // 昇順
Collections.reverse(iList); // 逆順
// Map ( put,get,size,isEmpty,containsKey,containsValue,keyset )
Map<key型,value型> xxxMap=new HashMap<>();
// charAt
str.charAt(i)==('char')
str.charAt(str.length()-n); // 後ろからn番文字
// contains
str.contains("String") // 含まれるかboolで返す
// indexOf
str.indexOf("String") // インデックスを返す
// Integer
Integer.parseInt(str,2); // 2-> 10
String str=Integer.toBinaryString(n); // 10-> 2
// Math
Math.ceil(n); // 少数第一位で切り上げ
Math.floor(n); // 少数第一位で切り捨て
Math.round(n); // 小数点第一位で四捨五入
(Math.ceil(a*10))/10; // 小数点第二位で切り上げ
(Math.floor(a*10))/10; // 小数点第二位で切り捨て
(double)(Math.round(a*10))/10; // 小数点第二位で四捨五入
// replace
str.replace("String","String");
str.replaceAll("[^0-9]","");
// substring
str.substring(5,6); // 5文字目
// other
n%100-n%10; // n=999, 90-9=90
((int)(n*(d/100))); // パーセント
(int)(m*((double)n/100)+m); // パーセント
String.valueOf(n).length() // int nのlength
~~~