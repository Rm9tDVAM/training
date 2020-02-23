## [MySQL(RPG).](https://joytas.net/programming/mysql/mysql_rpg)
#### 準備
1. 以下のようにデータベースを作成する。
	~~~mysql
	create database rpg_app
	default character set utf8;
	~~~
1. 以下のようにパーティーテーブルを作成し、データを挿入する。
	~~~mysql
	create table パーティー(
	id char(3),
	名称 varchar(20),
	職業コード char(2),
	hp int,
	mp int,
	状態コード char(2)
	);

	insert into パーティー values
	('C01','ミナト','01',89,35,'00'),
	('C02','アサカ','11',74,66,'00');
	~~~
1. 以下のようにイベントテーブルを作成し、データを挿入する。
1. 以下のように経験イベントテーブルを作成し、データを挿入する。
1. 以下のようにコードテーブルを作成し、データを挿入する。
1. 上記４つのテーブルを使って以下の問に答えよ。
#### ここから問題
1. 主人公のパーティにいるキャラクターの全データをパーティーテーブルから抽出せよ。
	~~~mysql
	select * from パーティー
	~~~
	~~~mysql
	id	名称	職業コード	hp	mp	状態コード	
	C01	ミナト	01		89	35	00	
	C02	アサカ	11		74	66	00	
	~~~
1. パーティーテーブルから、名称、HP､MPの一覧を取得する。各見出しは次のように表示すること。
	~~~mysql
	select 名称 as 名前,hp as 現在のHP,mp as 現在のMP from パーティー
	~~~
	~~~mysql
	名前	現在のHP	現在のMP	
	ミナト	89		35	
	アサカ	74		66	
	~~~

1. cw
	~~~mysql
	~~~
	~~~mysql
	~~~
