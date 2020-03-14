##JavaScript
#### promptによるユーザ入力
~~~javascript
let input=prompt("input");
if(isNaN(input)){
	console.log(input+100);
	console.log('文字列連結される');
}else{
	console.log(parseInt(input)+100);
}
~~~
input abc
~~~javascript
abc100
~~~
input 100
~~~javascript
200
~~~

