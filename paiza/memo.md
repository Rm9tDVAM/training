# memo
~~~java
List<型> xxxList=new ArrayList<>(); // add,set,get,size,isEmpty,contains,indexOf
Map<key型,value型> xxxMap=new HashMap<>(); // put,get,size,isEmpty,containsKey,containsValue,keyset()
((int)(n*(d/100))); // パーセント
if(str.charAt(i)==('char')){}
if(str.contains("String")){} // 含まれるかboolで返す
if(str.indexOf("String")){} // インデックスを返す
String intStr=str.replaceAll("[^0-9]","");
str=str.replace("String","String");
String[] strArray=str.split(" ");
StringBuilder sb=new StringBuilder();
Integer.parseInt(str,2); // 2-> 10
for(){Integer.parseInt(str.substring(i,i+1))} // str-> int 
Math.round(n); // 小数点第一位で四捨五入
Math.ceil(n); // 少数第一位で切り上げ
Math.floor(n); // 少数第一位で切り捨て
(double)(Math.round(a*10))/10; // 小数点第二位で四捨五入
(Math.round(a*10))/10; // 小数点第二位で切り上げ
(Math.round(a*10))/10; // 小数点第二位で切り捨て
List<Integer> intList=Arrays.stream(strArray)
    .map(Integer::parseInt)
    .collect(Collectors.toList());
System.out.print((int)(m*((double)n/100)+m)); // %
~~~