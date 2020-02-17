# MySQL
## mysql --version
mysql  Ver 15.1 Distrib 10.4.11-MariaDB, for Win64 (AMD64)
> XAMPPのMySQLはMariaDB 10.4.11
## [CREATE DATABASE.](https://mariadb.com/docs/reference/es/sql-statements/CREATE_DATABASE/)
~~~mysql
CREATE [OR REPLACE] {DATABASE | SCHEMA} [IF NOT EXISTS] db_name
    [create_specification] ...

create_specification:
    [DEFAULT] CHARACTER SET [=] charset_name
  | [DEFAULT] COLLATE [=] collation_name
  | COMMENT [=] 'comment'
~~~
~~~mysql
CREATE DATABASE db_name
DEFAULT CHARACTER SET utf8mb4;
~~~
## [DROP DATABASE.](https://mariadb.com/docs/reference/es/sql-statements/DROP_DATABASE/)
~~~mysql
DROP {DATABASE | SCHEMA} [IF EXISTS] db_name
~~~
~~~mysql
DROP DATABASE IF EXISTS db_name;
~~~
## [CREATE TABLE.](https://mariadb.com/docs/reference/es/sql-statements/CREATE_TABLE/)
~~~musql
CREATE [OR REPLACE] [TEMPORARY] TABLE [IF NOT EXISTS] tbl_name
    (create_definition,...) [table_options    ]... [partition_options]
CREATE [OR REPLACE] [TEMPORARY] TABLE [IF NOT EXISTS] tbl_name
    [(create_definition,...)] [table_options   ]... [partition_options]
    select_statement
CREATE [OR REPLACE] [TEMPORARY] TABLE [IF NOT EXISTS] tbl_name
   { LIKE old_table_name | (LIKE old_table_name) }

select_statement:
    [IGNORE | REPLACE] [AS] SELECT ...   (Some legal select statement)
~~~
~~~mysql
CREATE TABLE tbl_name(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30),
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
DROP [TEMPORARY] TABLE [IF EXISTS] [/*COMMENT TO SAVE*/]
    tbl_name [, tbl_name] ...
    [WAIT n|NOWAIT]
    [RESTRICT | CASCADE]
~~~
~~~mysql
DROP TABLE IF EXISTS tbl_name;
~~~
## [INSERT.](https://mariadb.com/docs/reference/es/sql-statements/INSERT/)  
Adds a row or rows of data to table.
~~~mysql
INSERT [LOW_PRIORITY | DELAYED | HIGH_PRIORITY] [IGNORE]
 [INTO] tbl_name [PARTITION (partition_list)] [(col,...)]
 {VALUES | VALUE} ({expr | DEFAULT},...),(...),...
 [ ON DUPLICATE KEY UPDATE
   col=expr
     [, col=expr] ... ] [RETURNING select_expr 
      [, select_expr ...]]
~~~
~~~mysql
INSERT INTO tbl_name(id,name,depart,age,updated)
VALUES(1,'山田太郎','営業部',40,'2014-12-01');

INSERT INTO tbl_name(name,age)
VALUES ('鈴木さくら',25);

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
Retrieves data from one or more tables.
~~~mysql
SELECT
    [ALL | DISTINCT | DISTINCTROW]
    [HIGH_PRIORITY]
    [STRAIGHT_JOIN]
    [SQL_SMALL_RESULT] [SQL_BIG_RESULT] [SQL_BUFFER_RESULT]
    [SQL_CACHE | SQL_NO_CACHE] [SQL_CALC_FOUND_ROWS]
    select_expr [, select_expr ...]
    [ FROM table_references
      [WHERE where_condition]
      [GROUP BY {col_name | expr | position} [ASC | DESC], ... [WITH ROLLUP]]
      [HAVING where_condition]
      [ORDER BY {col_name | expr | position} [ASC | DESC], ...]
      [LIMIT {[offset,] row_count | row_count OFFSET offset}]
      procedure|[PROCEDURE procedure_name(argument_list)]
      [INTO OUTFILE 'file_name' [CHARACTER SET charset_name] [export_options]

INTO DUMPFILE 'file_name'	INTO var_name [, var_name] ]
      [[FOR UPDATE | LOCK IN SHARE MODE] [WAIT n | NOWAIT] ] ]

export_options:
    [{FIELDS | COLUMNS}
        [TERMINATED BY 'string']
        [[OPTIONALLY] ENCLOSED BY 'char']
        [ESCAPED BY 'char']
    ]
    [LINES
        [STARTING BY 'string']
        [TERMINATED BY 'string']
    ]
~~~
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
## [UPDATE.](https://mariadb.com/docs/reference/es/sql-statements/UPDATE/)
~~~mysql
UPDATE [LOW_PRIORITY] [IGNORE] table_reference 
  [PARTITION (partition_list)]
  SET col1={expr1|DEFAULT} [,col2={expr2|DEFAULT}] ...
  [WHERE where_condition]
  [ORDER BY ...]
  [LIMIT row_count]
~~~
~~~mysql
/*鈴木さくらの部署を人事部に変更*/
UPDATE members SET depart='人事部'
WHERE name='鈴木さくら';
/*鈴木さくらの部署を人事部に変更,年齢を1歳あげる*/
UPDATE members SET depart='人事部',age=age+1
WHERE name='鈴木さくら';
~~~
## [DELETE.](https://mariadb.com/docs/reference/es/sql-statements/DELETE/)
#### Single-table syntax:
~~~mysql
DELETE [LOW_PRIORITY] [QUICK] [IGNORE] 
    FROM tbl_name [PARTITION (partition_list)]
    [WHERE where_condition]
    [ORDER BY ...]
    [LIMIT row_count]
    [RETURNING select_expr 
      [, select_expr ...]]
~~~mysql
DELETE FROM members WHERE id=3;
~~~
## [COUNT().](https://mariadb.com/docs/reference/es/functions/COUNT/)
Returns the number of values in the given expression.
~~~mysql
/*集計関数。結果は基本1行*/
/*count(*) 登録データ件数*/
SELECT count(*) FROM members;
 
/*avg(age) 年齢の平均*/
SELECT avg(age) FROM members;
 
/*max(age)　年齢の最大*/
SELECT max(age) FROM members;
 
/*min(age)*　年齢の最小/
SELECT min(age) FROM members;
 
/*sum(age)*　年齢の合計/
SELECT sum(age) FROM members;
~~~
## Link
[wiki MySQL.](https://ja.wikipedia.org/wiki/MySQL)  
[wiki MariaDB.](https://ja.wikipedia.org/wiki/MariaDB)  
[MariaDB Reference.](https://mariadb.com/docs/reference/)  
[MySQL-1日目(基礎文法1).](https://joytas.net/programming/mysql/mysql01)  
[MySQL-2日目(基本文法1演習).](https://joytas.net/programming/mysql/mysql02)
## Other
[Defines all Languages known to GitHub](https://github.com/github/linguist/blob/master/lib/linguist/languages.yml).
