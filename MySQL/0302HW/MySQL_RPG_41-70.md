## [MySQL(RPG).](https://joytas.net/programming/mysql/mysql_rpg)
#### LEVEL4
41. 戦闘中にアイテム「女神の祝福」を使ったところ、全員のHPとMPがそれまでの値に対して3割りほど回復した。該当するデータを更新する。ただし、端数は四捨五入すること。  
[Tips]  
四捨五入は以下の関数を用いる
	1. ROUND(数値を表す列,有効とする桁数)
	1. 有効桁が正の場合は少数部の桁数、負の場合は整数部の桁数  
[例]
	1. ROUND(3.141592,2) -->3.14
	1. ROUND(380,-2) -->400
	~~~mysql
	myslq code
	~~~
1. next
