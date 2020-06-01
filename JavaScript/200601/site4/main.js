'use strict';
window.onload=function(){
	class Menu{
		constructor(name,price,cal){
			this.name=name;
			this.price=price;
			this.cal=cal;
		}
	}
	const name=document.getElementById('name');
	const price=document.getElementById('price');
	const cal=document.getElementById('cal');
	const total=document.getElementById('total');
	const bt=document.getElementById('bt');
	const table=document.getElementById('table');
	let ls=[];
	bt.addEventListener('click',()=>{
		let menu=new Menu(name.value,price.value,cal.value);
		ls.push(menu);
		let tr=document.createElement('tr');
		let td=document.createElement('td');
		td.textContent=menu.name;
		tr.appendChild(td);
		td=document.createElement('td');
		td.textContent=menu.price;
		tr.appendChild(td);
		td=document.createElement('td');
		td.textContent=menu.cal;
		tr.appendChild(td);
		table.appendChild(tr);
		total.textContent=`全${ls.length}件`
	});
};
