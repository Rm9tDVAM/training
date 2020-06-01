'use strict';
window.onload=function(){
	const msg=document.getElementById('msg');
	msg.addEventListener('click',()=>{
		msg.textContent='World';
	});
};
