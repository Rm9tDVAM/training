## JavaScript
#### promptによるユーザ入力
~~~javascript
let input=prompt("input");
if(isNaN(input)){
	console.log(input+100);
	console.log('isNaNで文字かどうか判定し、文字列連結');
}else{
	if(parseInt(input)===100){
		console.log('100が入力された');
	}
	console.log(parseInt(input)+100);
}
~~~
input abc
~~~javascript
abc100
isNaNで文字かどうか判定し、文字列連結
~~~
input 100
~~~javascript
100が入力された
200
~~~

