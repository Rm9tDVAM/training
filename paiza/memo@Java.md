# memo
~~~java
// List ( add,set,get,size,isEmpty,contains,indexOf,remove )
List<Integer> iList=Arrays.stream(str.split(" "))
    .map(Integer::parseInt)
    .sorted() // 昇順
    .sorted(Comparator.reverseOrder()) // 降順
    .collect(Collectors.toList());
List<Integer> iList = sList.stream()
    .map(Integer::parseInt)
    .collect(Collectors.toList());
Collections.sort(iList); // 昇順
Collections.reverse(iList); // 逆順
Collections.max(iList);
// Map ( put,get,size,isEmpty,containsKey,containsValue,keyset )
Map<key型,value型> map=new HashMap<>();
// List<Entry<String,Integer>>
List<Entry<String,Integer>> lEnt=new ArrayList<Entry<String,Integer>>(map.entrySet());
Collections.sort(lEnt,new Comparator<Entry<String,Integer>>(){
    public int compare(Entry<String,Integer>obj1,Entry<String,Integer>obj2){
        return obj1.getValue().compareTo(obj2.getValue()); // 昇順
        return obj2.getValue().compareTo(obj1.getValue()); // 降順
    }
});
for(Entry<String,Integer>entry:lEnt){
    System.out.println(entry.getKey());
}
// charAt
str.charAt(i)==('char')
str.charAt(str.length()-n); // 後ろからn番文字
// contains
str.contains("String") // 含まれるかboolで返す
// double
double min=1.7976931348623157E308;
// indexOf
str.indexOf("String") // インデックスを返す
// int
int min=2147483647;
// Integer
Integer.parseInt(str,2); // 2-> 10
Integer.parseInt(obj[i].toString())
String str=Integer.toBinaryString(n); // 10-> 2
// Math
Math.ceil(n); // 少数第一位で切り上げ
Math.floor(n); // 少数第一位で切り捨て
Math.round(n); // 小数点第一位で四捨五入
(Math.ceil(a*10))/10; // 小数点第二位で切り上げ
(Math.floor(a*10))/10; // 小数点第二位で切り捨て
(double)(Math.round(a*10))/10; // 小数点第二位で四捨五入
// matches
matches("[aiueo]")
// replace
str.replace("String","String");
str.replaceAll("[^0-9]","");
// substring
String str="abcde";
System.out.println(str.substring(0,1)); //a
System.out.println(str.substring(1,2)); //b
System.out.println(str.substring(2,3)); //c
System.out.println(str.substring(str.length()-2,str.length()-1)); //d
System.out.println(str.substring(str.length()-1)); //e
// split
.split(Pattern.quote("."));
// 割合
n%100-n%10; // n=999, 90-9=90
((int)(n*(d/100))); // パーセント
(int)(m*((double)n/100)+m); // パーセント
// other
String.valueOf(n).length() // int nのlength
~~~