# MySQL
## mysql --version
mysql  Ver 15.1 Distrib 10.4.11-MariaDB, for Win64 (AMD64)
> XAMPPのMySQLはMariaDB 10.4.11
## Words
#### dump  
データベースの内容を丸ごと複製したファイルのこと
#### RDBMS(relational database management system)  
表形式でデータを格納した複数のテーブルを関連付けすることができるDBMSのこと
## CRUD
|名前|操作|SQL|
|---|---|---|
|Create|生成|INSERT|
|Read|読み取り|SELECT|
|Update|更新|UPDATE|
|Delete|削除|DELETE|
## SELECT文の評価順序
|順番|句|内容|
|:---:|---|---|
|1|FROM|実行対象のテーブルを指定|
|2|ON|結合の条件|
|3|JOIN|テーブルの結合|
|4|WHERE|テーブルに対してレコードの抽出条件を指定|
|5|GROUP BY|レコードをグループ化|
|6|HAVING|グループ化した結果に対して抽出条件を指定|
|7|SELECT|取得(表示)する列を指定|
|8|DISTINCT|重複レコードを1つにまとめる|
|9|ORDER BY|取得した列を並び替える|
|10|TOP(LIMIT)|先頭から指定した行数を取得|
## SELECT文のフローチャート
![select](https://i.stack.imgur.com/MIbtv.png"select")
## [CREATE DATABASE.](https://mariadb.com/docs/reference/es/sql-statements/CREATE_DATABASE/)
~~~mysql
CREATE DATABASE db_name
DEFAULT CHARACTER SET utf8mb4;
~~~
## [DROP DATABASE.](https://mariadb.com/docs/reference/es/sql-statements/DROP_DATABASE/)
~~~mysql
DROP DATABASE IF EXISTS db_name;
~~~
## [CREATE TABLE.](https://mariadb.com/docs/reference/es/sql-statements/CREATE_TABLE/)
~~~mysql
CREATE TABLE tbl_name(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) not null,
depart VARCHAR(20) DEFAULT '無所属',
age INT,
updated DATE
);
~~~
- id INT PRIMARY KEY AUTO_INCREMENT  
Tableを作るときにINT idの値を自動インクリメントする
- depart VARCHAR(20) DEFAULT '無所属',  
Tableを作るときにdepartに入力がなければデフォルトとして無所属が入る
	> Defaultが設定されていない場合はNULLが入る
- [VARCHAR.](https://mariadb.com/docs/reference/es/data-types/VARCHAR/)  
Variable-length **string** with limit up to 64,535 bytes
- [INT.](https://mariadb.com/docs/reference/es/data-types/INT/)  
**Integer** from -2147483648 to 2147483647 when signed, or from 0 to 4294967295 when unsigned.
- [DATA.](https://mariadb.com/docs/reference/es/data-types/DATE/#es-data-types-date)
~~~sql
CREATE TABLE t1 (d DATE);
INSERT INTO t1 VALUES ("2010-01-12"), ("2011-2-28"), ('120314'),('13*04*21');
SELECT * FROM t1;
+------------+
| d          |
+------------+
| 2010-01-12 |
| 2011-02-28 |
| 2012-03-14 |
| 2013-04-21 |
+------------+
~~~
- [Data Types in 10.4.](https://mariadb.com/docs/reference/es10.4/data-types/#data-types-in-10-4)  
データタイプの一覧

## [DROP TABLE.](https://mariadb.com/docs/reference/es/sql-statements/DROP_TABLE/)
~~~mysql
DROP TABLE IF EXISTS tbl_name;
~~~
## [INSERT.](https://mariadb.com/docs/reference/es/sql-statements/INSERT/)  
~~~mysql
INSERT INTO tbl_name(name,age)VALUES
('鈴木さくら',25);

INSERT INTO tbl_name(id,name,depart,age,updated)
VALUES(1,'山田太郎','営業部',40,'2014-12-01');

/*全カラムに対して挿入はカラムの並び省略可)*/
INSERT INTO tbl_name
VALUES(3,'佐藤次郎','人事部',35,'2015-01-15');

/*連続入力可*/
INSERT INTO tbl_name(name,depart,age)VALUES
('田中一郎','経理部',48),
('山口弘子','営業部',28),
('渡辺順','人事部',58),
('中島博之','総務部',49),
('山下圭吾','経理部',23);
~~~
## [SELECT.](https://mariadb.com/docs/reference/es/sql-statements/SELECT/)
~~~mysql
/*全件抽出*/
SELECT * FROM tbl_name;

/*nameカラム取得*/
SELECT name FROM tbl_name;

/*name,ageカラム取得*/
SELECT name,age FROM tbl_name;

/*WHERE句で絞り込み*/
SELECT * FROM tbl_name WHERE age=25;
SELECT * FROM tbl_name WHERE age>25;
SELECT * FROM tbl_name WHERE age>=25;
//<>でない
SELECT * FROM tbl_name WHERE age<>25;
SELECT * FROM tbl_name WHERE age>25 AND age <40
SELECT * FROM tbl_name WHERE age>25 OR updated <='2015-01-15'
//BETWEEN(端の値含む)
SELECT * FROM tbl_name WHERE updated BETWEEN '2015-01-15' AND '2015-02-15'
//INの中にあるデータを抽出
SELECT * FROM tbl_name WHERE depart IN('営業部','人事部');
//null判定
SELECT * FROM tbl_name WHERE updated IS NULL;
SELECT * FROM tbl_name WHERE updated IS NOT NULL;
//あいまい検索
SELECT * FROM tbl_name WHERE name LIKE '鈴木%';
SELECT * FROM tbl_name WHERE name LIKE '%木%';
SELECT * FROM tbl_name WHERE name LIKE '%田';
//北が含まれない
SELECT * FROM tbl_name WHERE name NOT LIKE '%北%';

/*ORDER BY （並び替え)*/
//年齢降順
SELECT * FROM tbl_name ORDER BY age DESC;
//updatedがnullでないデータを年齢昇順
SELECT * FROM tbl_name WHERE updated IS NOT NULL
ORDER BY age ASC;
//ORDER BYは複数指定できる
SELECT * FROM tbl_name ORDER BY age DESC,name ASC;
//LIMIT 件数を制限できる
SELECT * FROM tbl_name ORDER BY age DESC LIMIT 3;

/*LIMIT と合わせてOFFSET指定＊/
//２番目に年齢を高い人から3人取得
SELECT * FROM tbl_name ORDER BY age DESC LIMIT 3 OFFSET 1;
~~~
#### 内部結合 JOIN
それぞれのテーブルの指定した列の値が一致するデータだけを取得
~~~mysql
/*cdsの目蒲線物語や、categoryのDANCEは表示されていない*/
SELECT * FROM cds
JOIN categories
ON cds.cat_id=categories.id;
~~~
#### 左結合 LEFT JOIN
左結合はそれぞれのテーブルの指定した列の値が一致するデータに加えて基準テーブルにしか存在しないデータについても取得する(下の例だとcdsのデータは全部表示する)
~~~mysql
/*cdsの目蒲線物語が表示される*/
SELECT * FROM cds
LEFT JOIN categories
ON cds.cat_id=categories.id;
~~~
#### 右結合 RIGHT JOIN
右結合はそれぞれのテーブルの指定した列の値が一致するデータに加えて結合するテーブルにしか存在しないデータについても取得する(下の例だとcategoriesのデータは全部表示する)
~~~mysql
/*categoriesのDANCEが表示される*/
SELECT * FROM cds
RIGHT JOIN categories
ON cds.cat_id=categories.id;
~~~
#### 取得カラムの指定
~~~mysql
/*原則テーブル名.カラム名で指定する*/
SELECT cds.title,categories.category,cds.price FROM cds
LEFT JOIN categories
ON cds.cat_id=categories.id;
~~~
#### テーブルに別名
~~~mysql
/*テーブルに別名をつけることができ、以後その文脈中では別名をつかう(元のテーブル名はつかえない)*/
SELECT cd.title,cat.category,cd.price FROM cds AS cd
LEFT JOIN categories AS cat
ON cd.cat_id=cat.id;
~~~
## [UPDATE.](https://mariadb.com/docs/reference/es/sql-statements/UPDATE/)
~~~mysql
/*鈴木さくらの部署を人事部に変更*/
UPDATE members SET depart='人事部'
WHERE name='鈴木さくら';
/*鈴木さくらの部署を人事部に変更,年齢を1歳あげる*/
UPDATE members SET depart='人事部',age=age+1
WHERE name='鈴木さくら';
~~~
## [DELETE.](https://mariadb.com/docs/reference/es/sql-statements/DELETE/)
~~~mysql
DELETE FROM members WHERE id=3;
~~~
## [COUNT().](https://mariadb.com/docs/reference/es/functions/COUNT/)
~~~mysql
SELECT count(*) FROM members;
~~~
## [AVG().](https://mariadb.com/docs/reference/es/functions/AVG/)
~~~mysql
SELECT avg(age) FROM members;
~~~
~~~mysql
floor(avg(salary))as 平均給与,
~~~
floorで括ることで小数点以下切り捨て
~~~mysql
/*max(age)　年齢の最大*/
SELECT max(age) FROM members;
 
/*min(age)*　年齢の最小*/
SELECT min(age) FROM members;
 
/*sum(age)*　年齢の合計*/
SELECT sum(age) FROM members;
~~~
## [REPLACE().](https://mariadb.com/docs/reference/es/functions/REPLACE/)
全角を半角に置換
~~~mysql
update syain set name=replace(name,'　',' ');
~~~
## [TIMESTAMPDIFF().](https://mariadb.com/docs/reference/es/functions/TIMESTAMPDIFF/)
~~~mysql
timestampdiff(year,birth,curdate())as age,
~~~
curdate()は本日の日付
> dete(now())という方法もあります
## Other
以下の出力を求めよ。なおランクは
10000000以上がS  
6000000以上がA  
その他がB  
とする。
~~~mysql
select name as 名前,
salary*12 as 年収,
case when salary*12>=10000000 then 'S' 
when salary*12>=6000000 then 'A' 
else 'B' 
END as ランク from syain order by salary desc;
~~~
	- 内部結合 JOIN(それぞれのテーブルの指定した列の値が一致するデータだけを取得)
	~~~mysql
	/*cdsの目蒲線物語や、categoryのDANCEは表示されていない*/
	SELECT * FROM cds
	JOIN categories
	ON cds.cat_id=categories.id;
	~~~
	- 左結合 LEFT JOIN(左結合はそれぞれのテーブルの指定した列の値が一致するデータに加えて基準テーブルにしか存在しないデータについても取得する(下の例だとcdsのデータは全部表示する))
	~~~mysql
	/*cdsの目蒲線物語が表示される*/
	SELECT * FROM cds
	LEFT JOIN categories
	ON cds.cat_id=categories.id;
	~~~
	- 右結合 RIGHT JOIN(右結合はそれぞれのテーブルの指定した列の値が一致するデータに加えて結合するテーブルにしか存在しないデータについても取得する(下の例だとcategoriesのデータは全部表示する))
	~~~mysql
	/*categoriesのDANCEが表示される*/
	SELECT * FROM cds
	RIGHT JOIN categories
	ON cds.cat_id=categories.id;
	~~~
	- 取得カラムの指定
	~~~mysql
	/*原則テーブル名.カラム名で指定する*/
	SELECT cds.title,categories.category,cds.price FROM cds
	LEFT JOIN categories
	ON cds.cat_id=categories.id;
	~~~
	- テーブルに別名
	~~~mysql
	/*テーブルに別名をつけることができ、以後その文脈中では別名をつかう(元のテーブル名はつかえない)*/
	SELECT cd.title,cat.category,cd.price FROM cds AS cd
	LEFT JOIN categories AS cat
	ON cd.cat_id=cat.id;
	~~~
---
### 2限目(10:00-10:50)
1. [MySQL-4日目(基本文法2演習).](https://joytas.net/programming/mysql/mysql04)
	- salesとempsを内部結合。売上を記録した人の名前を抽出。重複は除外すること。
		~~~mysql
		SELECT DISTINCT e.name 
		FROM sales AS s 
		JOIN emps AS e 
		ON s.emp_id=e.id
		~~~
	- depsとempsを内部結合し年齢昇順に抽出せよ。ただし年齢は30歳未満。取得項目は、名前、年齢、部署名とする。年齢が同じ場合は部署名を辞書順に並べること。
		~~~mysql
		SELECT e.name AS 名前,e.age AS 年齢,d.dep AS 部署名
		FROM deps AS d
		JOIN emps AS e
		ON d.id=e.dep_id
		WHERE e.age<30
		ORDER BY age ASC,dep ASC;
		~~~
	- salesとempsとdepsを内部結合し、取得項目名を日付,名前,年齢,部署名,売上高として全件抽出せよ。
		~~~mysql
		SELECT s.s_date AS 日付,
		e.name AS 名前,
		e.age AS 年齢,
		d.dep AS 部署名,
		s.sale AS 売上高
		FROM sales AS s
		JOIN emps AS e
		ON s.emp_id=e.id
		JOIN deps AS d
		ON e.dep_id = d.id;
		~~~
	- salesとempsとdepsを左結合し、総売上個人ランキングトップ３を降順で取得する。取得項目は名前、部署名、総売上とする。
		~~~mysql
		SELECT e.name AS 名前,
		d.dep AS 部署名,
		sum(s.sale) AS 総売上 
		FROM sales AS s
		LEFT JOIN emps AS e
		ON s.emp_id=e.id
		LEFT JOIN deps AS d
		ON e.dep_id=d.id
		GROUP BY s.emp_id
		ORDER BY 総売上 DESC
		LIMIT 3;
		~~~
## Link
[wiki MySQL.](https://ja.wikipedia.org/wiki/MySQL)  
[wiki MariaDB.](https://ja.wikipedia.org/wiki/MariaDB)  
[MySQL 5.6 Reference.](https://dev.mysql.com/doc/refman/5.6/ja/)  
[MariaDB Reference.](https://mariadb.com/docs/reference/)  
[MySQL-1日目(基礎文法1).](https://joytas.net/programming/mysql/mysql01)  
[MySQL-2日目(基本文法1演習).](https://joytas.net/programming/mysql/mysql02)  
[MySQL-3日目(基礎文法2).](https://joytas.net/programming/mysql/mysql03)
## Other
[Defines all Languages known to GitHub](https://github.com/github/linguist/blob/master/lib/linguist/languages.yml).
