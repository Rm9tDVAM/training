# MySQL
## mysql --version
mysql  Ver 15.1 Distrib 10.4.11-MariaDB, for Win64 (AMD64)
> 中身はMariaDB 10.4.11
## CREATE DATABASE
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
DEFAULT CHARACTER SET utf8;
~~~
## データベース削除
~~~mysql
DROP DATABASE IF EXISTS myapp;
~~~
## テーブル作成
~~~mysql
CREATE TABLE members(
id INT PRIMARY KEY AUTO_INCREMENt,
name VARCHAR(30),
depart VARCHAR(20) DEFAULT '無所属',
age INt,
updated DATE
);
~~~
## テーブル削除
~~~mysql
DROP TABLE IF EXISTS members;
~~~
## Link
[wiki MySQL](https://ja.wikipedia.org/wiki/MySQL).  
[wiki MariaDB](https://ja.wikipedia.org/wiki/MariaDB).  
[MariaDB Reference](https://mariadb.com/docs/reference/).
## Other
[Defines all Languages known to GitHub](https://github.com/github/linguist/blob/master/lib/linguist/languages.yml).
