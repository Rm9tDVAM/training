## JavaScript
#### promptによるユーザ入力
~~~javascript
let list=[];
while(true){
	let input=prompt("input num,99 break");
	if(parseInt(input)===99){
		break;
	}
	if(isNaN(input)){
		input+='と入力されました'
			console.log(input);
		console.log('isNaNで文字かどうか判定し、文字列連結し3回表示');
		for(let i=0;i<3;i++){
			console.log(i+1+'回目:'+input);
		}
	}else{
		if(parseInt(input)===10){
			console.log('10が入力された');
		}else if(input<10){
			console.log('10より小さいと0までカウントダウン');
			while(input>0){
				console.log(input);
				input--;
			}
		}else{
			console.log('10以上の場合は配列に入れる');
			list.push(input);
			console.log(list);
			list.sort();
			console.log(list);
			console.log('listをsort()した');
			if(list.length>3){
				console.log('要素が3より大きいのでshift()');
				let temp=list.shift();
				console.log('shiftされた値:'+temp);
				console.log(list);
			}
		}
	}
}
~~~
input abc
~~~javascript
abc100
isNaNで文字かどうか判定し、文字列連結
~~~
input 10
~~~javascript
10が入力された
20
~~~

