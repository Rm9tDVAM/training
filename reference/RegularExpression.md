# Regular Expression
## ¿¿¿¿¿¿¿¿¿
1. ¿¿¿¿¿:¿¿¿¿¿¿¿¿¿¿¿¿¿
	~~~
	String s="java";
	s.matches("Java")	//true
	s.matches("JavaJava")	//false
	s.matches("java")	//false
	~~~
1. ¿¿¿¿:¿¿¿1¿¿¿¿¿¿¿
	~~~
	"Java".matches("J.va")	//true
	~~~
1. ¿¿¿¿¿¿:¿¿¿¿¿¿0¿¿¿¿¿¿¿¿
	~~~
	"Jaaaaava".matches("Ja*va")	//true
	"¿¿¿xx019".matches(".*")	//true
	~~~
1. ¿¿¿¿:¿¿¿¿¿¿¿¿
	|¿¿¿¿¿¿|¿¿|
	|---|---|
	|{n}|¿¿¿¿¿¿n¿¿¿¿¿¿|
	|{n,}|¿¿¿¿¿¿n¿¿¿¿¿¿¿¿|
	|{n,m}|¿¿¿¿¿¿n¿¿¿m¿¿¿¿¿¿¿¿|
	|?|¿¿¿¿¿¿0¿¿¿¿1¿¿¿¿¿¿|
	|+|¿¿¿¿¿¿1¿¿¿¿¿¿¿¿|
1. ¿¿¿¿:¿¿¿¿¿¿¿  
	"UR[LIN]"¿¿¿¿¿¿¿¿¿¿1¿¿¿¿U¿2¿¿¿¿R¿3¿¿¿¿L¿I¿N¿¿¿¿¿¿¿¿¿¿¿
1. ¿¿¿¿¿¿¿¿¿¿:¿¿¿¿¿¿¿¿¿¿¿¿
	~~~
	"url".matches("[a-z]{3}")	//true
	~~~
	¿¿¿¿¿¿¿¿¿¿¿¿
	|¿¿¿¿¿¿|¿¿|
	|---|---|
	|\d|¿¿¿¿¿¿¿([0-9]¿¿¿)|
	|\w|¿¿¿¿¿¿¿¿¿¿¿¿([a-zA-Z_0-9]¿¿¿)|
	|\s|¿¿¿¿(¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿)
1. ¿¿¿¿¿¿¿:¿¿¿¿¿
	~~~
	^j.*p$
	~~~
	¿¿¿¿¿j¿¿¿¿¿¿¿¿p¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿
1. split¿¿¿¿:¿¿¿¿¿¿
	~~~java
	public class Main{
		public static void main(String[] args){
			String s="abc,def:ghi";
			String[] words=s.split("[,:]");
			for(String w:words){
				System.out.print(w+"->");
			}
		}
	}
	~~~
	~~~java
	abc->def->ghi->
	~~~
1. replaceAll¿¿¿¿:¿¿¿¿¿¿
	~~~java
	public class Main{
		public static void main(String[] args){
			String s="abc,def:ghi";
			String w=s.replaceAll("[beh]","x");
			System.out.println(w);
		}
	}
	~~~
	~~~java
	aXc,dXf:gXg
	~~~
## Link
[wiki ³‹K•\Œ».](https://ja.wikipedia.org/wiki/%E6%AD%A3%E8%A6%8F%E8%A1%A8%E7%8F%BE)
