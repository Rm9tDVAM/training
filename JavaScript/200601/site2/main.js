'use strict';
window.onload=function(){
	const ans=Math.floor(Math.random()*100)+1;
	console.log(ans);
	const userInput=document.getElementById('userInput');
	const bt=document.getElementById('bt');
	const list=document.getElementById('list');
	let count=1;
	bt.addEventListener('click',function(){
		let li=document.createElement('li');
		let userAns=userInput.value;
		userAns=Number(userAns);
		if(userAns===ans){
			li.textContent=`${count++}回目:${userAns} 正解!!`;
		}else if(userAns>ans){
			li.textContent=`${count++}回目:${userAns} もっと下だよ`;
		}else{
			li.textContent=`${count++}回目:${userAns} もっと上だよ`;
		}
		list.appendChild(li);
	});
};
